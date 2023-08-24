package com.lulu.mybatis.mapper;

import com.lulu.mybatis.bean.Student;
import org.apache.ibatis.annotations.Param;

public interface StudentMapper {
    /**
     * 当然也可以自己手动创建一个map传入，直接获取自己设定的键值即可
     * @param id id
     * @return student
     */
    Student getStudentById(@Param("id") String id);

    Integer insertStudent(Student student);
}
