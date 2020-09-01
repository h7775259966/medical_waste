package com.module.request.warnLeakage;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by Zhouxin on 2020/8/24;
 * 将接口接收到的请求数据封装在这里
 */
@Data
public class WarnLeakageRequest {

    @ApiModelProperty("部门id")
    private String departmentId;

    @ApiModelProperty("科室id")
    private String officeId;

    @ApiModelProperty("处理状态")
    private String status;


}