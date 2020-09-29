package com.common.Response.hospitalSwitch;


import com.common.Response.ResultCode;
import lombok.ToString;

/**
 * Created by mrt on 2018/3/5.
 */
@ToString
public enum HospitalSwitchCode implements ResultCode {
    CMS_GET_ISNULL(false,24002,"操作失败,医院id不存在！"),
    CMS_SAVE_TRUE(false,24004,"保存功能开关成功！"),
    CMS_SAVE_FALSE(false,24005,"保存功能开关失败！");

    //操作代码
    boolean success;
    //操作代码
    int code;
    //提示信息
    String message;
    private HospitalSwitchCode(boolean success, int code, String message){
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
