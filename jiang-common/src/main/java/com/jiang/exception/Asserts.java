package com.jiang.exception;

import com.jiang.api.IErrorCode;

/**
 * @ClassName Asserts
 * @Description: 断言处理类
 * @Author jiang
 * @Date 2020/8/18 11:40
 **/
public class Asserts {

    public static void fail(String message) {
        throw new ApiException(message);
    }

    public static void fail(IErrorCode errorCode) {
        throw new ApiException(errorCode);
    }
}
