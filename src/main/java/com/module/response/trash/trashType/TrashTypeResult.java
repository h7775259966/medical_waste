package com.module.response.trash.trashType;

import com.common.Response.ResponseResult;
import com.common.Response.ResultCode;
import com.module.entity.trash.trashType.TrashType;
import lombok.Data;

/**
 * Created by mrt on 2018/3/31.
 * 将科室相关数据封装在这里，然后返回给前端
 */
@Data
public class TrashTypeResult extends ResponseResult {
    TrashType trashType;
    public TrashTypeResult(ResultCode resultCode, TrashType trashType) {
        super(resultCode);
        this.trashType = trashType;
    }
}
