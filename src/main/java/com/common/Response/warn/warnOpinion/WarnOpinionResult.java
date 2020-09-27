package com.common.Response.warn.warnOpinion;

import com.common.Response.ResponseResult;
import com.common.Response.ResultCode;
import com.module.entity.warn.warnOpinion.WarnOpinion;
import com.module.entity.warn.warnPush.WarnPush;
import lombok.Data;

/**
 * Created by mrt on 2018/3/31.
 * 将预警意见相关数据封装在这里，然后返回给前端
 */
@Data
public class WarnOpinionResult extends ResponseResult {
    WarnOpinion warnOpinion;
    public WarnOpinionResult(ResultCode resultCode, WarnOpinion warnOpinion) {
        super(resultCode);
        this.warnOpinion = warnOpinion;
    }
}
