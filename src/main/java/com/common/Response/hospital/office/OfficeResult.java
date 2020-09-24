package com.common.Response.hospital.office;

import com.common.Response.ResponseResult;
import com.common.Response.ResultCode;
import com.module.entity.hospital.office.Office;
import lombok.Data;

/**
 * Created by mrt on 2018/3/31.
 * 将科室相关数据封装在这里，然后返回给前端
 */
@Data
public class OfficeResult extends ResponseResult {
    Office office;
    public OfficeResult(ResultCode resultCode, Office office) {
        super(resultCode);
        this.office = office;
    }
}
