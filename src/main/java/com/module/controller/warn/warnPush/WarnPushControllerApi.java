package com.module.controller.warn.warnPush;

import com.common.Response.QueryResponseResult;
import com.common.Response.ResponseResult;
import com.module.entity.warn.warnPush.WarnPush;
import com.common.Request.warn.warnPush.WarnPushRequest;
import com.common.Response.warn.warnPush.WarnPushResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * Created by Zhouxin on 2020/8/24;
 */
@Api(value="warnPush接口",description = "预警推送")
public interface WarnPushControllerApi {

    @ApiOperation("分页查询预警推送列表")
    @ApiImplicitParams({
            //required=true是否必填，paramType="path"是http请求路径，dataType="int"数据类型
            @ApiImplicitParam(name="page",value = "页 码",required=true,paramType="path",dataType="int"),
            @ApiImplicitParam(name="size",value = "每页记录 数",required=true,paramType="path",dataType="int") })
    public QueryResponseResult findList(int page, int size, WarnPushRequest warnPushRequest) ;

    @ApiOperation("添加预警推送")
    public WarnPushResult add(WarnPush warnPush);

    @ApiOperation("通过id查询预警推送")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value = "预警推送id",required=true,paramType="path",dataType="String") })
    public WarnPushResult findById(String id);

    @ApiOperation("通过id修改预警推送")
    public WarnPushResult edit(String id, WarnPush warnPush);

    @ApiOperation("通过id删除预警推送")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value = "预警推送id",required=true,paramType="path",dataType="String") })
    public ResponseResult delete(String id);
}
