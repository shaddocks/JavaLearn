package com.lulu.mybatis.mapper;

import com.lulu.mybatis.bean.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DynamicSQLMapper {

    List<Emp> getEmpByCondition(Emp emp);

    List<Emp> getEmpByChoose(Emp emp);

    //这个会放到map中，故无法直接通过形参名获取
    List<Emp> getEmpsByList(@Param("ids") List<String> ids);
}
