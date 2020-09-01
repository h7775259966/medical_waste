package com.module.request.trashOut;

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
public class TrashOutRequest {

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

    @ApiModelProperty("出库状态")
    private String status;
}
