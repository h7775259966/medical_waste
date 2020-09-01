package com.module.controller.warnDispose;

import com.common.Response.QueryResponseResult;
import com.common.Response.ResponseResult;
import com.module.entity.warnDispose.WarnDispose;
import com.module.request.warnDispose.WarnDisposeRequest;
import com.module.response.warnDispose.WarnDisposeResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * Created by Zhouxin on 2020/8/24;
 */
@Api(value="warnDispose接口",description = "预警处理")
public interface WarnDisposeControllerApi {

    @ApiOperation("分页查询预警处理列表")
    @ApiImplicitParams({
            //required=true是否必填，paramType="path"是http请求路径，dataType="int"数据类型
            @ApiImplicitParam(name="page",value = "页 码",required=true,paramType="path",dataType="int"),
            @ApiImplicitParam(name="size",value = "每页记录 数",required=true,paramType="path",dataType="int") })
    public QueryResponseResult findList(int page, int size, WarnDisposeRequest warnDisposeRequest) ;

    @ApiOperation("添加预警处理")
    public WarnDisposeResult add(WarnDispose warnDispose);

    @ApiOperation("通过id查询预警处理")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value = "预警处理id",required=true,paramType="path",dataType="String") })
    public WarnDisposeResult findById(String id);

    @ApiOperation("通过id修改预警处理")
    public WarnDisposeResult edit(String id, WarnDispose warnDispose);

    @ApiOperation("通过id删除预警处理")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value = "预警处理id",required=true,paramType="path",dataType="String") })
    public ResponseResult delete(String id);
}
