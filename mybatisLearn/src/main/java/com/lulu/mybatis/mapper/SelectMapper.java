package com.lulu.mybatis.mapper;

import com.lulu.mybatis.bean.Student;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SelectMapper {
    @MapKey("id")
    Map<String, Student> getStudentById(@Param("id") String id);

    List<Student> getAllStudent();

    Integer getCount();

    @MapKey("id")
    Map<String, Object> getAttribute(@Param("id") String id);
}
