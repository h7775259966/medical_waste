package com.module.controller.office;

import com.common.Response.QueryResponseResult;
import com.common.Response.ResponseResult;
import com.module.entity.office.Office;
import com.module.request.office.OfficeRequest;
import com.module.response.office.OfficeResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * Created by Zhouxin on 2020/8/26;
 */
@Api(value="office接口",description = "科室")
public interface OfficeControllerApi {

    @ApiOperation("分页查询科室列表")
    @ApiImplicitParams({
            //required=true是否必填，paramType="path"是http请求路径，dataType="int"数据类型
            @ApiImplicitParam(name="page",value = "页 码",required=true,paramType="path",dataType="int"),
            @ApiImplicitParam(name="size",value = "每页记录 数",required=true,paramType="path",dataType="int") })
    public QueryResponseResult findList(int page, int size, OfficeRequest officeRequest) ;

    @ApiOperation("查询所有科室")
    public QueryResponseResult all();

    @ApiOperation("添加科室")
    public OfficeResult add(Office office);

    @ApiOperation("通过id查询科室")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value = "科室id",required=true,paramType="path",dataType="String") })
    public OfficeResult findById(String id);

    @ApiOperation("通过id修改科室")
    public OfficeResult edit(String id, Office office);

    @ApiOperation("通过id删除科室")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value = "科室id",required=true,paramType="path",dataType="String") })
    public ResponseResult delete(String id);
}
