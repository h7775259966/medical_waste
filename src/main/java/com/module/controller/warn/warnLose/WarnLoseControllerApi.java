package com.module.controller.warn.warnLose;

import com.common.Response.QueryResponseResult;
import com.common.Response.ResponseResult;
import com.module.entity.warn.warnLose.WarnLose;
import com.module.request.warn.warnLose.WarnLoseRequest;
import com.module.response.warn.warnLose.WarnLoseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * Created by Zhouxin on 2020/8/24;
 */
@Api(value="warnLose接口",description = "遗失预警")
public interface WarnLoseControllerApi {

    @ApiOperation("分页查询遗失预警列表")
    @ApiImplicitParams({
            //required=true是否必填，paramType="path"是http请求路径，dataType="int"数据类型
            @ApiImplicitParam(name="page",value = "页 码",required=true,paramType="path",dataType="int"),
            @ApiImplicitParam(name="size",value = "每页记录 数",required=true,paramType="path",dataType="int") })
    public QueryResponseResult findList(int page, int size, WarnLoseRequest warnLoseRequest) ;

    @ApiOperation("添加遗失预警")
    public WarnLoseResult add(WarnLose warnLose);

    @ApiOperation("通过id查询遗失预警")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value = "遗失预警id",required=true,paramType="path",dataType="String") })
    public WarnLoseResult findById(String id);

    @ApiOperation("通过id修改遗失预警")
    public WarnLoseResult edit(String id, WarnLose warnLose);

    @ApiOperation("通过id删除遗失预警")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value = "遗失预警id",required=true,paramType="path",dataType="String") })
    public ResponseResult delete(String id);
}
