package com.common.Request.warn.warnOutWeight;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by Zhouxin on 2020/8/24;
 * 将接口接收到的请求数据封装在这里
 */
@Data
public class WarnOutWeightRequest {

    @ApiModelProperty("出库重量预警id")
    private String warnOutWeightId;

    @ApiModelProperty("处理状态")
    private String status;


}