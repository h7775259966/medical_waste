package com.common.Response.warn;

import com.common.Response.ResponseResult;
import com.common.Response.ResultCode;
import com.module.entity.warn.WarnInWeight;
import lombok.Data;

/**
 * Created by mrt on 2018/3/31.
 * 将入库重量预警相关数据封装在这里，然后返回给前端
 */
@Data
public class WarnInWeightResult extends ResponseResult {
    WarnInWeight warnInWeight;
    public WarnInWeightResult(ResultCode resultCode, WarnInWeight warnInWeight) {
        super(resultCode);
        this.warnInWeight = warnInWeight;
    }
}
