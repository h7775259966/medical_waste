package com.module.response.system.role;

import com.common.Response.ResponseResult;
import com.common.Response.ResultCode;
import com.module.entity.system.role.PermissionAll;
import lombok.Data;

/**
 * Created by mrt on 2018/3/31.
 * 将权限相关数据封装在这里，然后返回给前端
 */
@Data
public class PermissionResult extends ResponseResult {
    PermissionAll permissionAll;
    public PermissionResult(ResultCode resultCode, PermissionAll permissionAll) {
        super(resultCode);
        this.permissionAll = permissionAll;
    }
}
