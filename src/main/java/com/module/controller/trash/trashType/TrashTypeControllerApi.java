package com.module.controller.trash.trashType;

import com.common.Response.ResponseResult;
import com.module.entity.trash.trashType.TrashType;
import com.common.Response.trash.trashType.TrashTypeResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * Created by Zhouxin on 2020/8/26;
 */
@Api(value="trashType接口",description = "医废类型")
public interface TrashTypeControllerApi {

    @ApiOperation("添加医废类型")
    public TrashTypeResult add(TrashType trashType);

    @ApiOperation("通过id查询医废类型")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value = "医废类型id",required=true,paramType="path",dataType="String") })
    public TrashTypeResult findById(String id);

    @ApiOperation("通过id修改医废类型")
    public TrashTypeResult edit(String id, TrashType trashType);

    @ApiOperation("通过id删除医废类型")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value = "医废类型id",required=true,paramType="path",dataType="String") })
    public ResponseResult delete(String id);
}
