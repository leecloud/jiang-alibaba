package com.jiang.api;

/**
 * @ClassName IErrorCode
 * @Description: 封装API的错误码
 * @Author jiang
 * @Date 2020/8/18 11:42
 **/
public interface IErrorCode {

    long getCode();

    String getMessage();
}
