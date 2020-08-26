package com.module.controller.collect;

import com.common.Response.QueryResponseResult;
import com.common.Response.ResponseResult;
import com.module.entity.collect.Collect;
import com.module.request.collect.CollectRequest;
import com.module.response.collect.CollectResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * Created by Zhouxin on 2020/8/24;
 */
@Api(value="collect接口",description = "提供收集人的增、删、改、查")
public interface CollectControllerApi {

    @ApiOperation("分页查询收集人列表")
    @ApiImplicitParams({
            //required=true是否必填，paramType="path"是http请求路径，dataType="int"数据类型
            @ApiImplicitParam(name="page",value = "页 码",required=true,paramType="path",dataType="int"),
            @ApiImplicitParam(name="size",value = "每页记录 数",required=true,paramType="path",dataType="int") })
    public QueryResponseResult findList(int page, int size, CollectRequest collectRequest) ;

    @ApiOperation("添加收集人")
    public CollectResult add(Collect collect);

    @ApiOperation("通过id查询收集人")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value = "收集人id",required=true,paramType="path",dataType="String") })
    public CollectResult findById(String id);

    @ApiOperation("通过id修改收集人")
    public CollectResult edit(String id, Collect collect);

    @ApiOperation("通过id删除收集人")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value = "收集人id",required=true,paramType="path",dataType="String") })
    public ResponseResult delete(String id);
}
