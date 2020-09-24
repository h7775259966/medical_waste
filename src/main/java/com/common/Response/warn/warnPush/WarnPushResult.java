package com.common.Response.warn.warnPush;

import com.common.Response.ResponseResult;
import com.common.Response.ResultCode;
import com.module.entity.warn.warnPush.WarnPush;
import lombok.Data;

/**
 * Created by mrt on 2018/3/31.
 * 将预警推送相关数据封装在这里，然后返回给前端
 */
@Data
public class WarnPushResult extends ResponseResult {
    WarnPush warnPush;
    public WarnPushResult(ResultCode resultCode, WarnPush warnPush) {
        super(resultCode);
        this.warnPush = warnPush;
    }
}
