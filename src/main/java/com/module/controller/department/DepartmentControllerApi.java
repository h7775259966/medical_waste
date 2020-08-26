package com.module.controller.department;

import com.common.Response.QueryResponseResult;
import com.common.Response.ResponseResult;
import com.module.entity.department.Department;
import com.module.request.department.DepartmentRequest;
import com.module.response.department.DepartmentResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * Created by Zhouxin on 2020/8/24;
 */
@Api(value="department接口",description = "部门")
public interface DepartmentControllerApi {

    @ApiOperation("分页查询部门列表")
    @ApiImplicitParams({
            //required=true是否必填，paramType="path"是http请求路径，dataType="int"数据类型
            @ApiImplicitParam(name="page",value = "页 码",required=true,paramType="path",dataType="int"),
            @ApiImplicitParam(name="size",value = "每页记录 数",required=true,paramType="path",dataType="int") })
    public QueryResponseResult findList(int page, int size, DepartmentRequest departmentRequest) ;

    @ApiOperation("添加部门")
    public DepartmentResult add(Department department);

    @ApiOperation("通过id查询部门")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value = "部门id",required=true,paramType="path",dataType="String") })
    public DepartmentResult findById(String id);

    @ApiOperation("通过id修改部门")
    public DepartmentResult edit(String id, Department department);

    @ApiOperation("通过id删除部门")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value = "部门id",required=true,paramType="path",dataType="String") })
    public ResponseResult delete(String id);
}
