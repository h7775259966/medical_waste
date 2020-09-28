package com.common.Request.custom;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by huangbotao on 2020/9/21;
 */

@Data
public class CustomRequest {


    @ApiModelProperty("查询开始时间")
    private String startTime;

    @ApiModelProperty("查询结束时间")
    private String endTime;

    @ApiModelProperty("医废类型")
    private String trashType;

    @ApiModelProperty("部门")
    private String departmentId;

    @ApiModelProperty("科室")
    private String officeId;

    @ApiModelProperty("医院名称")
    private String hospitalId;

    @ApiModelProperty("区名称")
    private String zoneId;

    @ApiModelProperty("城市名称")
    private String cityId;

    @ApiModelProperty("省名称")
    private String provinceId;

    @ApiModelProperty("医院体制")
    private String regime;

    @ApiModelProperty("机构等级")
    private String grade;

    @ApiModelProperty("处置方式")
    private String processingMode;



}
