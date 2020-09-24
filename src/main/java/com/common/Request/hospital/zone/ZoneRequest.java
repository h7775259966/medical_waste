package com.common.Request.hospital.zone;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by Zhouxin on 2020/8/24;
 * 将接口接收到的请求数据封装在这里
 */
@Data
public class ZoneRequest {

    @ApiModelProperty("区县级单位名称")
    private String zoneName;

    @ApiModelProperty("区县级单位编号")
    private String zoneNumber;

}