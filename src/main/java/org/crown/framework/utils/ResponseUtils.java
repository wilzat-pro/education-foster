/*
 * Copyright (c) 2018-2022 Caratacus, (caratacus@qq.com).
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without riction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package org.crown.framework.utils;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.crown.common.cons.APICons;
import org.crown.common.utils.IpUtils;
import org.crown.common.utils.TypeUtils;
import org.crown.common.utils.security.ShiroUtils;
import org.crown.framework.enums.ErrorCodeEnum;
import org.crown.framework.model.ErrorCode;
import org.crown.framework.responses.ApiResponses;
import org.crown.framework.responses.FailedResponse;
import org.crown.framework.servlet.wrapper.ResponseWrapper;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;

import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.google.common.base.Throwables;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * response输出工具类
 *
 * @author Caratacus
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Slf4j
public abstract class ResponseUtils {

    /**
     * Portal输出json字符串
     *
     * @param response
     * @param obj      需要转换JSON的对象
     */
    public static void writeValAsJson(HttpServletRequest request, ResponseWrapper response, Object obj) {
        String userId = null;
        String loginName = null;
        try {
            userId = TypeUtils.castToString(ShiroUtils.getUserId());
        } catch (Exception ignored) {
        }
        try {
            loginName = TypeUtils.castToString(ShiroUtils.getLoginName());
        } catch (Exception ignored) {
        }
        int status = HttpServletResponse.SC_OK;
        if (Objects.nonNull(response)) {
            ErrorCode errorCode = response.getErrorCode();
            status = errorCode.getStatus();
        }
        LogUtils.printLog(status, (Long) request.getAttribute(APICons.API_BEGIN_TIME),
                userId,
                loginName,
                request.getParameterMap(),
                request.getAttribute(APICons.API_REQUEST_BODY),
                (String) request.getAttribute(APICons.API_REQURL),
                (String) request.getAttribute(APICons.API_ACTION_METHOD),
                request.getMethod(),
                IpUtils.getIpAddr(request),
                obj);
        if (ObjectUtils.isNotNull(response, obj)) {
            response.writeValueAsJson(obj);
        }
    }

    /**
     * 打印日志信息但是不输出到浏览器
     *
     * @param request
     * @param obj
     */
    public static void writeValAsJson(HttpServletRequest request, Object obj) {
        writeValAsJson(request, null, obj);
    }

    /**
     * 获取异常信息
     *
     * @param exception
     * @return
     */
    public static FailedResponse exceptionMsg(FailedResponse failedResponse, Exception exception) {
        if (exception instanceof MethodArgumentNotValidException) {
            StringBuilder builder = new StringBuilder("校验失败:");
            List<ObjectError> allErrors = ((MethodArgumentNotValidException) exception).getBindingResult().getAllErrors();
            allErrors.stream().findFirst().ifPresent(error -> {
                builder.append(((FieldError) error).getField()).append("字段规则为").append(error.getDefaultMessage());
                failedResponse.setMsg(error.getDefaultMessage());
            });
            failedResponse.setException(builder.toString());
            return failedResponse;
        } else if (exception instanceof MissingServletRequestParameterException) {
            StringBuilder builder = new StringBuilder("参数字段");
            MissingServletRequestParameterException ex = (MissingServletRequestParameterException) exception;
            builder.append(ex.getParameterName());
            builder.append("校验不通过");
            failedResponse.setException(builder.toString());
            failedResponse.setMsg(ex.getMessage());
            return failedResponse;
        } else if (exception instanceof MissingPathVariableException) {
            StringBuilder builder = new StringBuilder("路径字段");
            MissingPathVariableException ex = (MissingPathVariableException) exception;
            builder.append(ex.getVariableName());
            builder.append("校验不通过");
            failedResponse.setException(builder.toString());
            failedResponse.setMsg(ex.getMessage());
            return failedResponse;
        } else if (exception instanceof ConstraintViolationException) {
            StringBuilder builder = new StringBuilder("方法.参数字段");
            ConstraintViolationException ex = (ConstraintViolationException) exception;
            Optional<ConstraintViolation<?>> first = ex.getConstraintViolations().stream().findFirst();
            if (first.isPresent()) {
                ConstraintViolation<?> constraintViolation = first.get();
                builder.append(constraintViolation.getPropertyPath().toString());
                builder.append("校验不通过");
                failedResponse.setException(builder.toString());
                failedResponse.setMsg(ex.getMessage());
            }
            return failedResponse;
        }
        failedResponse.setException(TypeUtils.castToString(exception));
        return failedResponse;
    }

    /**
     * 发送错误信息
     *
     * @param request
     * @param response
     * @param code
     */
    public static void sendFail(HttpServletRequest request, HttpServletResponse response, ErrorCode code,
                                Exception exception) {
        if (Objects.nonNull(exception)) {
            if (code.getStatus() < HttpServletResponse.SC_INTERNAL_SERVER_ERROR) {
                log.info("Info: doResolveInfo {}", exception.getMessage());
            } else {
                log.warn("Warn: doResolveException {}", Throwables.getStackTraceAsString(exception));
            }
        }
        ResponseUtils.writeValAsJson(request, getWrapper(response, code), ApiResponses.failure(code, exception));
    }

    /**
     * 发送错误信息
     *
     * @param request
     * @param response
     * @param code
     */
    public static void sendFail(HttpServletRequest request, HttpServletResponse response, ErrorCode code) {
        sendFail(request, response, code, null);
    }

    /**
     * 发送错误信息
     *
     * @param request
     * @param response
     * @param codeEnum
     */
    public static void sendFail(HttpServletRequest request, HttpServletResponse response, ErrorCodeEnum codeEnum) {
        sendFail(request, response, codeEnum.convert(), null);
    }

    /**
     * 发送错误信息
     *
     * @param request
     * @param response
     * @param codeEnum
     * @param exception
     */
    public static void sendFail(HttpServletRequest request, HttpServletResponse response, ErrorCodeEnum codeEnum,
                                Exception exception) {
        sendFail(request, response, codeEnum.convert(), exception);
    }

    /**
     * 获取Response
     *
     * @return
     */
    public static ResponseWrapper getWrapper(HttpServletResponse response, ErrorCode errorCode) {
        return new ResponseWrapper(response, errorCode);
    }
}
