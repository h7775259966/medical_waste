package com.common.Request.trash.trashOutMessage;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;


/**
 * Created zx on 2020/10/12;
 */

@Data
@ToString
public class TrashOutMessageRequest {


    @ApiModelProperty("开始时间")
    private String startTime;

    @ApiModelProperty("结束时间")
    private String endTime;

    @ApiModelProperty("信息类型")
    private String type;
}
