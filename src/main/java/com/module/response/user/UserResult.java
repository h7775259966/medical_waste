package com.module.response.user;

import com.common.Response.ResponseResult;
import com.common.Response.ResultCode;
import com.module.entity.user.User;
import lombok.Data;

/**
 * Created by huangbotao on 2020/9/1;
 */
@Data
public class UserResult extends ResponseResult {
    User user;
    public UserResult(ResultCode resultCode, User user) {
        super(resultCode);
        this.user = user;
    }
}
