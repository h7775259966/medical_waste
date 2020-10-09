package com.common.Response.route;

import com.common.Response.ResultCode;
import lombok.ToString;

/**
 * Created by huangbotao on 2020/9/30;
 */
@ToString
public enum RouteCode implements ResultCode {
    CMS_INSERT_FALSE(false,24001,"新增线路失败！"),
    CMS_GET_ISNULL(false,24002,"操作失败,线路id不存在！"),
    CMS_NAME_REPETITION(false,24003,"线路名已存在,无法新增！"),
    CMS_UPDATE_FALSE(false,24004,"修改线路失败！"),
    CMS_DELETE_FALSE(false,24005,"删除线路失败！"),
    CMS_ASSIGNROLES_FALSE(false,24006,"线路添加科室失败！");

    //操作代码
    boolean success;
    //操作代码
    int code;
    //提示信息
    String message;
    private RouteCode(boolean success, int code, String message){
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
