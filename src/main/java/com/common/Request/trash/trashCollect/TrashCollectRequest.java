package com.common.Request.trash.trashCollect;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by huangbotao on 2020/8/31;
 */

@Data
@ToString
public class TrashCollectRequest {

    @ApiModelProperty("部门")
    private String departmentName;

    @ApiModelProperty("科室")
    private String officeName;

    @ApiModelProperty("废物类型")
    private String trashType;

    @ApiModelProperty("条形编码")
    private String code;

    @ApiModelProperty("开始时间")
    private String startTime;

    @ApiModelProperty("结束时间")
    private String endTime;

    @ApiModelProperty("回收趟次")
    private String collectNumber;
}
