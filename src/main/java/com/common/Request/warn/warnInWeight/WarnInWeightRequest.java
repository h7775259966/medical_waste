package com.common.Request.warn.warnInWeight;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by Zhouxin on 2020/8/24;
 * 将接口接收到的请求数据封装在这里
 */
@Data
public class WarnInWeightRequest {

    @ApiModelProperty("入库重量预警id")
    private String warnInWeightId;

    @ApiModelProperty("处理状态")
    private String status;


}