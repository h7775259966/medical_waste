package com.common.Response;

import com.common.Response.ResponseResult;
import com.common.Response.ResultCode;
import com.module.entity.system.user.User;
import lombok.Data;

import java.util.Map;

/**
 * Created by mrt on 2018/3/31.
 * 封装map集合在这里，然后返回给前端
 */
@Data
public class MapResult extends ResponseResult {
    Map<String,Object> map;
    public MapResult(ResultCode resultCode, Map<String,Object> map) {
        super(resultCode);
        this.map = map;
    }
}
