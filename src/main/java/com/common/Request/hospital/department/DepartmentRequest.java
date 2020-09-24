package com.common.Request.hospital.department;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by Zhouxin on 2020/8/24;
 * 将接口接收到的请求数据封装在这里
 */
@Data
public class DepartmentRequest {

    @ApiModelProperty("部门名称")
    private String departmentName;

}