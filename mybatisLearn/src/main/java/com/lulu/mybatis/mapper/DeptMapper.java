package com.lulu.mybatis.mapper;

import com.lulu.mybatis.bean.Dept;
import org.apache.ibatis.annotations.Param;

public interface DeptMapper {

    Dept getDeptById(@Param("id") String id);

    Dept getDeptAndEmpById(@Param("id") String id);

    Dept getDeptAndEmpByIdStepOne(@Param("id") String id);
}
