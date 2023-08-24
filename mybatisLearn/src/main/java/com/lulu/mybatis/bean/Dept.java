package com.lulu.mybatis.bean;

import lombok.Data;

import java.util.List;

@Data
public class Dept {
    private String deptId;
    private String deptName;

    private List<Emp> emps;
}
