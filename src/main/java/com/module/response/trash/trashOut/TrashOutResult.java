package com.module.response.trash.trashOut;

import com.common.Response.ResponseResult;
import com.common.Response.ResultCode;
import com.module.entity.trash.trashOut.TrashOut;
import lombok.Data;

/**
 * Created by huangbotao on 2020/8/31;
 */
@Data
public class TrashOutResult extends ResponseResult {
    TrashOut trashOut;
    public TrashOutResult(ResultCode resultCode, TrashOut trashOut) {
        super(resultCode);
        this.trashOut = trashOut;
    }
}

