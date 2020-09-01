package com.module.response.warn.warnDispose;

import com.common.Response.ResponseResult;
import com.common.Response.ResultCode;
import com.module.entity.warn.warnDispose.WarnDispose;
import lombok.Data;

/**
 * Created by mrt on 2018/3/31.
 * 将相关数据封装在这里，然后返回给前端
 */
@Data
public class WarnDisposeResult extends ResponseResult {
    WarnDispose warnDispose;
    public WarnDisposeResult(ResultCode resultCode, WarnDispose warnDispose) {
        super(resultCode);
        this.warnDispose = warnDispose;
    }
}
