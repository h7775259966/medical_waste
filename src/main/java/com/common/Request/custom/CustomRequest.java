package com.common.Request.custom;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by huangbotao on 2020/9/21;
 */

@Data
public class CustomRequest {


    @ApiModelProperty("查询开始时间")
    private String startTime;

    @ApiModelProperty("查询结束时间")
    private String endTime;

    @ApiModelProperty("医废处置方式")
    private String processingMode;

    @ApiModelProperty("医废类型")
    private String trashType;

}
