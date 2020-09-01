package com.module.controller.warnLeakage;

import com.common.Response.QueryResponseResult;
import com.common.Response.ResponseResult;
import com.module.entity.warnLeakage.WarnLeakage;
import com.module.request.warnLeakage.WarnLeakageRequest;
import com.module.response.warnLeakage.WarnLeakageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * Created by Zhouxin on 2020/8/24;
 */
@Api(value="warnLeakage接口",description = "泄漏预警")
public interface WarnLeakageControllerApi {

    @ApiOperation("分页查询泄漏预警列表")
    @ApiImplicitParams({
            //required=true是否必填，paramType="path"是http请求路径，dataType="int"数据类型
            @ApiImplicitParam(name="page",value = "页 码",required=true,paramType="path",dataType="int"),
            @ApiImplicitParam(name="size",value = "每页记录 数",required=true,paramType="path",dataType="int") })
    public QueryResponseResult findList(int page, int size, WarnLeakageRequest warnLeakageRequest) ;

    @ApiOperation("添加泄漏预警")
    public WarnLeakageResult add(WarnLeakage warnLeakage);

    @ApiOperation("通过id查询泄漏预警")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value = "泄漏预警id",required=true,paramType="path",dataType="String") })
    public WarnLeakageResult findById(String id);

    @ApiOperation("通过id修改泄漏预警")
    public WarnLeakageResult edit(String id, WarnLeakage warnLeakage);

    @ApiOperation("通过id删除泄漏预警")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value = "泄漏预警id",required=true,paramType="path",dataType="String") })
    public ResponseResult delete(String id);
}
