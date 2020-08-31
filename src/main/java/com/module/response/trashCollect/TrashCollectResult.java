package com.module.response.trashCollect;

import com.common.Response.ResponseResult;
import com.common.Response.ResultCode;
import com.module.entity.trashCollect.TrashCollect;
import lombok.Data;

/**
 * Created by huangbotao on 2020/8/31;
 */
@Data
public class TrashCollectResult extends ResponseResult {
    TrashCollect trashCollect;
    public TrashCollectResult(ResultCode resultCode, TrashCollect trashCollect) {
        super(resultCode);
        this.trashCollect = trashCollect;
    }
}

