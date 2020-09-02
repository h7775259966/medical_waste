package com.module.request.replenish.replenishCheck;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by Zhouxin on 2020/8/24;
 * 将接口接收到的请求数据封装在这里
 */
@Data
public class ReplenishCheckRequest {

    @ApiModelProperty("补录审核id")
    private String replenishCheckId;

    @ApiModelProperty("补录id")
    private String replenishId;

    @ApiModelProperty("处理状态")
    private String replenishCheckStatus;

}