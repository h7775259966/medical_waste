package com.module.controller.warn.warnOpinion;

import com.common.Request.warn.warnOpinion.WarnOpinionRequest;
import com.common.Response.QueryResponseResult;
import com.common.Response.ResponseResult;
import com.common.Response.warn.warnOpinion.WarnOpinionResult;
import com.module.entity.warn.warnOpinion.WarnOpinion;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * Created by Zhouxin on 2020/8/24;
 */
@Api(value="warnOpinion接口",description = "预警意见")
public interface WarnOpinionControllerApi {

    @ApiOperation("分页查询预警意见列表")
    @ApiImplicitParams({
            //required=true是否必填，paramType="path"是http请求路径，dataType="int"数据类型
            @ApiImplicitParam(name="page",value = "页 码",required=true,paramType="path",dataType="int"),
            @ApiImplicitParam(name="size",value = "每页记录 数",required=true,paramType="path",dataType="int") })
    public QueryResponseResult findList(int page, int size, WarnOpinionRequest warnOpinionRequest) ;

    @ApiOperation("添加预警意见")
    public WarnOpinionResult add(WarnOpinion warnOpinion);

    @ApiOperation("通过id查询预警意见")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value = "预警意见id",required=true,paramType="path",dataType="String") })
    public WarnOpinionResult findById(String id);

    @ApiOperation("通过id修改预警意见")
    public WarnOpinionResult edit(String id, WarnOpinion warnOpinion);

    @ApiOperation("通过id删除预警意见")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value = "预警意见id",required=true,paramType="path",dataType="String") })
    public ResponseResult delete(String id);
}
