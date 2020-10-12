package com.module.controller.trash.trashOutMessage;

import com.common.Request.trash.trashOutMessage.TrashOutMessageRequest;
import com.common.Response.QueryResponseResult;
import com.common.Response.ResponseResult;
import com.common.Response.trash.trashOutMessage.TrashOutMessageResult;
import com.module.entity.trash.trashOutMessage.TrashOutMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * Created zx on 2020/10/12;
 */
@Api(value="trashOutMessage接口",description = "出库转运信息")
public interface TrashOutMessageControllerApi {

    @ApiOperation("分页查询出库转运信息列表")
    @ApiImplicitParams({
            //required=true是否必填，paramType="path"是http请求路径，dataType="int"数据类型
            @ApiImplicitParam(name="page",value = "页 码",required=true,paramType="path",dataType="int"),
            @ApiImplicitParam(name="size",value = "每页记录 数",required=true,paramType="path",dataType="int") })
    public QueryResponseResult findList(int page, int size, TrashOutMessageRequest trashOutMessageRequest) ;

    @ApiOperation("添加出库转运信息")
    public TrashOutMessageResult add(TrashOutMessage trashOutMessage);

    @ApiOperation("通过id查询出库转运信息")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value = "出库转运信息id",required=true,paramType="path",dataType="String") })
    public TrashOutMessageResult findById(String id);

    @ApiOperation("通过id修改出库转运信息")
    public TrashOutMessageResult edit(String id, TrashOutMessage trashOutMessage);

    @ApiOperation("通过id删除出库转运信息")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value = "出库转运信息id",required=true,paramType="path",dataType="String") })
    public ResponseResult delete(String id);
}
