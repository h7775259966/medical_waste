package com.module.request.warn.warnPush;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by Zhouxin on 2020/8/24;
 * 将接口接收到的请求数据封装在这里
 */
@Data
public class WarnPushRequest {

    @ApiModelProperty("预警推送开始时间")
    private String startTime;

    @ApiModelProperty("预警推送结束时间")
    private String endTime;

    @ApiModelProperty("预警类型id")
    private String warnTypeId;


}