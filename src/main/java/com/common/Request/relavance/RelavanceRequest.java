package com.common.Request.relavance;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by huangbotao on 2020/9/28;
 */
@Data
public class RelavanceRequest {

    @ApiModelProperty("开始时间")
    private String startTime;

    @ApiModelProperty("结束时间")
    private String endTime;
}
