package com.common.Response.warn;

import com.common.Response.ResponseResult;
import com.common.Response.ResultCode;
import com.module.entity.warn.WarnNoOut;
import lombok.Data;

/**
 * Created by mrt on 2018/3/31.
 * 将未出预警相关数据封装在这里，然后返回给前端
 */
@Data
public class WarnNoOutResult extends ResponseResult {
    WarnNoOut warnNoOut;
    public WarnNoOutResult(ResultCode resultCode, WarnNoOut warnNoOut) {
        super(resultCode);
        this.warnNoOut = warnNoOut;
    }
}
