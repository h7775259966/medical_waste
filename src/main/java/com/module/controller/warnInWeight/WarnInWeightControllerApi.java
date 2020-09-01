package com.module.controller.warnInWeight;

import com.common.Response.QueryResponseResult;
import com.common.Response.ResponseResult;
import com.module.entity.warnInWeight.WarnInWeight;
import com.module.request.warnInWeight.WarnInWeightRequest;
import com.module.response.warnInWeight.WarnInWeightResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * Created by Zhouxin on 2020/8/24;
 */
@Api(value="warnInWeight接口",description = "入库重量预警")
public interface WarnInWeightControllerApi {

    @ApiOperation("分页查询入库重量预警列表")
    @ApiImplicitParams({
            //required=true是否必填，paramType="path"是http请求路径，dataType="int"数据类型
            @ApiImplicitParam(name="page",value = "页 码",required=true,paramType="path",dataType="int"),
            @ApiImplicitParam(name="size",value = "每页记录 数",required=true,paramType="path",dataType="int") })
    public QueryResponseResult findList(int page, int size, WarnInWeightRequest warnInWeightRequest) ;

    @ApiOperation("添加入库重量预警")
    public WarnInWeightResult add(WarnInWeight warnInWeight);

    @ApiOperation("通过id查询入库重量预警")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value = "入库重量预警id",required=true,paramType="path",dataType="String") })
    public WarnInWeightResult findById(String id);

    @ApiOperation("通过id修改入库重量预警")
    public WarnInWeightResult edit(String id, WarnInWeight warnInWeight);

    @ApiOperation("通过id删除入库重量预警")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value = "入库重量预警id",required=true,paramType="path",dataType="String") })
    public ResponseResult delete(String id);
}
