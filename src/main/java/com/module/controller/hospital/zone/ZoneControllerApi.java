package com.module.controller.hospital.zone;

import com.common.Response.QueryResponseResult;
import com.common.Response.ResponseResult;
import com.module.entity.hospital.zone.Zone;
import com.common.Request.hospital.zone.ZoneRequest;
import com.common.Response.hospital.zone.ZoneResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * Created by Zhouxin on 2020/8/24;
 */
@Api(value="zone接口",description = "区县级单位")
public interface ZoneControllerApi {

    @ApiOperation("分页查询区县级单位列表")
    @ApiImplicitParams({
            //required=true是否必填，paramType="path"是http请求路径，dataType="int"数据类型
            @ApiImplicitParam(name="page",value = "页 码",required=true,paramType="path",dataType="int"),
            @ApiImplicitParam(name="size",value = "每页记录 数",required=true,paramType="path",dataType="int") })
    public QueryResponseResult findList(int page, int size, ZoneRequest zoneRequest) ;

    @ApiOperation("查询所有区县级单位")
    public QueryResponseResult all();

    @ApiOperation("添加区县级单位")
    public ZoneResult add(Zone zone);

    @ApiOperation("通过id查询区县级单位")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value = "区县级单位id",required=true,paramType="path",dataType="String") })
    public ZoneResult findById(String id);

    @ApiOperation("通过id修改区县级单位")
    public ZoneResult edit(String id, Zone zone);

    @ApiOperation("通过id删除区县级单位")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value = "区县级单位id",required=true,paramType="path",dataType="String") })
    public ResponseResult delete(String id);

    @ApiOperation("通过市级id查询所属区县级")
    @ApiImplicitParams({@ApiImplicitParam(name="CityId",value = "市级id",required=true,paramType="path",dataType="String") })
    public QueryResponseResult findByCityId(String CityId);
}
