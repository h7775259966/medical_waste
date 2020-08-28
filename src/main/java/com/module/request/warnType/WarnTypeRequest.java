package com.module.request.warnType;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by Zhouxin on 2020/8/24;
 * 将接口接收到的请求数据封装在这里
 */
@Data
public class WarnTypeRequest {

    @ApiModelProperty("预警类型id")
    private String warnTypeId;

    @ApiModelProperty("预警类型")
    private String warnType;


}