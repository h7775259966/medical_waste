package com.common.Response.warn;

import com.common.Response.ResponseResult;
import com.common.Response.ResultCode;
import com.module.entity.warn.WarnOutWeight;
import lombok.Data;

/**
 * Created by mrt on 2018/3/31.
 * 将出库重量预警相关数据封装在这里，然后返回给前端
 */
@Data
public class WarnOutWeightResult extends ResponseResult {
    WarnOutWeight warnOutWeight;
    public WarnOutWeightResult(ResultCode resultCode, WarnOutWeight warnOutWeight) {
        super(resultCode);
        this.warnOutWeight = warnOutWeight;
    }
}
