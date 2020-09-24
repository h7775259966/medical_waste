package com.common.Response.hospital.hospital;

import com.common.Response.ResponseResult;
import com.common.Response.ResultCode;
import com.module.entity.hospital.hospital.Hospital;
import lombok.Data;

/**
 * Created by mrt on 2018/3/31.
 * 将医院相关数据封装在这里，然后返回给前端
 */
@Data
public class HospitalResult extends ResponseResult {
    Hospital hospital;
    public HospitalResult(ResultCode resultCode, Hospital hospital) {
        super(resultCode);
        this.hospital = hospital;
    }
}
