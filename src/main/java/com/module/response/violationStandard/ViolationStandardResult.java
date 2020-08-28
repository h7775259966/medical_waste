package com.module.response.violationStandard;

import com.common.Response.ResponseResult;
import com.common.Response.ResultCode;
import com.module.entity.violationStandard.ViolationStandard;

/**
 * Created by huangbotao on 2020/8/27;
 */
public class ViolationStandardResult extends ResponseResult {
    ViolationStandard plan;
    public ViolationStandardResult(ResultCode resultCode, ViolationStandard plan) {
        super(resultCode);
        this.plan = plan;
    }
}
