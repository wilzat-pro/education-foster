package org.crown.project.system.student.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.crown.framework.mapper.BaseMapper;
import org.crown.project.system.student.domain.Student;
import org.crown.project.system.user.domain.User;

/**
 * 用户表 数据层
 *
 * @author Crown
 */
@Mapper
public interface StudentMapper extends BaseMapper<Student> {

    /**
     * 根据条件分页查询用户列表
     *
     * @param student 用户信息
     * @return 用户信息集合信息
     */
    List<Student> selectStudentList(Student student);

    /**
     * 通过用户名查询用户
     *
     * @param studentName 用户名
     * @return 用户对象信息
     */
    Student selectStudentByStudentName(String studentName);

    /**
     * 通过手机号码查询用户
     *
     * @param telephone 手机号码
     * @return 用户对象信息
     */
    Student selectStudentByPhoneNumber(String telephone);

    /**
     * 通过邮箱查询用户
     *
     * @param email 邮箱
     * @return 用户对象信息
     */
    Student selectStudentByEmail(String email);

    /**
     * 通过用户ID查询用户
     *
     * @param studentId 用户ID
     * @return 用户对象信息
     */
    Student selectStudentById(Long studentId);

}
