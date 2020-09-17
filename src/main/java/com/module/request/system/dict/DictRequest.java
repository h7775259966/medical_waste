package com.module.request.system.dict;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by Zhouxin on 2020/8/24;
 * 将接口接收到的请求数据封装在这里
 */
@Data
public class DictRequest {

    @ApiModelProperty("字典api")
    private String dictApi;

}