package com.module.response.warnLeakage;


import com.common.Response.ResultCode;
import lombok.ToString;

/**
 * Created by mrt on 2018/3/5.
 */
@ToString
public enum WarnLeakageCode implements ResultCode {
    CMS_INSERT_FALSE(false,24001,"新增泄漏预警失败！"),
    CMS_GET_ISNULL(false,24002,"操作失败,泄漏预警id不存在！"),
    CMS_NAME_REPETITION(false,24003,"泄漏预警名称已存在,无法新增！"),
    CMS_UPDATE_FALSE(false,24004,"修改泄漏预警失败！"),
    CMS_DELETE_FALSE(false,24005,"删除泄漏预警失败！");

    //操作代码
    boolean success;
    //操作代码
    int code;
    //提示信息
    String message;
    private WarnLeakageCode(boolean success, int code, String message){
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
