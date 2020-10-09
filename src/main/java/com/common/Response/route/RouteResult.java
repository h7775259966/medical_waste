package com.common.Response.route;

import com.common.Response.ResponseResult;
import com.common.Response.ResultCode;
import com.module.entity.route.Route;
import lombok.Data;

/**
 * Created by huangbotao on 2020/9/30;
 */
@Data
public class RouteResult extends ResponseResult {
    Route route;
    public RouteResult(ResultCode resultCode, Route route) {
        super(resultCode);
        this.route = route;
    }
}
