package com.common.Response.warn.warnDamaged;

import com.common.Response.ResponseResult;
import com.common.Response.ResultCode;
import com.module.entity.warn.WarnDamaged;
import lombok.Data;

/**
 * Created by mrt on 2018/3/31.
 * 将相关数据封装在这里，然后返回给前端
 */
@Data
public class WarnDamagedResult extends ResponseResult {
    WarnDamaged warnDamaged;
    public WarnDamagedResult(ResultCode resultCode, WarnDamaged warnDamaged) {
        super(resultCode);
        this.warnDamaged = warnDamaged;
    }
}
