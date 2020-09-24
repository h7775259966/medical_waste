package com.module.controller.hospital.city;

import com.common.Response.QueryResponseResult;
import com.common.Response.ResponseResult;
import com.module.entity.hospital.city.City;
import com.common.Request.hospital.city.CityRequest;
import com.common.Response.hospital.city.CityResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * Created by Zhouxin on 2020/8/24;
 */
@Api(value="city接口",description = "市级单位")
public interface CityControllerApi {

    @ApiOperation("分页查询市级单位列表")
    @ApiImplicitParams({
            //required=true是否必填，paramType="path"是http请求路径，dataType="int"数据类型
            @ApiImplicitParam(name="page",value = "页 码",required=true,paramType="path",dataType="int"),
            @ApiImplicitParam(name="size",value = "每页记录 数",required=true,paramType="path",dataType="int") })
    public QueryResponseResult findList(int page, int size, CityRequest cityRequest) ;

    @ApiOperation("查询所有市级单位")
    public QueryResponseResult all();

    @ApiOperation("添加市级单位")
    public CityResult add(City city);

    @ApiOperation("通过id查询市级单位")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value = "市级单位id",required=true,paramType="path",dataType="String") })
    public CityResult findById(String id);

    @ApiOperation("通过id修改市级单位")
    public CityResult edit(String id, City city);

    @ApiOperation("通过id删除市级单位")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value = "市级单位id",required=true,paramType="path",dataType="String") })
    public ResponseResult delete(String id);

}
