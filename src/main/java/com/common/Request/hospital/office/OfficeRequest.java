package com.common.Request.hospital.office;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by Zhouxin on 2020/8/24;
 * 将接口接收到的请求数据封装在这里
 */
@Data
public class OfficeRequest {

    @ApiModelProperty("所属部门id")
    private String departmentId;

    @ApiModelProperty("科室名称")
    private String officeName;

}