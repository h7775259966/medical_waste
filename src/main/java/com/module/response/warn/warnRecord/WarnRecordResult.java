package com.module.response.warn.warnRecord;

import com.common.Response.ResponseResult;
import com.common.Response.ResultCode;
import com.module.entity.warn.warnRecord.WarnRecord;
import lombok.Data;

/**
 * Created by mrt on 2018/3/31.
 * 将相关数据封装在这里，然后返回给前端
 */
@Data
public class WarnRecordResult extends ResponseResult {
    WarnRecord warnRecord;
    public WarnRecordResult(ResultCode resultCode, WarnRecord warnRecord) {
        super(resultCode);
        this.warnRecord = warnRecord;
    }
}
