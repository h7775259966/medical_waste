package com.module.controller.system.role;

import com.module.entity.system.role.Permission;
import com.common.Response.QueryResponseResult;
import com.common.Response.ResponseResult;
import com.module.entity.system.role.PermissionAll;
import com.module.request.system.role.PermissionRequest;
import com.module.response.system.role.PermissionResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

/**
 * Created by Zhouxin on 2020/8/24;
 */
@Api(value="permission接口",description = "权限")
public interface PermissionControllerApi {

    @ApiOperation("分页查询权限列表")
    @ApiImplicitParams({
            //required=true是否必填，paramType="path"是http请求路径，dataType="int"数据类型
            @ApiImplicitParam(name="page",value = "页 码",required=true,paramType="path",dataType="int"),
            @ApiImplicitParam(name="size",value = "每页记录 数",required=true,paramType="path",dataType="int") })
    public QueryResponseResult findList(int page, int size, PermissionRequest permissionRequest) ;

    @ApiOperation("查询所有权限")
    public QueryResponseResult all();

    @ApiOperation("添加权限")
    public PermissionResult add(PermissionAll permissionAll);

    @ApiOperation("通过id查询权限")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value = "权限id",required=true,paramType="path",dataType="String") })
    public PermissionResult findById(String id);

    @ApiOperation("通过id修改权限")
    public PermissionResult edit(String id, PermissionAll permissionAll);

    @ApiOperation("通过id删除权限")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value = "权限id",required=true,paramType="path",dataType="String") })
    public ResponseResult delete(String id);

}
