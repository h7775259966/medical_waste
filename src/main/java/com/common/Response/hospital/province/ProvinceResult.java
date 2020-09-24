package com.common.Response.hospital.province;

import com.common.Response.ResponseResult;
import com.common.Response.ResultCode;
import com.module.entity.hospital.province.Province;
import lombok.Data;

/**
 * Created by mrt on 2018/3/31.
 * 将省级单位相关数据封装在这里，然后返回给前端
 */
@Data
public class ProvinceResult extends ResponseResult {
    Province province;
    public ProvinceResult(ResultCode resultCode, Province province) {
        super(resultCode);
        this.province = province;
    }
}
