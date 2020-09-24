package com.common.Request.system.role;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by Zhouxin on 2020/9/18;
 * 将接口接收到的请求数据封装在这里
 */
@Data
public class UserRequest {

    @ApiModelProperty("用户名")
    private String userName;

    @ApiModelProperty("所属单位id")
    private String unitId;

    @ApiModelProperty("所属单位级别(省市区医院)")
    private String grade;

}