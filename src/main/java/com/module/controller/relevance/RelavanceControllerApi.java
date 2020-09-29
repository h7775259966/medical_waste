package com.module.controller.relevance;

import com.common.Request.plan.PlanRequest;
import com.common.Request.relavance.RelavanceRequest;
import com.common.Response.QueryResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * Created by huangbotao on 2020/9/28;
 */

@Api(value="Relavance接口",description = "医废分级统计")
public interface RelavanceControllerApi {


    @ApiOperation("医废分级统计")
    @ApiImplicitParams({
            //required=true是否必填，paramType="path"是http请求路径，dataType="int"数据类型
            @ApiImplicitParam(name="page",value = "页 码",required=true,paramType="path",dataType="int"),
            @ApiImplicitParam(name="size",value = "每页记录 数",required=true,paramType="path",dataType="int") })
    public QueryResponseResult findRelavance(int page, int size, RelavanceRequest relavanceRequest);

    @ApiOperation("医废分级统计医院医废重量")
    @ApiImplicitParams({
            //required=true是否必填，paramType="path"是http请求路径，dataType="int"数据类型
            @ApiImplicitParam(name="page",value = "页 码",required=true,paramType="path",dataType="int"),
            @ApiImplicitParam(name="size",value = "每页记录 数",required=true,paramType="path",dataType="int") })
    public QueryResponseResult findSum(int page, int size, RelavanceRequest relavanceRequest);

    @ApiOperation("医废分级统计医院医废包数")
    @ApiImplicitParams({
            //required=true是否必填，paramType="path"是http请求路径，dataType="int"数据类型
            @ApiImplicitParam(name="page",value = "页 码",required=true,paramType="path",dataType="int"),
            @ApiImplicitParam(name="size",value = "每页记录 数",required=true,paramType="path",dataType="int") })
    public QueryResponseResult findSumPackets(int page, int size, RelavanceRequest relavanceRequest);
}
