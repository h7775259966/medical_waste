package com.common.Request.hospital.nurse;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by Zhouxin on 2020/8/26;
 * 将接口接收到的请求数据封装在这里
 */
@Data
public class NurseRequest {

    @ApiModelProperty("护士名称")
    private String nurseName;

    @ApiModelProperty("护士条形码")
    private String nurseCode;

    @ApiModelProperty("所属部门id")
    private String departmentId;

    @ApiModelProperty("所属科室id")
    private String officeId;

}