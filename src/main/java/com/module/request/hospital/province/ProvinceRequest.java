package com.module.request.hospital.province;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by Zhouxin on 2020/8/24;
 * 将接口接收到的请求数据封装在这里
 */
@Data
public class ProvinceRequest {

    @ApiModelProperty("省级单位名称")
    private String provinceName;

    @ApiModelProperty("省级单位编号")
    private String provinceNumber;

}