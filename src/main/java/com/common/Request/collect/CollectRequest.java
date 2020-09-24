package com.common.Request.collect;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by Zhouxin on 2020/8/26;
 * 将接口接收到的请求数据封装在这里
 */
@Data
public class CollectRequest {

    @ApiModelProperty("收集人名称")
    private String collectName;

    @ApiModelProperty("收集人条形码")
    private String collectCode;

    @ApiModelProperty("所属医院id")
    private String hospitalId;

}