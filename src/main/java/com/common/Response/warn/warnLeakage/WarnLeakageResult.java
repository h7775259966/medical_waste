package com.common.Response.warn.warnLeakage;

import com.common.Response.ResponseResult;
import com.common.Response.ResultCode;
import com.module.entity.warn.WarnLeakage;
import lombok.Data;

/**
 * Created by mrt on 2018/3/31.
 * 将泄漏预警相关数据封装在这里，然后返回给前端
 */
@Data
public class WarnLeakageResult extends ResponseResult {
    WarnLeakage warnLeakage;
    public WarnLeakageResult(ResultCode resultCode, WarnLeakage warnLeakage) {
        super(resultCode);
        this.warnLeakage = warnLeakage;
    }
}
