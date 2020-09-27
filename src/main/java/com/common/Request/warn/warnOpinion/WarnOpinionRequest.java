package com.common.Request.warn.warnOpinion;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by Zhouxin on 2020/8/24;
 * 将接口接收到的请求数据封装在这里
 */
@Data
public class WarnOpinionRequest {

    @ApiModelProperty("开始时间")
    private String startTime;

    @ApiModelProperty("结束时间")
    private String endTime;

    @ApiModelProperty("预警类型id")
    private String warnTypeId;


}