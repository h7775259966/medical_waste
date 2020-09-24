package com.common.Response.system.user;

import com.common.Response.ResponseResult;
import com.common.Response.ResultCode;
import com.module.entity.system.user.User;
import lombok.Data;

/**
 * Created by mrt on 2018/3/31.
 * 将用户相关数据封装在这里，然后返回给前端
 */
@Data
public class UserResult extends ResponseResult {
    User user;
    public UserResult(ResultCode resultCode, User user) {
        super(resultCode);
        this.user = user;
    }
}
