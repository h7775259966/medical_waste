package com.common.Response.warn;

import com.common.Response.ResponseResult;
import com.common.Response.ResultCode;
import com.module.entity.warn.WarnInOvertime;
import lombok.Data;

/**
 * Created by mrt on 2018/3/31.
 * 将入库超时预警相关数据封装在这里，然后返回给前端
 */
@Data
public class WarnInOvertimeResult extends ResponseResult {
    WarnInOvertime warnInOvertime;
    public WarnInOvertimeResult(ResultCode resultCode, WarnInOvertime warnInOvertime) {
        super(resultCode);
        this.warnInOvertime = warnInOvertime;
    }
}
