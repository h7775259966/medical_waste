package com.module.request.hospital;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by Zhouxin on 2020/8/24;
 * 将接口接收到的请求数据封装在这里
 */
@Data
public class HospitalRequest {

    @ApiModelProperty("医院id")
    private String hospitalId;

    @ApiModelProperty("医院名称")
    private String hospitalName;

    @ApiModelProperty("医院编号")
    private String hospitalNumber;

}