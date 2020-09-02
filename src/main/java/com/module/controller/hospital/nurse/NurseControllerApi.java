package com.module.controller.hospital.nurse;

import com.common.Response.QueryResponseResult;
import com.common.Response.ResponseResult;
import com.module.entity.hospital.nurse.Nurse;
import com.module.request.hospital.nurse.NurseRequest;
import com.module.response.hospital.nurse.NurseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * Created by Zhouxin on 2020/8/24;
 */
@Api(value="nurse接口",description = "护士")
public interface NurseControllerApi {

    @ApiOperation("分页查询护士列表")
    @ApiImplicitParams({
            //required=true是否必填，paramType="path"是http请求路径，dataType="int"数据类型
            @ApiImplicitParam(name="page",value = "页 码",required=true,paramType="path",dataType="int"),
            @ApiImplicitParam(name="size",value = "每页记录 数",required=true,paramType="path",dataType="int") })
    public QueryResponseResult findList(int page, int size, NurseRequest nurseRequest) ;

    @ApiOperation("添加护士")
    public NurseResult add(Nurse nurse);

    @ApiOperation("通过id查询护士")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value = "护士id",required=true,paramType="path",dataType="String") })
    public NurseResult findById(String id);

    @ApiOperation("通过id修改护士")
    public NurseResult edit(String id, Nurse nurse);

    @ApiOperation("通过id删除护士")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value = "护士id",required=true,paramType="path",dataType="String") })
    public ResponseResult delete(String id);
}
