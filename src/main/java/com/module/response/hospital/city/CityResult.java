package com.module.response.hospital.city;

import com.common.Response.ResponseResult;
import com.common.Response.ResultCode;
import com.module.entity.hospital.city.City;
import lombok.Data;

/**
 * Created by mrt on 2018/3/31.
 * 将市级单位相关数据封装在这里，然后返回给前端
 */
@Data
public class CityResult extends ResponseResult {
    City city;
    public CityResult(ResultCode resultCode, City city) {
        super(resultCode);
        this.city = city;
    }
}
