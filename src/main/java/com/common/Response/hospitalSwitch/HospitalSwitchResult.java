package com.common.Response.hospitalSwitch;

import com.common.Response.ResponseResult;
import com.common.Response.ResultCode;
import com.module.entity.hospitalSwitch.HospitalSwitch;
import lombok.Data;

/**
 * Created by mrt on 2018/3/31.
 * 将医院相关数据封装在这里，然后返回给前端
 */
@Data
public class HospitalSwitchResult extends ResponseResult {
    HospitalSwitch hospitalSwitch;
    public HospitalSwitchResult(ResultCode resultCode, HospitalSwitch hospitalSwitch) {
        super(resultCode);
        this.hospitalSwitch = hospitalSwitch;
    }
}
