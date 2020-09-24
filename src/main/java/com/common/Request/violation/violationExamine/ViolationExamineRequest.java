package com.common.Request.violation.violationExamine;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * Created by huangbotao on 2020/8/28;
 */
@Data
@ToString
public class ViolationExamineRequest {

    @ApiModelProperty("查询开始时间")
    private String startTime;

    @ApiModelProperty("查询结束时间")
    private String endTime;

}
