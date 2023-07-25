package com.lulu.tools.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ResultCodeEnum {
    SUCCESS(0, "成功"),
    FAIL(-1, "失败"),
    //...
    ERROR(500, "服务器内部错误");

    private final int code;
    private final String msg;
}
