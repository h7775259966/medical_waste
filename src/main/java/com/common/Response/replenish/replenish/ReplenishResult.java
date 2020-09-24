package com.common.Response.replenish.replenish;

import com.common.Response.ResponseResult;
import com.common.Response.ResultCode;
import com.module.entity.replenish.replenish.Replenish;
import lombok.Data;

/**
 * Created by mrt on 2018/3/31.
 * 将部门相关数据封装在这里，然后返回给前端
 */
@Data
public class ReplenishResult extends ResponseResult {
    Replenish replenish;
    public ReplenishResult(ResultCode resultCode, Replenish replenish) {
        super(resultCode);
        this.replenish = replenish;
    }
}
