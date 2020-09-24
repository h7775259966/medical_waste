package com.common.Request.replenish.replenish;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by Zhouxin on 2020/8/24;
 * 将接口接收到的请求数据封装在这里
 */
@Data
public class ReplenishRequest {

    @ApiModelProperty("补录id")
    private String replenishId;

    @ApiModelProperty("补录审核状态")
    private String checkStatusprivate;

    @ApiModelProperty("出入库状态")
    private String warehouseStatusprivate;

}