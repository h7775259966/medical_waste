package com.module.controller.violation.violationStandard;

import com.common.Response.QueryResponseResult;
import com.common.Response.ResponseResult;
import com.module.entity.violation.violationStandard.ViolationStandard;
import com.module.request.violation.violationStandard.ViolationStandardRequest;
import com.module.response.violation.violationStandard.ViolationStandardResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * Created by huangbotao on 2020/8/27;
 */
@Api(value="violationStandard接口",description = "违规标准")
public interface ViolationStandardControllerApi {

    @ApiOperation("分页查询计划列表")
    @ApiImplicitParams({
            //required=true是否必填，paramType="path"是http请求路径，dataType="int"数据类型
            @ApiImplicitParam(name="page",value = "页 码",required=true,paramType="path",dataType="int"),
            @ApiImplicitParam(name="size",value = "每页记录 数",required=true,paramType="path",dataType="int") })
    public QueryResponseResult findList(int page, int size, ViolationStandardRequest violationStandardRequest) ;

    @ApiOperation("添加违规标准")
    public ViolationStandardResult add(ViolationStandard violationStandard);

    @ApiOperation("通过id查询违规标准")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value = "计划id",required=true,paramType="path",dataType="String") })
    public ViolationStandardResult findById(String id);

    @ApiOperation("通过id修改违规标准")
    public ViolationStandardResult edit(String id, ViolationStandard violationStandard);

    @ApiOperation("通过id删除违规标准")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value = "计划id",required=true,paramType="path",dataType="String") })
    public ResponseResult delete(String id);
}

