package com.common.Response.violation.violationStandard;

import com.common.Response.ResultCode;
import lombok.ToString;

/**
 * Created by huangbotao on 2020/8/27;
 */
@ToString
public enum ViolationStandardCode implements ResultCode {
    CMS_INSERT_FALSE(false,24001,"新增违规标准失败！"),
    CMS_GET_ISNULL(false,24002,"操作失败,违规标准id不存在！"),
    CMS_NAME_REPETITION(false,24003,"违规标准名称已存在,无法新增！"),
    CMS_UPDATE_FALSE(false,24004,"修改违规标准失败！"),
    CMS_DELETE_FALSE(false,24005,"删除违规标准失败！"),
    CMS_EDITSTATUS_FALSE(false,24006,"修改违规标准状态失败！");

    //操作代码
    boolean success;
    //操作代码
    int code;
    //提示信息
    String message;
    private ViolationStandardCode(boolean success, int code, String message){
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
