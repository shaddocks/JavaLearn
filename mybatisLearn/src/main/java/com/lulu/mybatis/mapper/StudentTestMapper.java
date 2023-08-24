package com.lulu.mybatis.mapper;

import com.lulu.mybatis.bean.Student;

import java.util.List;

public interface StudentTestMapper {

    Integer insertStudent();
    Integer updateStudent();
    Integer deleteStudent();
    Student getStudentById();
    List<Student> getAllStudent();

}
