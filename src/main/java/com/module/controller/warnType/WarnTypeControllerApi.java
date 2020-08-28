package com.module.controller.warnType;

import com.common.Response.QueryResponseResult;
import com.common.Response.ResponseResult;
import com.module.entity.warnType.WarnType;
import com.module.request.warnType.WarnTypeRequest;
import com.module.response.warnType.WarnTypeResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * Created by Zhouxin on 2020/8/24;
 */
@Api(value="warnType接口",description = "预警类型")
public interface WarnTypeControllerApi {

    @ApiOperation("分页查询预警类型列表")
    @ApiImplicitParams({
            //required=true是否必填，paramType="path"是http请求路径，dataType="int"数据类型
            @ApiImplicitParam(name="page",value = "页 码",required=true,paramType="path",dataType="int"),
            @ApiImplicitParam(name="size",value = "每页记录 数",required=true,paramType="path",dataType="int") })
    public QueryResponseResult findList(int page, int size, WarnTypeRequest warnTypeRequest) ;

    @ApiOperation("添加预警类型")
    public WarnTypeResult add(WarnType warnType);

    @ApiOperation("通过id查询预警类型")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value = "预警类型id",required=true,paramType="path",dataType="String") })
    public WarnTypeResult findById(String id);

    @ApiOperation("通过id修改预警类型")
    public WarnTypeResult edit(String id, WarnType warnType);

    @ApiOperation("通过id删除预警类型")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value = "预警类型id",required=true,paramType="path",dataType="String") })
    public ResponseResult delete(String id);
}
