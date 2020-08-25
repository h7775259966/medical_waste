package com.module.controller.department;

import com.common.response.QueryResponseResult;
import com.common.response.ResponseResult;
import com.module.entity.department.Department;
import com.module.request.department.DepartmentPageRequest;
import com.module.response.department.DepartmentPageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * Created by Zhouxin on 2020/8/24;
 */
@Api(value="department接口",description = "提供部门的增、删、改、查")
public interface DepartmentControllerApi {

    @ApiOperation("分页查询部门列表")
    @ApiImplicitParams({
            //required=true是否必填，paramType="path"是http请求路径，dataType="int"数据类型
            @ApiImplicitParam(name="page",value = "页 码",required=true,paramType="path",dataType="int"),
            @ApiImplicitParam(name="size",value = "每页记录 数",required=true,paramType="path",dataType="int") })
    public QueryResponseResult findList(int page, int size, DepartmentPageRequest departmentPageRequest) ;

    @ApiOperation("添加部门")
    public DepartmentPageResult add(Department department);

    @ApiOperation("通过id查询部门")
    public Department findById(String id);

    @ApiOperation("通过id修改部门")
    public DepartmentPageResult edit(String id, Department department);

    @ApiOperation("通过id删除部门")
    public ResponseResult delete(String id);
}
