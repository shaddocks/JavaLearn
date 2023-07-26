package com.lulu.spring.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Country {
    private String countryId;
    private String countryName;
    private Integer regionId;

    public void initMethod() {
        System.out.println("Country 初始化");
    }
    public void destroyMethod() {
        System.out.println("Country 销毁");
    }
}
