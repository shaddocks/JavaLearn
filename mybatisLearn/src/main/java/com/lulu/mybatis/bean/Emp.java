package com.lulu.mybatis.bean;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Emp {
    private String empId;
    private String deptId;
    private Dept dept;
}
