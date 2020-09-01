package com.module.response.user;

import com.common.Response.ResultCode;
import lombok.ToString;

/**
 * Created by huangbotao on 2020/9/1;
 */
@ToString
public enum UserCode implements ResultCode {
    CMS_INSERT_FALSE(false,24001,"新增用户失败！"),
    CMS_GET_ISNULL(false,24002,"操作失败,用户id不存在！"),
    CMS_NAME_REPETITION(false,24003,"用户名称已存在,无法新增！"),
    CMS_UPDATE_FALSE(false,24004,"用户或密码错误！"),
    CMS_DELETE_FALSE(false,24005,"删除用户失败！");

    //操作代码
    boolean success;
    //操作代码
    int code;
    //提示信息
    String message;
    private UserCode(boolean success, int code, String message){
        this.success = success;
        this.code = code;
        this.message = message;
    }

    @Override
    public boolean success() {
        return success;
    }

    @Override
    public int code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }
}
