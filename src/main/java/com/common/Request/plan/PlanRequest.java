package com.common.Request.plan;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by huangbotao on 2020/8/27;
 */
@Data
public class PlanRequest {

    @ApiModelProperty("计划id")
    private String planId;


}
