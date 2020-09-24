package com.module.controller.replenish.replenishCheck;

import com.common.Response.QueryResponseResult;
import com.common.Response.ResponseResult;
import com.module.entity.replenish.replenishCheck.ReplenishCheck;
import com.common.Request.replenish.replenishCheck.ReplenishCheckRequest;
import com.common.Response.replenish.replenishCheck.ReplenishCheckResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * Created by Zhouxin on 2020/8/24;
 */
@Api(value="replenishCheck接口",description = "医废补录审核")
public interface ReplenishCheckControllerApi {

    @ApiOperation("分页查询医废补录审核列表")
    @ApiImplicitParams({
            //required=true是否必填，paramType="path"是http请求路径，dataType="int"数据类型
            @ApiImplicitParam(name="page",value = "页 码",required=true,paramType="path",dataType="int"),
            @ApiImplicitParam(name="size",value = "每页记录 数",required=true,paramType="path",dataType="int") })
    public QueryResponseResult findList(int page, int size, ReplenishCheckRequest replenishCheckRequest) ;

    @ApiOperation("添加医废补录审核")
    public ReplenishCheckResult add(ReplenishCheck replenishCheck);

    @ApiOperation("通过id查询医废补录审核")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value = "医废补录审核id",required=true,paramType="path",dataType="String") })
    public ReplenishCheckResult findById(String id);

    @ApiOperation("通过id修改医废补录审核")
    public ReplenishCheckResult edit(String id, ReplenishCheck replenishCheck);

    @ApiOperation("通过id删除医废补录审核")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value = "医废补录审核id",required=true,paramType="path",dataType="String") })
    public ResponseResult delete(String id);
}
