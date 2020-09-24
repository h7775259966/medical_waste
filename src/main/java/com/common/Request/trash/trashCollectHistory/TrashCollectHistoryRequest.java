package com.common.Request.trash.trashCollectHistory;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * Created by huangbotao on 2020/9/22;
 */
@Data
@ToString
public class TrashCollectHistoryRequest {

    @ApiModelProperty("开始时间")
    private String startTime;

    @ApiModelProperty("结束时间")
    private String endTime;

    @ApiModelProperty("出库状态")
    private String status;

    @ApiModelProperty("部门")
    private String department;

    @ApiModelProperty("科室")
    private String office;

    @ApiModelProperty("废物类型")
    private String trash;

    @ApiModelProperty("条形编码")
    private String code;


}
