package com.module.controller.warn.warnOutWeight;

import com.common.Response.QueryResponseResult;
import com.common.Response.ResponseResult;
import com.module.entity.warn.warnOutWeight.WarnOutWeight;
import com.common.Request.warn.warnOutWeight.WarnOutWeightRequest;
import com.common.Response.warn.warnOutWeight.WarnOutWeightResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * Created by Zhouxin on 2020/8/24;
 */
@Api(value="warnOutWeight接口",description = "出库重量预警")
public interface WarnOutWeightControllerApi {

    @ApiOperation("分页查询出库重量预警列表")
    @ApiImplicitParams({
            //required=true是否必填，paramType="path"是http请求路径，dataType="int"数据类型
            @ApiImplicitParam(name="page",value = "页 码",required=true,paramType="path",dataType="int"),
            @ApiImplicitParam(name="size",value = "每页记录 数",required=true,paramType="path",dataType="int") })
    public QueryResponseResult findList(int page, int size, WarnOutWeightRequest warnOutWeightRequest) ;

    @ApiOperation("添加出库重量预警")
    public WarnOutWeightResult add(WarnOutWeight warnOutWeight);

    @ApiOperation("通过id查询出库重量预警")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value = "出库重量预警id",required=true,paramType="path",dataType="String") })
    public WarnOutWeightResult findById(String id);

    @ApiOperation("通过id修改出库重量预警")
    public WarnOutWeightResult edit(String id, WarnOutWeight warnOutWeight);

    @ApiOperation("通过id删除出库重量预警")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value = "出库重量预警id",required=true,paramType="path",dataType="String") })
    public ResponseResult delete(String id);
}
