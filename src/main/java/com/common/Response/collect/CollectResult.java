package com.common.Response.collect;

import com.common.Response.ResponseResult;
import com.common.Response.ResultCode;
import com.module.entity.collect.Collect;
import lombok.Data;

/**
 * Created by mrt on 2018/3/31.
 * 将收集人相关数据封装在这里，然后返回给前端
 */
@Data
public class CollectResult extends ResponseResult {
    Collect collect;
    public CollectResult(ResultCode resultCode, Collect collect) {
        super(resultCode);
        this.collect = collect;
    }
}
