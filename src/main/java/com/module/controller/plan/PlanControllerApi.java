package com.module.controller.plan;

import com.common.Response.QueryResponseResult;
import com.common.Response.ResponseResult;
import com.module.entity.plan.Plan;
import com.module.request.plan.PlanRequest;
import com.module.response.plan.PlanResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * Created by huangbotao on 2020/8/27;
 */
@Api(value="plan接口",description = "计划")
public interface PlanControllerApi {

    @ApiOperation("分页查询计划列表")
    @ApiImplicitParams({
            //required=true是否必填，paramType="path"是http请求路径，dataType="int"数据类型
            @ApiImplicitParam(name="page",value = "页 码",required=true,paramType="path",dataType="int"),
            @ApiImplicitParam(name="size",value = "每页记录 数",required=true,paramType="path",dataType="int") })
    public QueryResponseResult findList(int page, int size, PlanRequest planRequest) ;

    @ApiOperation("添加计划")
    public PlanResult add(Plan plan);

    @ApiOperation("通过id查询计划")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value = "计划id",required=true,paramType="path",dataType="String") })
    public PlanResult findById(String id);

    @ApiOperation("通过id修改计划")
    public PlanResult edit(String id, Plan plan);

    @ApiOperation("通过id删除计划")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value = "计划id",required=true,paramType="path",dataType="String") })
    public ResponseResult delete(String id);
}

