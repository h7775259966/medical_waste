package com.module.controller.violation.violationHistory;

import com.common.Response.QueryResponseResult;
import com.module.request.violation.violationExamine.ViolationExamineRequest;
import com.module.request.violation.violationHistory.ViolationHistoryRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 违规历史
 * Created by huangbotao on 2020/9/21;
 */
@Api(value="violationHistory接口",description = "违规历史")
public interface ViolationHistoryContollerApi {

    @ApiOperation("分页查询违规检查列表")
    @ApiImplicitParams({
            //required=true是否必填，paramType="path"是http请求路径，dataType="int"数据类型
            @ApiImplicitParam(name="page",value = "页 码",required=true,paramType="path",dataType="int"),
            @ApiImplicitParam(name="size",value = "每页记录 数",required=true,paramType="path",dataType="int") })
    public QueryResponseResult findList(int page, int size, ViolationHistoryRequest violationHistoryRequest) ;
}
