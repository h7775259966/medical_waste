package com.common.Response.plan;

import com.common.Response.ResultCode;
import lombok.ToString;

/**
 * Created by huangbotao on 2020/8/27;
 */
@ToString
public enum PlanCode implements ResultCode {
    CMS_INSERT_FALSE(false,24001,"新增计划失败！"),
    CMS_GET_ISNULL(false,24002,"操作失败,计划id不存在！"),
    CMS_NAME_REPETITION(false,24003,"计划名称已存在,无法新增！"),
    CMS_UPDATE_FALSE(false,24004,"修改计划失败！"),
    CMS_DELETE_FALSE(false,24005,"删除计划失败！"),
    CMS_EDITSTATUS_FALSE(false,24006,"修改计划状态失败！");

    //操作代码
    boolean success;
    //操作代码
    int code;
    //提示信息
    String message;
    private PlanCode(boolean success, int code, String message){
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
