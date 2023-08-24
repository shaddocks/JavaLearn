package com.lulu.mybatis.mapper;

import com.lulu.mybatis.bean.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper {

    Emp getEmpById(@Param("id") String id);

    List<Emp> getDeptAndEmpByIdStepTwo(@Param("id") String id);
}
