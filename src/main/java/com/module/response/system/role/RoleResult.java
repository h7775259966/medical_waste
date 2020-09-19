package com.module.response.system.role;

import com.common.Response.ResponseResult;
import com.common.Response.ResultCode;
import com.module.entity.system.role.Role;
import lombok.Data;

/**
 * Created by mrt on 2018/3/31.
 * 将角色相关数据封装在这里，然后返回给前端
 */
@Data
public class RoleResult extends ResponseResult {
    Role role;
    public RoleResult(ResultCode resultCode, Role role) {
        super(resultCode);
        this.role = role;
    }
}
