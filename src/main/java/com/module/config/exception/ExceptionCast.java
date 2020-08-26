package com.module.config.exception;


import com.common.Response.ResultCode;

/**
 * Created by Zhouxin on 2020/8/12;
 * 异常抛出类，用于在业务代码里要抛出异常的地方使用
 *
 */
public class ExceptionCast {

    //使用此静态方法抛出自定义异常
    //自定义异常类继承RuntimeException，
    //我们在业务代码里要抛出异常的地方只需写一行throw new CustomException(resultCode)即可,但是不够规范;
    public static void cast(ResultCode resultCode) {
        throw new CustomException(resultCode);
    }
}