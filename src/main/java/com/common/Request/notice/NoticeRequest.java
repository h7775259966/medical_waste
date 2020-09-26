package com.common.Request.notice;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@ToString
public class NoticeRequest {

        @ApiModelProperty("公告状态")
        private String status;

        @ApiModelProperty("开始时间")
        private String startTime;

        @ApiModelProperty("结束时间")
        private String endTime;

}
