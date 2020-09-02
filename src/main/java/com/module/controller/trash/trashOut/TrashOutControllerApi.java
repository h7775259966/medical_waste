package com.module.controller.trash.trashOut;

import com.common.Response.QueryResponseResult;
import com.common.Response.ResponseResult;
import com.module.entity.trash.trashOut.TrashOut;
import com.module.request.trash.trashOut.TrashOutRequest;
import com.module.response.trash.trashOut.TrashOutResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * Created huangbotao on 2020/8/31;
 */
@Api(value="trashOut接口",description = "出库操作")
public interface TrashOutControllerApi {

    @ApiOperation("分页查询出库操作列表")
    @ApiImplicitParams({
            //required=true是否必填，paramType="path"是http请求路径，dataType="int"数据类型
            @ApiImplicitParam(name="page",value = "页 码",required=true,paramType="path",dataType="int"),
            @ApiImplicitParam(name="size",value = "每页记录 数",required=true,paramType="path",dataType="int") })
    public QueryResponseResult findList(int page, int size, TrashOutRequest trashOutRequest) ;

    @ApiOperation("添加出库操作")
    public TrashOutResult add(TrashOut trashOut);

    @ApiOperation("通过id查询出库操作")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value = "出库操作id",required=true,paramType="path",dataType="String") })
    public TrashOutResult findById(String id);


    @ApiImplicitParams({
            //required=true是否必填，paramType="path"是http请求路径，dataType="int"数据类型
            @ApiImplicitParam(name="page",value = "页 码",required=true,paramType="path",dataType="int"),
            @ApiImplicitParam(name="size",value = "每页记录 数",required=true,paramType="path",dataType="int") })
    public QueryResponseResult search(int page, int size, TrashOutRequest trashOutRequest) ;


    @ApiOperation("通过id修改出库操作")
    public TrashOutResult edit(String id, TrashOut trashOut);

    @ApiOperation("通过id删除出库操作")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value = "出库操作id",required=true,paramType="path",dataType="String") })
    public ResponseResult delete(String id);
}
