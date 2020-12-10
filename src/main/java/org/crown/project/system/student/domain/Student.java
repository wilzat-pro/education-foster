package org.crown.project.system.student.domain;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.crown.common.annotation.Excel;
import org.crown.common.annotation.Excels;
import org.crown.framework.web.domain.BaseEntity;
import org.crown.project.system.dept.domain.Dept;
import org.crown.project.system.role.domain.Role;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;

import lombok.Getter;
import lombok.Setter;

/**
 * 学生对象
 *
 * @author Crown
 */
@Setter
@Getter
public class Student extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @Excel(name = "学号", prompt = "学生编号")
    @TableId
    private Long studentId;

    /**
     * 用户名称
     */
    @Excel(name = "姓名")
    @Size(max = 30, message = "用户昵称长度不能超过30个字符")
    private String studentName;

    /**
     * 手机号码
     */
    @Excel(name = "手机号码")
    @Size(max = 11, message = "手机号码长度不能超过11个字符")
    private String telephone;

    /**
     * 所在专业
     */
    @Excel(name = "专业")
    private String domainIn;

    /**
     * 班级
     */
    @Excel(name = "班级")
    private String classIn;

    /**
     * 所在学院
     */
    @Excel(name = "所在学院")
    private String deptName;

    /**
     * 生源类别
     */
    @Excel(name = "生源类别")
    private String sourceIn;

    /**
     * 省份
     */
    @Excel(name = "省份")
    private String province;

    /**
     * 城市
     */
    @Excel(name = "城市")
    private String city;

    /**
     * 县
     */
    @Excel(name = "县")
    private String county;

    /**
     * 用户性别
     */
    @Excel(name = "用户性别", readConverterExp = "0=男,1=女,2=未知")
    private String sex;

    /**
     * 出生日期
     */
    @Excel(name = "出生日期", width = 30, dateFormat = "yyyy-MM-dd", type = Excel.Type.EXPORT)
    private Date birthday;

    /**
     * 政治面貌
     */
    @Excel(name = "政治面貌")
    private String politicFace;

    /**
     * race
     */
    @Excel(name = "民族")
    private String race;

    /**
     * 政治面貌
     */
    @Excel(name = "中学")
    private String midSchool;

    /**
     * 家庭地址
     */
    @Excel(name = "家庭地址")
    private String familyAddress;

    /**
     * 邮编
     */
    @Excel(name = "邮编")
    private String post;

    /**
     * 科类
     */
    @Excel(name = "科类")
    private String subjectType;

    /**
     * 高考成绩
     */
    @Excel(name = "高考成绩")
    private float score;

    /**
     * 所在专业id
     */
    private Long deptId;

    /**
     * 部门父ID
     */
    private Long parentId;

    /**
     * 状态字段
     */
    private Integer status;

    /**
     * 用户邮箱
     */
    @Excel(name = "用户邮箱")
    @Email(message = "邮箱格式不正确")
    @Size(max = 50, message = "邮箱长度不能超过50个字符")
    private String email;


}
