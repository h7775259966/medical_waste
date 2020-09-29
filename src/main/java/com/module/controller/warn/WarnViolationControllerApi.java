package com.module.controller.warn;

import com.common.Response.QueryResponseResult;
import com.common.Response.ResponseResult;
import com.module.entity.warn.WarnViolation;
import com.common.Request.warn.WarnViolationRequest;
import com.common.Response.warn.WarnViolationResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * Created by Zhouxin on 2020/8/24;
 */
@Api(value="warnViolation接口",description = "违规预警")
public interface WarnViolationControllerApi {

    @ApiOperation("分页查询违规预警列表")
    @ApiImplicitParams({
            //required=true是否必填，paramType="path"是http请求路径，dataType="int"数据类型
            @ApiImplicitParam(name="page",value = "页 码",required=true,paramType="path",dataType="int"),
            @ApiImplicitParam(name="size",value = "每页记录 数",required=true,paramType="path",dataType="int") })
    public QueryResponseResult findList(int page, int size, WarnViolationRequest warnViolationRequest) ;

    @ApiOperation("添加违规预警")
    public WarnViolationResult add(WarnViolation warnViolation);

    @ApiOperation("通过id查询违规预警")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value = "违规预警id",required=true,paramType="path",dataType="String") })
    public WarnViolationResult findById(String id);

    @ApiOperation("通过id修改违规预警")
    public WarnViolationResult edit(String id, WarnViolation warnViolation);

    @ApiOperation("通过id删除违规预警")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value = "违规预警id",required=true,paramType="path",dataType="String") })
    public ResponseResult delete(String id);
}
