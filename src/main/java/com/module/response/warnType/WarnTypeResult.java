package com.module.response.warnType;

import com.common.Response.ResponseResult;
import com.common.Response.ResultCode;
import com.module.entity.warnType.WarnType;
import lombok.Data;

/**
 * Created by mrt on 2018/3/31.
 * 将预警推送相关数据封装在这里，然后返回给前端
 */
@Data
public class WarnTypeResult extends ResponseResult {
    WarnType warnType;
    public WarnTypeResult(ResultCode resultCode, WarnType warnType) {
        super(resultCode);
        this.warnType = warnType;
    }
}
