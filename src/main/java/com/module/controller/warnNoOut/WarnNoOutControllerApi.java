package com.module.controller.warnNoOut;

import com.common.Response.QueryResponseResult;
import com.common.Response.ResponseResult;
import com.module.entity.warnNoOut.WarnNoOut;
import com.module.request.warnNoOut.WarnNoOutRequest;
import com.module.response.warnNoOut.WarnNoOutResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * Created by Zhouxin on 2020/8/24;
 */
@Api(value="warnNoOut接口",description = "未出预警")
public interface WarnNoOutControllerApi {

    @ApiOperation("分页查询未出预警列表")
    @ApiImplicitParams({
            //required=true是否必填，paramType="path"是http请求路径，dataType="int"数据类型
            @ApiImplicitParam(name="page",value = "页 码",required=true,paramType="path",dataType="int"),
            @ApiImplicitParam(name="size",value = "每页记录 数",required=true,paramType="path",dataType="int") })
    public QueryResponseResult findList(int page, int size, WarnNoOutRequest warnNoOutRequest) ;

    @ApiOperation("添加未出预警")
    public WarnNoOutResult add(WarnNoOut warnNoOut);

    @ApiOperation("通过id查询未出预警")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value = "未出预警id",required=true,paramType="path",dataType="String") })
    public WarnNoOutResult findById(String id);

    @ApiOperation("通过id修改未出预警")
    public WarnNoOutResult edit(String id, WarnNoOut warnNoOut);

    @ApiOperation("通过id删除未出预警")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value = "未出预警id",required=true,paramType="path",dataType="String") })
    public ResponseResult delete(String id);
}
