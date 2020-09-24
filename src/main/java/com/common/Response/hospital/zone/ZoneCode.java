package com.common.Response.hospital.zone;


import com.common.Response.ResultCode;
import lombok.ToString;

/**
 * Created by mrt on 2018/3/5.
 */
@ToString
public enum ZoneCode implements ResultCode {
    CMS_INSERT_FALSE(false,24001,"新增区县级单位失败！"),
    CMS_GET_ISNULL(false,24002,"操作失败,区县级单位id不存在！"),
    CMS_NAME_REPETITION(false,24003,"区县级单位名称已存在,无法新增！"),
    CMS_UPDATE_FALSE(false,24004,"修改区县级单位失败！"),
    CMS_DELETE_FALSE(false,24005,"删除区县级单位失败！");

    //操作代码
    boolean success;
    //操作代码
    int code;
    //提示信息
    String message;
    private ZoneCode(boolean success, int code, String message){
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
