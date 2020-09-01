package com.module.response.warn.warnViolation;

import com.common.Response.ResponseResult;
import com.common.Response.ResultCode;
import com.module.entity.warn.warnViolation.WarnViolation;
import lombok.Data;

/**
 * Created by mrt on 2018/3/31.
 * 将违规预警相关数据封装在这里，然后返回给前端
 */
@Data
public class WarnViolationResult extends ResponseResult {
    WarnViolation warnViolation;
    public WarnViolationResult(ResultCode resultCode, WarnViolation warnViolation) {
        super(resultCode);
        this.warnViolation = warnViolation;
    }
}
