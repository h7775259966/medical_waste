package com.module.controller.trash.trashCollect;

import com.common.Response.QueryResponseResult;
import com.common.Response.ResponseResult;
import com.module.entity.trash.trashCollect.TrashCollect;
import com.common.Request.trash.trashCollect.TrashCollectRequest;
import com.common.Response.trash.trashCollect.TrashCollectResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * Created huangbotao on 2020/8/31;
 */
@Api(value="trashCollect接口",description = "医废收集")
public interface TrashCollectControllerApi {

    @ApiOperation("分页查询医废收集列表")
    @ApiImplicitParams({
            //required=true是否必填，paramType="path"是http请求路径，dataType="int"数据类型
            @ApiImplicitParam(name="page",value = "页 码",required=true,paramType="path",dataType="int"),
            @ApiImplicitParam(name="size",value = "每页记录 数",required=true,paramType="path",dataType="int") })
    public QueryResponseResult findList(int page, int size, TrashCollectRequest trashCollectRequest) ;

    @ApiOperation("添加医废收集")
    public TrashCollectResult add(TrashCollect trashCollect);

    @ApiOperation("通过id查询医废收集")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value = "医废收集id",required=true,paramType="path",dataType="String") })
    public TrashCollectResult findById(String id);


    @ApiOperation("通过id修改医废收集")
    public TrashCollectResult edit(String id, TrashCollect trashCollect);

    @ApiOperation("通过id删除医废收集")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value = "医废收集id",required=true,paramType="path",dataType="String") })
    public ResponseResult delete(String id);
}
