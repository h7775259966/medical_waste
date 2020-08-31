package com.module.request.warnOutOvertime;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by Zhouxin on 2020/8/24;
 * 将接口接收到的请求数据封装在这里
 */
@Data
public class WarnOutOvertimeRequest {

    @ApiModelProperty("出库超时预警id")
    private String warnOutOvertimeId;

    @ApiModelProperty("处理状态")
    private String status;


}