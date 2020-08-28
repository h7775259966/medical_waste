package com.module.controller.violationExamine;

import com.common.Response.QueryResponseResult;
import com.common.Response.ResponseResult;
import com.module.entity.violationExamine.ViolationExamine;
import com.module.request.violationExamine.ViolationExamineRequest;
import com.module.response.violationExamine.ViolationExamineResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * Created by huangbotao on 2020/8/28;
 */
@Api(value="ViolationExamine",description = "违规检查")
public interface ViolationExamineControllerApi {

    @ApiOperation("分页查询违规检查列表")
    @ApiImplicitParams({
            //required=true是否必填，paramType="path"是http请求路径，dataType="int"数据类型
            @ApiImplicitParam(name="page",value = "页 码",required=true,paramType="path",dataType="int"),
            @ApiImplicitParam(name="size",value = "每页记录 数",required=true,paramType="path",dataType="int") })
    public QueryResponseResult findList(int page, int size, ViolationExamineRequest violationExamineRequest) ;

    @ApiOperation("添加违规检查")
    public ViolationExamineResult add(ViolationExamine violationExamine);

    @ApiOperation("通过id查询违规检查")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value = "违规检查id",required=true,paramType="path",dataType="String") })
    public ViolationExamineResult findById(String id);

    @ApiOperation("通过id修改违规检查")
    public ViolationExamineResult edit(String id, ViolationExamine violationExamine);

    @ApiOperation("通过id删除违规检查")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value = "违规检查id",required=true,paramType="path",dataType="String") })
    public ResponseResult delete(String id);
}
