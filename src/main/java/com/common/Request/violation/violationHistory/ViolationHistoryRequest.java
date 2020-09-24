package com.common.Request.violation.violationHistory;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * Created by huangbotao on 2020/9/21;
 */

@Data
@ToString
public class ViolationHistoryRequest {

    @ApiModelProperty("查询开始时间")
    private String startTime;

    @ApiModelProperty("查询结束时间")
    private String endTime;
}
