package com.module.controller.warn;

import com.common.Response.QueryResponseResult;
import com.common.Response.ResponseResult;
import com.module.entity.warn.WarnOutOvertime;
import com.common.Request.warn.WarnOutOvertimeRequest;
import com.common.Response.warn.WarnOutOvertimeResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * Created by Zhouxin on 2020/8/24;
 */
@Api(value="warnOutOvertime接口",description = "出库超时预警")
public interface WarnOutOvertimeControllerApi {

    @ApiOperation("分页查询出库超时预警列表")
    @ApiImplicitParams({
            //required=true是否必填，paramType="path"是http请求路径，dataType="int"数据类型
            @ApiImplicitParam(name="page",value = "页 码",required=true,paramType="path",dataType="int"),
            @ApiImplicitParam(name="size",value = "每页记录 数",required=true,paramType="path",dataType="int") })
    public QueryResponseResult findList(int page, int size, WarnOutOvertimeRequest warnOutOvertimeRequest) ;

    @ApiOperation("添加出库超时预警")
    public WarnOutOvertimeResult add(WarnOutOvertime warnOutOvertime);

    @ApiOperation("通过id查询出库超时预警")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value = "出库超时预警id",required=true,paramType="path",dataType="String") })
    public WarnOutOvertimeResult findById(String id);

    @ApiOperation("通过id修改出库超时预警")
    public WarnOutOvertimeResult edit(String id, WarnOutOvertime warnOutOvertime);

    @ApiOperation("通过id删除出库超时预警")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value = "出库超时预警id",required=true,paramType="path",dataType="String") })
    public ResponseResult delete(String id);
}
