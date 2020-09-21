package com.module.request.custom;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 自定义查询预警
 * Created by huangbotao on 2020/9/21;
 */
@Data
public class CustomWarnRequest {


    @ApiModelProperty("查询开始时间")
    private String startTime;

    @ApiModelProperty("查询结束时间")
    private String endTime;

    @ApiModelProperty("医废处置方式")
    private String processingMode;

    @ApiModelProperty("预警类型")
    private String warnType;

}
