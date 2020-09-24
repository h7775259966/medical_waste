package com.common.Response.violation.violationExamine;

import com.common.Response.ResponseResult;
import com.common.Response.ResultCode;
import com.module.entity.violation.violationExamine.ViolationExamine;
import lombok.Data;

/**
 * Created by huangbotao on 2020/8/28;
 */
@Data
public class ViolationExamineResult extends ResponseResult {

    ViolationExamine violationExamine;
    public ViolationExamineResult(ResultCode resultCode, ViolationExamine violationExamine) {
        super(resultCode);
        this.violationExamine = violationExamine;
    }
}
