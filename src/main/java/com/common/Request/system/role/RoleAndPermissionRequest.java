package com.common.Request.system.role;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * Created by Zhouxin on 2020/9/18;
 * 将接口接收到的请求数据封装在这里
 */
@Data
@ToString
public class RoleAndPermissionRequest {

    @ApiModelProperty("角色id")
    private String roleId;

    @ApiModelProperty("权限id集合")
    private List<String> PermissionId;

}