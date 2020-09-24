package com.common.Response.system.user;


import com.common.Response.ResultCode;
import lombok.ToString;

/**
 * Created by mrt on 2018/3/5.
 */
@ToString
public enum UserCode implements ResultCode {
    CMS_INSERT_FALSE(false,24001,"新增用户失败！"),
    CMS_GET_ISNULL(false,24002,"操作失败,用户id不存在！"),
    CMS_NAME_REPETITION(false,24003,"用户名已存在,无法新增！"),
    CMS_UPDATE_FALSE(false,24004,"修改用户失败！"),
    CMS_DELETE_FALSE(false,24005,"删除用户失败！"),
    CMS_ASSIGNROLES_FALSE(false,24006,"用户添加角色失败！"),
    CMS_EDITSTATUS_FALSE(false,24007,"修改用户状态失败！"),
    CMS_LOGIN_FALSE(false,24008,"登录认证失败！"),
    CMS_LOGIN_TRUE(true,24009,"登录认证成功！"),
    UNAUTHENTICATED(false,24010,"您还未登录!"),
    UNAUTHORISE(false,24011,"权限不足!"),
    CMS_PRFILE_TRUE(true,24012,"根据token获取用户权限成功!"),
    CMS_PRFILE_FALSE(false,24013,"根据token获取用户权限失败!");

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
