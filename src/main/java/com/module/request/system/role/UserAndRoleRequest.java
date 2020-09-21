package com.module.request.system.role;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * Created by Zhouxin on 2020/9/18;
 * 将接口接收到的请求数据封装在这里
 */
@Data
public class UserAndRoleRequest {

    @ApiModelProperty("用户id")
    private String userId;

    @ApiModelProperty("权限id集合")
    private List<String> roleId;

}