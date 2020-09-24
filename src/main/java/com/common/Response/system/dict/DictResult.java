package com.common.Response.system.dict;

import com.common.Response.ResponseResult;
import com.common.Response.ResultCode;
import com.module.entity.system.dict.Dict;
import lombok.Data;

/**
 * Created by mrt on 2018/3/31.
 * 将系统字典相关数据封装在这里，然后返回给前端
 */
@Data
public class DictResult extends ResponseResult {
    Dict dict;
    public DictResult(ResultCode resultCode, Dict dict) {
        super(resultCode);
        this.dict = dict;
    }
}
