package com.common.Response.system.user;

import com.common.Response.ResponseResult;
import com.common.Response.ResultCode;
import lombok.Data;

/**
 * Created by mrt on 2018/3/31.
 * 将登录返回的token相关数据封装在这里，然后返回给前端
 */
@Data
public class LoginResult extends ResponseResult {
    String token;
    public LoginResult(ResultCode resultCode, String token) {
        super(resultCode);
        this.token = token;
    }
}
