package com.lulu.tools.common;

import lombok.Getter;
import lombok.NonNull;

import java.io.Serial;
import java.io.Serializable;

@SuppressWarnings("unused")
public class Result<T> implements Serializable {
    @Serial
    private static final long serialVersionUID = 10000000L;

    /**
     * 状态码
     */
    @Getter
    private final int code;

    /**
     * 提示信息
     */
    @Getter
    private final String msg;

    /**
     * 相关数据
     */
    @Getter
    private T data;

    /**
     * 构造器
     * @param code 状态码
     * @param msg 提示信息
     */
    private Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 构造器
     * @param code 状态码
     * @param msg 提示信息
     * @param data 返回数据
     */
    private Result(int code, String msg, @NonNull T data) {
        this(code, msg);
        this.data = data;
    }

    //-----------------common-----------------
    public static <T> Result<T> common(ResultCodeEnum result) {
        return new Result<>(result.getCode(), result.getMsg());
    }
    public static <T> Result<T> common(ResultCodeEnum result, T data) {
        return new Result<>(result.getCode(), result.getMsg(), data);
    }

    //-----------------success-----------------
    public static <T> Result<T> success() {
        return new Result<>(ResultCodeEnum.SUCCESS.getCode(), ResultCodeEnum.SUCCESS.getMsg());
    }
    public static <T> Result<T> success(String msg) {
        return new Result<>(ResultCodeEnum.SUCCESS.getCode(), msg);
    }
    public static <T> Result<T> success(String msg, T data) {
        return new Result<>(ResultCodeEnum.SUCCESS.getCode(), msg, data);
    }
    public static <T> Result<T> success(T data) {
        return new Result<>(ResultCodeEnum.SUCCESS.getCode(), ResultCodeEnum.SUCCESS.getMsg(), data);
    }

    //-----------------fail-----------------
    public static <T> Result<T> fail() {
        return new Result<>(ResultCodeEnum.FAIL.getCode(), ResultCodeEnum.FAIL.getMsg());
    }
    public static <T> Result<T> fail(String msg) {
        return new Result<>(ResultCodeEnum.FAIL.getCode(), msg);
    }
    public static <T> Result<T> fail(String msg, T data) {
        return new Result<>(ResultCodeEnum.FAIL.getCode(), msg, data);
    }
    public static <T> Result<T> fail(T data) {
        return new Result<>(ResultCodeEnum.FAIL.getCode(), ResultCodeEnum.FAIL.getMsg(), data);
    }
}
