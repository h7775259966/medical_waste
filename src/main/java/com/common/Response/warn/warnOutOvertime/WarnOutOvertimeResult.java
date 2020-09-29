package com.common.Response.warn.warnOutOvertime;

import com.common.Response.ResponseResult;
import com.common.Response.ResultCode;
import com.module.entity.warn.WarnOutOvertime;
import lombok.Data;

/**
 * Created by mrt on 2018/3/31.
 * 将出库超时预警相关数据封装在这里，然后返回给前端
 */
@Data
public class WarnOutOvertimeResult extends ResponseResult {
    WarnOutOvertime warnOutOvertime;
    public WarnOutOvertimeResult(ResultCode resultCode, WarnOutOvertime warnOutOvertime) {
        super(resultCode);
        this.warnOutOvertime = warnOutOvertime;
    }
}
