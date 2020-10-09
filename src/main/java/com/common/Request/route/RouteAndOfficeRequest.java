package com.common.Request.route;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * Created by huangbotao on 2020/9/30;
 */
@Data
@ToString
public class RouteAndOfficeRequest {

    @ApiModelProperty("路线id")
    private String routeId;

    @ApiModelProperty("科室集合")
    private List<String>  officeId;
}
