package com.module.response.hospital.nurse;

import com.common.Response.ResponseResult;
import com.common.Response.ResultCode;
import com.module.entity.hospital.nurse.Nurse;
import lombok.Data;

/**
 * Created by mrt on 2018/3/31.
 * 将护士相关数据封装在这里，然后返回给前端
 */
@Data
public class NurseResult extends ResponseResult {
    Nurse nurse;
    public NurseResult(ResultCode resultCode, Nurse nurse) {
        super(resultCode);
        this.nurse = nurse;
    }
}
