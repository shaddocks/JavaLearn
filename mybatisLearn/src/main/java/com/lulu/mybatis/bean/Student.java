package com.lulu.mybatis.bean;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Student {

    private String firstName;
    private String lastName;
    private String id;
    private Integer gender;
    private Integer age;
    private String desc;
}
