package com.common.Response.trash.trashOutMessage;

import com.common.Response.ResponseResult;
import com.common.Response.ResultCode;
import com.module.entity.trash.trashOut.TrashOut;
import com.module.entity.trash.trashOutMessage.TrashOutMessage;
import lombok.Data;


/**
 * Created zx on 2020/10/12;
 */
@Data
public class TrashOutMessageResult extends ResponseResult {
    TrashOutMessage trashOutMessage;
    public TrashOutMessageResult(ResultCode resultCode, TrashOutMessage trashOutMessage) {
        super(resultCode);
        this.trashOutMessage = trashOutMessage;
    }
}

