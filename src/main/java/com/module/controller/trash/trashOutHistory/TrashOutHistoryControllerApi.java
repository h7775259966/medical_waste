package com.module.controller.trash.trashOutHistory;

import com.common.Response.QueryResponseResult;
import com.common.Response.ResponseResult;
import com.module.entity.trash.trashOutHistory.TrashOutHistory;
import com.module.request.trash.trashOutHistory.TrashOutHistoryRequest;
import com.module.response.trash.trashOutHistory.TrashOutHistoryResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 出库记录表
 * Created by huangbotao on 2020/9/21;
 */

@Api(value="trashOutHistory接口",description = "出库记录")
public interface TrashOutHistoryControllerApi {

    @ApiOperation("分页查询计划列表")
    @ApiImplicitParams({
            //required=true是否必填，paramType="path"是http请求路径，dataType="int"数据类型
            @ApiImplicitParam(name="page",value = "页 码",required=true,paramType="path",dataType="int"),
            @ApiImplicitParam(name="size",value = "每页记录 数",required=true,paramType="path",dataType="int") })
    public QueryResponseResult findList(int page, int size, TrashOutHistoryRequest trashOutHistoryRequest) ;

    @ApiOperation("添加计划")
    public TrashOutHistoryResult add(TrashOutHistory trashOutHistory);

    @ApiOperation("通过id查询计划")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value = "计划id",required=true,paramType="path",dataType="String") })
    public TrashOutHistoryResult findById(String id);

    @ApiOperation("通过id修改计划")
    public TrashOutHistoryResult edit(String id, TrashOutHistory trashOutHistory);

    @ApiOperation("通过id删除计划")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value = "计划id",required=true,paramType="path",dataType="String") })
    public ResponseResult delete(String id);
}
