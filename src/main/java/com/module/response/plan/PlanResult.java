package com.module.response.plan;

import com.common.Response.ResponseResult;
import com.common.Response.ResultCode;
import com.module.entity.plan.Plan;

/**
 * Created by huangbotao on 2020/8/27;
 */
public class PlanResult extends ResponseResult {
    Plan plan;
    public PlanResult(ResultCode resultCode, Plan plan) {
        super(resultCode);
        this.plan = plan;
    }
}