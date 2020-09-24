package com.common.Response.violation.violationStandard;

import com.common.Response.ResponseResult;
import com.common.Response.ResultCode;
import com.module.entity.violation.violationStandard.ViolationStandard;
import lombok.Data;

/**
 * Created by huangbotao on 2020/8/27;
 */
@Data
public class ViolationStandardResult extends ResponseResult {
    ViolationStandard plan;
    public ViolationStandardResult(ResultCode resultCode, ViolationStandard plan) {
        super(resultCode);
        this.plan = plan;
    }
}
