package org.crown.project.webapp.mapper;

import org.crown.framework.mapper.BaseMapper;
import org.crown.project.webapp.domain.StudentBaseInfoModel;

public interface IStudentMapper extends BaseMapper<StudentBaseInfoModel> {
    StudentBaseInfoModel getStudent(int stuId);
}
