package com.module.controller.custom;

import com.common.Response.QueryResponseResult;
import com.module.request.custom.CustomRequest;
import com.module.request.custom.CustomWarnRequest;
import com.module.request.hospital.nurse.NurseRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 *
 * Created by huangbotao on 2020/9/21;
 */

@Api(value="custom接口",description = "自定义查询")
public interface CustomControllerApi {

    @ApiOperation("自定义查询重量")
    @ApiImplicitParams({
            //required=true是否必填，paramType="path"是http请求路径，dataType="int"数据类型
            @ApiImplicitParam(name="page",value = "页 码",required=true,paramType="path",dataType="int"),
            @ApiImplicitParam(name="size",value = "每页记录 数",required=true,paramType="path",dataType="int") })
    public QueryResponseResult customFind(int page, int size, CustomRequest customRequest) ;

    @ApiOperation("自定义查询预警")
    @ApiImplicitParams({
            //required=true是否必填，paramType="path"是http请求路径，dataType="int"数据类型
            @ApiImplicitParam(name="page",value = "页 码",required=true,paramType="path",dataType="int"),
            @ApiImplicitParam(name="size",value = "每页记录 数",required=true,paramType="path",dataType="int") })
    public QueryResponseResult customWarn(int page, int size, CustomWarnRequest customWarnRequest) ;
}

