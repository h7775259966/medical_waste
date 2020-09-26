package com.module.controller.trash.trashPut;

import com.common.Response.QueryResponseResult;
import com.common.Response.ResponseResult;
import com.module.entity.trash.trashPut.TrashPut;
import com.common.Request.trash.trashPut.TrashPutRequest;
import com.common.Response.trash.trashPut.TrashPutResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * Created by huangbotao on 2020/8/31;
 */
@Api(value="trashPut接口",description = "医废入库")
public interface TrashPutControllerApi {

    @ApiOperation("分页查询医废入库列表")
    @ApiImplicitParams({
            //required=true是否必填，paramType="path"是http请求路径，dataType="int"数据类型
            @ApiImplicitParam(name="page",value = "页 码",required=true,paramType="path",dataType="int"),
            @ApiImplicitParam(name="size",value = "每页记录 数",required=true,paramType="path",dataType="int") })
    public QueryResponseResult findListByRequest(int page, int size, TrashPutRequest trashPutRequest) ;

    @ApiOperation("添加医废入库")
    public TrashPutResult add(TrashPut trashPut);

    @ApiOperation("通过id查询医废入库")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value = "医废入库id",required=true,paramType="path",dataType="String") })
    public TrashPutResult findById(String id);


    @ApiOperation("通过id修改医废入库")
    public TrashPutResult edit(String id, TrashPut trashPut);

    @ApiOperation("通过id删除医废入库")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value = "医废入库id",required=true,paramType="path",dataType="String") })
    public ResponseResult delete(String id);
}

