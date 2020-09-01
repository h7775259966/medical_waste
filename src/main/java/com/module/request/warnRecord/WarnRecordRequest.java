package com.module.request.warnRecord;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by Zhouxin on 2020/8/24;
 * 将接口接收到的请求数据封装在这里
 */
@Data
public class WarnRecordRequest {

    @ApiModelProperty("预警记录id")
    private String warnRecordId;

}