package com.module.request.notice;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class NoticeRequest {

        @ApiModelProperty("公告状态")
        private String status;

        @ApiModelProperty("创建时间")
        private Date createdata;

    }
