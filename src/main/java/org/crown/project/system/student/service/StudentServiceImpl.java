package org.crown.project.system.student.service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;

import org.crown.common.annotation.DataScope;
import org.crown.common.utils.StringUtils;
import org.crown.common.utils.TypeUtils;
import org.crown.common.utils.security.ShiroUtils;
import org.crown.framework.enums.ErrorCodeEnum;
import org.crown.framework.exception.Crown2Exception;
import org.crown.framework.service.impl.BaseServiceImpl;
import org.crown.framework.shiro.service.PasswordService;
import org.crown.framework.utils.ApiAssert;
import org.crown.project.system.config.service.IConfigService;
import org.crown.project.system.post.domain.Post;
import org.crown.project.system.post.service.IPostService;
import org.crown.project.system.role.domain.Role;
import org.crown.project.system.role.service.IRoleService;
import org.crown.project.system.student.domain.Student;
import org.crown.project.system.student.mapper.StudentMapper;
import org.crown.project.system.user.domain.User;
import org.crown.project.system.user.domain.UserPost;
import org.crown.project.system.user.domain.UserRole;
import org.crown.project.system.user.service.IUserPostService;
import org.crown.project.system.user.service.IUserRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;

/**
 * 用户 业务层处理
 *
 * @author Crown
 */
@Service
public class StudentServiceImpl extends BaseServiceImpl<StudentMapper, Student> implements IStudentService {

    private static final Logger log = LoggerFactory.getLogger(StudentServiceImpl.class);

    @Autowired
    private IConfigService configService;

    @Override
    @DataScope
    public List<Student> selectStudentList(Student student) {
        // 生成数据权限过滤条件
        return baseMapper.selectStudentList(student);
    }

    @Override
    public Student selectStudentByStudentName(String studentName) {
        return baseMapper.selectStudentByStudentName(studentName);
    }

    @Override
    public Student selectStudentByStudentId(Long studentId) {
        return baseMapper.selectStudentById(studentId);
    }

    @Override
    public Student selectStudentByPhoneNumber(String phoneNumber) {
        return baseMapper.selectStudentByPhoneNumber(phoneNumber);
    }


    @Override
    public boolean deleteStudentByIds(String ids) {

        List<Long> studentIds = StringUtils.split2List(ids, TypeUtils::castToLong);
        return delete().in(Student::getStudentId, studentIds).execute();
    }

    @Override
    @Transactional
    public boolean insertStudent(Student student) {
        // 新增用户信息
        save(student);
        return true;
    }

    @Override
    @Transactional
    public boolean updateStudent(Student student) {

        return updateById(student);
    }


    @Override
    public boolean checkStudentIDUnique(Long studentId) {
        return query().eq(Student::getStudentId, studentId).nonExist();
    }

    @Override
    public boolean checkPhoneUnique(Student student) {

        Long studentId = student.getStudentId();
        Student info = query().select(Student::getStudentId, Student::getTelephone).eq(Student::getTelephone, student.getTelephone()).getOne();
        return Objects.isNull(info) || info.getStudentId().equals(studentId);
    }

    @Override
    public boolean checkEmailUnique(Student student) {

        Long studentId = student.getStudentId();
        Student info = query().select(Student::getStudentId, Student::getEmail).eq(Student::getEmail, student.getEmail()).getOne();
        return Objects.isNull(info) || info.getStudentId().equals(studentId);
    }

    @Override
    public String selectStudentRoleGroup(Long studentId) {
        return null;
    }

    @Override
    public String selectStudentPostGroup(Long studentId) {
        return null;
    }

    @Override
    public String importStudent(List<Student> studentList, Boolean isUpdateSupport) {
        if (CollectionUtils.isNotEmpty(studentList)) {
            throw new Crown2Exception(HttpServletResponse.SC_BAD_REQUEST, "导入用户数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        String operName = ShiroUtils.getLoginName();
        String password = configService.getConfigValueByKey("sys.user.initPassword");
        for (Student student : studentList) {
            try {
                // 验证是否存在这个用户
                Student stu = baseMapper.selectStudentById(student.getStudentId());
                if (StringUtils.isNull(stu)) {
                    this.insertStudent(student);
                    successNum++;
                    successMsg.append("<br/>").append(successNum).append("、账号 ").append(student.getStudentName()).append(" 导入成功");
                } else if (isUpdateSupport) {
                    this.updateStudent(student);
                    successNum++;
                    successMsg.append("<br/>").append(successNum).append("、账号 ").append(student.getStudentName()).append(" 更新成功");
                } else {
                    failureNum++;
                    failureMsg.append("<br/>").append(failureNum).append("、账号 ").append(student.getStudentName()).append(" 已存在");
                }
            } catch (Exception e) {
                failureNum++;
                String msg = "<br/>" + failureNum + "、账号 " + student.getStudentName() + " 导入失败：";
                failureMsg.append(msg).append(e.getMessage());
                log.error(msg, e);
            }
        }
        if (failureNum > 0) {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new Crown2Exception(HttpServletResponse.SC_BAD_REQUEST, failureMsg.toString());
        } else {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    }

    @Override
    public boolean changeStatus(Student student) {
        return updateById(student);
    }

    @Override
    public Student selectStudentByEmail(String email) {
        return baseMapper.selectStudentByEmail(email);
    }
}







