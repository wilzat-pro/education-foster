package org.crown.project.webapp.domain;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "tb_student")
public class StudentBaseInfoModel {

    /**
     * value与数据库主键列名一致，若实体类属性名与表主键列名一致可省略value
     */
    @TableId(value = "tb_id",type = IdType.AUTO)//指定自增策略
    private Integer id;


    /**
     * 学号
     */
    private int studentId;

    /**
     * 若没有开启驼峰命名，或者表中列名不符合驼峰规则，可通过该注解指定数据库表中的列名，exist标明数据表中有没有对应列
     * 生源类别
     */
    @TableField(value = "source_in",exist = true)
    private String sourceInType;

    /**
     * 省
     */
    private String province;

    /**
     * 市
     */
    private String city;

    /**
     * 县
     */
    private String county;

    /**
     * 姓名
     */
    private String studentName;

    /**
     * 性别
     */
    private String sex;

    /**
     * 出生日期
     */
    private DateTime birthday;

    /**
     * 政治面貌
     */
    private String politicFace;

    /**
     * 民族
     */
    private String race;

    /**
     * 中学
     */
    private String midSchool;

    /**
     * 家庭地址
     */
    private String familyAddr;

    /**
     * 联系电话
     */
    private String telephone;

    /**
     * 高考成绩
     */
    private String score;

    /**
     * 专业
     */
    private String domainIn;

    /**
     * 班级
     */
    private String classIn;

    /**
     * 学院
     */
    private String deptName;

    public StudentBaseInfoModel () {
    }

    /******************************** get方法 ****************************************/
    public int getStudentId() {
        return studentId;
    }

    public String getSourceInType() {
        return sourceInType;
    }

    public String getProvince() {
        return province;
    }

    public String getCity() {
        return city;
    }

    public String getCounty() {
        return county;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getSex() {
        return sex;
    }

    public DateTime getBirthday() {
        return birthday;
    }

    public String getPoliticFace() {
        return politicFace;
    }

    public String getRace() {
        return race;
    }

    public String getMiddleSchool() {
        return midSchool;
    }

    public String getFamilyAddress() {
        return familyAddr;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getScore() {
        return score;
    }

    public String getDomainIn() {
        return domainIn;
    }

    public String getClassIn() {
        return classIn;
    }

    public String getDeptName() { return deptName; }

    /***************************** set方法 *******************************************/
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setSourceInType(String sourceInType) {
        this.sourceInType = sourceInType;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setBirthday(DateTime birthday) {
        this.birthday = birthday;
    }

    public void setPoliticFace(String politicFace) {
        this.politicFace = politicFace;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public void setMiddleSchool(String midSchool) {
        this.midSchool = midSchool;
    }

    public void setFamilyAddress(String familyAddr) {
        this.familyAddr = familyAddr;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public void setDomainIn(String domainIn) {
        this.domainIn = domainIn;
    }

    public void setClassIn(String classIn) {
        this.classIn = classIn;
    }

    public void setDeptName(String deptName) { this.deptName = deptName; }
}
