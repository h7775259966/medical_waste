package com.common.Request.warn;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by Zhouxin on 2020/8/24;
 * 将接口接收到的请求数据封装在这里
 */
@Data
public class WarnInOvertimeRequest {

    @ApiModelProperty("入库超时预警id")
    private String warnInOvertimeId;

    @ApiModelProperty("处理状态")
    private String status;


}