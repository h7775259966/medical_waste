package com.common.Request.system.user;

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
public class UserAndRoleRequest {

    @ApiModelProperty("用户id")
    private String userId;

    @ApiModelProperty("角色id集合")
    private List<String> roleId;

}