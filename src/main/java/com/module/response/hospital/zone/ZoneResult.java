package com.module.response.hospital.zone;

import com.common.Response.ResponseResult;
import com.common.Response.ResultCode;
import com.module.entity.hospital.zone.Zone;
import lombok.Data;

/**
 * Created by mrt on 2018/3/31.
 * 将区县级单位相关数据封装在这里，然后返回给前端
 */
@Data
public class ZoneResult extends ResponseResult {
    Zone zone;
    public ZoneResult(ResultCode resultCode, Zone zone) {
        super(resultCode);
        this.zone = zone;
    }
}
