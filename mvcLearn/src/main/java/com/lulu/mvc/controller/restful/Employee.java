package com.lulu.mvc.controller.restful;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Employee {
    private Integer id;
    private String lastName;

    private String email;
    //1 male, 0 female
    private Integer gender;
}
