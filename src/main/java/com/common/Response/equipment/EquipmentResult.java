package com.common.Response.equipment;

import com.common.Response.ResponseResult;
import com.common.Response.ResultCode;
import com.module.entity.equipment.Equipment;
import lombok.Data;

/**
 * Created by mrt on 2018/3/31.
 * 将部门相关数据封装在这里，然后返回给前端
 */
@Data
public class EquipmentResult extends ResponseResult {
    Equipment equipment;
    public EquipmentResult(ResultCode resultCode, Equipment equipment) {
        super(resultCode);
        this.equipment = equipment;
    }
}
