package com.module.response.replenish.replenishCheck;

import com.common.Response.ResponseResult;
import com.common.Response.ResultCode;
import com.module.entity.replenish.replenishCheck.ReplenishCheck;
import lombok.Data;

/**
 * Created by mrt on 2018/3/31.
 * 将部门相关数据封装在这里，然后返回给前端
 */
@Data
public class ReplenishCheckResult extends ResponseResult {
    ReplenishCheck replenishCheck;
    public ReplenishCheckResult(ResultCode resultCode, ReplenishCheck replenishCheck) {
        super(resultCode);
        this.replenishCheck = replenishCheck;
    }
}
