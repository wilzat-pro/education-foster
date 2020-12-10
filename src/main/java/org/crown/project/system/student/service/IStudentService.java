package org.crown.project.system.student.service;

import java.util.List;

import org.crown.framework.service.BaseService;
import org.crown.project.system.student.domain.Student;
import org.crown.project.system.user.domain.User;

/**
 * 用户 业务层
 *
 * @author Crown
 */
public interface IStudentService extends BaseService<Student> {

    /**
     * 根据条件分页查询用户列表
     *
     * @param student 学生信息
     * @return 学生信息集合信息
     */
    List<Student> selectStudentList(Student student);


    /**
     * 通过姓名查询用户
     *
     * @param studentName 学生姓名
     * @return 用户对象信息
     */
    Student selectStudentByStudentName(String studentName);

    /**
     * 通过学号查询用户
     *
     * @param studentId 学号
     * @return 用户对象信息
     */
    Student selectStudentByStudentId(Long studentId);

    /**
     * 通过手机号码查询用户
     *
     * @param phoneNumber 手机号码
     * @return 用户对象信息
     */
    Student selectStudentByPhoneNumber(String phoneNumber);

    /**
     * 通过邮箱查询用户
     *
     * @param email 邮箱
     * @return 用户对象信息
     */
    Student selectStudentByEmail(String email);

    /**
     * 批量删除用户信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     * @throws Exception 异常
     */
    boolean deleteStudentByIds(String ids);

    /**
     * 保存用户信息
     *
     * @param student 用户信息
     * @return 结果
     */
    boolean insertStudent(Student student);

    /**
     * 保存用户信息
     *
     * @param student 用户信息
     * @return 结果
     */
    boolean updateStudent(Student student);


    /**
     * 校验学号是否唯一
     *
     * @param studentId 学号
     * @return 结果
     */
    boolean checkStudentIDUnique(Long studentId);

    /**
     * 校验手机号码是否唯一
     *
     * @param student 用户信息
     * @return 结果
     */
    boolean checkPhoneUnique(Student student);

    /**
     * 校验email是否唯一
     *
     * @param student 用户信息
     * @return 结果
     */
    boolean checkEmailUnique(Student student);

    /**
     * 根据用户ID查询用户所属角色组
     *
     * @param studentId 用户ID
     * @return 结果
     */
    String selectStudentRoleGroup(Long studentId);

    /**
     * 根据用户ID查询用户所属岗位组
     *
     * @param studentId 用户ID
     * @return 结果
     */
    String selectStudentPostGroup(Long studentId);

    /**
     * 导入用户数据
     *
     * @param studentList        用户数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @return 结果
     */
    String importStudent(List<Student> studentList, Boolean isUpdateSupport);

    /**
     * 用户状态修改
     *
     * @param student 用户信息
     * @return 结果
     */
    boolean changeStatus(Student student);
}
