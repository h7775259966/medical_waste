package com.common.Request.system.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by Zhouxin on 2020/9/18;
 * 将接口接收到的请求数据封装在这里
 */
@Data
public class LoginRequest {

    @ApiModelProperty("登录名")
    private String userName;

    @ApiModelProperty("登录密码")
    private String passWord;

}