package com.lulu.mybatis.mapper;

import com.lulu.mybatis.bean.Emp;
import com.lulu.mybatis.bean.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SQLMapper {

    List<Student> getStudentByLike(@Param("lastName") String lastName);

    Emp getEmpByIdOne(@Param("id") String id);

    Emp getEmpByIdTwo(@Param("id") String id);
}
