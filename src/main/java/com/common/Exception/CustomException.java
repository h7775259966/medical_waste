package com.common.Exception;


import com.common.Response.ResultCode;

/**
 * Created by Zhouxin on 2020/8/12;
 * 自定义异常类
 *
 * 继承RuntimeException而不继承Exception，
 * 是因为我们在业务代码里写RuntimeException对代码没有侵入性，
 * 不用加tyr/cath，只需写一行throw new CustomException(resultCode)即可;
 * 如果继承了Exception的话，则业务代码里抛出异常的地方都要加tyr/cath
 */
public class CustomException extends RuntimeException {

    //存储的返回数值和错误码
    private ResultCode resultCode;

    public CustomException(ResultCode resultCode) {
        //异常信息为错误代码+异常信息
        super("错误代码：" + resultCode.code() + "错误信息：" + resultCode.message());
        this.resultCode = resultCode;
    }

    //用于把错误信息取出来的方法
    public ResultCode getResultCode() {
        return this.resultCode;
    }
}