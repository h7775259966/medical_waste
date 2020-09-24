package com.common.Request.trash.trashOutHistory;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * Created by huangbotao on 2020/9/21;
 */


@Data
@ToString
public class TrashOutHistoryRequest {

    @ApiModelProperty("开始时间")
    private String startTime;

    @ApiModelProperty("结束时间")
    private String endTime;

    @ApiModelProperty("转运公司")
    private String outCompany;
}
