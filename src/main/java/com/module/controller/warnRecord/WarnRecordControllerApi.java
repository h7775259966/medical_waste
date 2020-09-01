package com.module.controller.warnRecord;

import com.common.Response.QueryResponseResult;
import com.common.Response.ResponseResult;
import com.module.entity.warnRecord.WarnRecord;
import com.module.request.warnRecord.WarnRecordRequest;
import com.module.response.warnRecord.WarnRecordResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * Created by Zhouxin on 2020/8/24;
 */
@Api(value="warnRecord接口",description = "预警记录")
public interface WarnRecordControllerApi {

    @ApiOperation("分页查询预警记录列表")
    @ApiImplicitParams({
            //required=true是否必填，paramType="path"是http请求路径，dataType="int"数据类型
            @ApiImplicitParam(name="page",value = "页 码",required=true,paramType="path",dataType="int"),
            @ApiImplicitParam(name="size",value = "每页记录 数",required=true,paramType="path",dataType="int") })
    public QueryResponseResult findList(int page, int size, WarnRecordRequest warnRecordRequest) ;

    @ApiOperation("添加预警记录")
    public WarnRecordResult add(WarnRecord warnRecord);

    @ApiOperation("通过id查询预警记录")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value = "预警记录id",required=true,paramType="path",dataType="String") })
    public WarnRecordResult findById(String id);

    @ApiOperation("通过id修改预警记录")
    public WarnRecordResult edit(String id, WarnRecord warnRecord);

    @ApiOperation("通过id删除预警记录")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value = "预警记录id",required=true,paramType="path",dataType="String") })
    public ResponseResult delete(String id);
}
