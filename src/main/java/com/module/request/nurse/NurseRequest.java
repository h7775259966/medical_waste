package com.module.request.nurse;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by Zhouxin on 2020/8/26;
 * 将接口接收到的请求数据封装在这里
 */
@Data
public class NurseRequest {

    @ApiModelProperty("护士id")
    private String nurseId;

    @ApiModelProperty("部门id")
    private String departmentId;

    @ApiModelProperty("科室id")
    private String officeId;

}