package com.module.response.violationExamine;

import com.common.Response.ResponseResult;
import com.common.Response.ResultCode;
import com.module.entity.violationExamine.ViolationExamine;

/**
 * Created by huangbotao on 2020/8/28;
 */
public class ViolationExamineResult extends ResponseResult {

    ViolationExamine violationExamine;
    public ViolationExamineResult(ResultCode resultCode, ViolationExamine violationExamine) {
        super(resultCode);
        this.violationExamine = violationExamine;
    }
}