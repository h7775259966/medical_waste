package com.module.request.trash.trashPut;

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
public class TrashPutRequest {



    @ApiModelProperty("部门")
    private String department;

    @ApiModelProperty("科室")
    private String office;

    @ApiModelProperty("废物类型")
    private String trash;

    @ApiModelProperty("条形编码")
    private String code;

    @ApiModelProperty("开始时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd") //入参
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd") //出参
    //   @DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    private Date startTime;

    @ApiModelProperty("结束时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd") //入参
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd") //出参
    //   @DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    private Date endTime;

}
