package com.module.request.office;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by Zhouxin on 2020/8/24;
 * 将接口接收到的请求数据封装在这里
 */
@Data
public class OfficeRequest {

    @ApiModelProperty("科室id")
    private String officeId;

    @ApiModelProperty("科室名称")
    private String officeName;

    @ApiModelProperty("科室备注")
    private String remarks;

}