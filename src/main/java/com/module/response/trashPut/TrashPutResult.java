package com.module.response.trashPut;

import com.common.Response.ResponseResult;
import com.common.Response.ResultCode;
import com.module.entity.trashPut.TrashPut;
import lombok.Data;

/**
 * Created by huangbotao on 2020/8/31;
 */
@Data
public class TrashPutResult extends ResponseResult {
    TrashPut trashPut;
    public TrashPutResult(ResultCode resultCode, TrashPut trashPut) {
        super(resultCode);
        this.trashPut = trashPut;
    }
}

