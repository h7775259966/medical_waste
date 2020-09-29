package com.common.Response.warn;

import com.common.Response.ResponseResult;
import com.common.Response.ResultCode;
import com.module.entity.warn.WarnLose;
import lombok.Data;

/**
 * Created by mrt on 2018/3/31.
 * 将遗失预警相关数据封装在这里，然后返回给前端
 */
@Data
public class WarnLoseResult extends ResponseResult {
    WarnLose warnLose;
    public WarnLoseResult(ResultCode resultCode, WarnLose warnLose) {
        super(resultCode);
        this.warnLose = warnLose;
    }
}
