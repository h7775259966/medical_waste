package com.module.controller.route;

import com.common.Request.route.RouteAndOfficeRequest;
import com.common.Response.MapResult;
import com.common.Response.QueryResponseResult;
import com.common.Response.ResponseResult;
import com.common.Response.route.RouteResult;
import com.module.entity.route.Route;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * Created by hbt on 2020/9/30;
 */
@Api(value="route接口",description = "线路")
public interface RouteControllerApi {

    @ApiOperation("分页查询线路列表")
    @ApiImplicitParams({
            //required=true是否必填，paramType="path"是http请求路径，dataType="int"数据类型
            @ApiImplicitParam(name="page",value = "页 码",required=true,paramType="path",dataType="int"),
            @ApiImplicitParam(name="size",value = "每页记录 数",required=true,paramType="path",dataType="int") })
    public QueryResponseResult findList(int page, int size) ;

    @ApiOperation("查询所有线路")
    public QueryResponseResult all();

    @ApiOperation("添加线路")
    public RouteResult add(Route route);

    @ApiOperation("通过id查询线路")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value = "线路id",required=true,paramType="path",dataType="String") })
    public MapResult findById(String id);

    @ApiOperation("通过id修改线路")
    public RouteResult edit(String id, Route route);

    @ApiOperation("通过id删除线路")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value = "线路id",required=true,paramType="path",dataType="String") })
    public ResponseResult delete(String id);


    @ApiOperation("给线路分配科室")
    public ResponseResult assignPrem(RouteAndOfficeRequest routeAndOfficeRequest);

}
