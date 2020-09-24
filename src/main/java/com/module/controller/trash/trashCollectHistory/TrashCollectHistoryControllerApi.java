package com.module.controller.trash.trashCollectHistory;

import com.common.Response.QueryResponseResult;
import com.common.Request.trash.trashCollectHistory.TrashCollectHistoryRequest;
import com.common.Request.trash.trashPut.TrashPutRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 收集历史
 * Created by huangbotao on 2020/9/22;
 */

@Api(value="trashCollectHistory接口",description = "收集历史")
public interface TrashCollectHistoryControllerApi {


    @ApiOperation("分页查询医废入库列表")
    @ApiImplicitParams({
            //required=true是否必填，paramType="path"是http请求路径，dataType="int"数据类型
            @ApiImplicitParam(name="page",value = "页 码",required=true,paramType="path",dataType="int"),
            @ApiImplicitParam(name="size",value = "每页记录 数",required=true,paramType="path",dataType="int") })
    public QueryResponseResult findHistory(int page, int size, TrashCollectHistoryRequest trashCollectHistoryRequest) ;

}
