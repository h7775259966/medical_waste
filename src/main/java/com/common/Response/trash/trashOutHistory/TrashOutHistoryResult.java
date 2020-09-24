package com.common.Response.trash.trashOutHistory;

import com.common.Response.ResponseResult;
import com.common.Response.ResultCode;
import com.module.entity.trash.trashOutHistory.TrashOutHistory;
import lombok.Data;

/**
 * Created by huangbotao on 2020/8/31;
 */
@Data
public class TrashOutHistoryResult extends ResponseResult {
    TrashOutHistory OutHistory;
    public TrashOutHistoryResult(ResultCode resultCode, TrashOutHistory OutHistory) {
        super(resultCode);
        this.OutHistory = OutHistory;
    }
}

