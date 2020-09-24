package com.common.Request.system.permission;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by Zhouxin on 2020/9/18;
 * 将接口接收到的请求数据封装在这里
 */
@Data
public class PermissionRequest {

    @ApiModelProperty("权限类型")
    private String type;

    @ApiModelProperty("pid")
    private String pid;

    @ApiModelProperty("可见状态")
    private String enVisible;

}