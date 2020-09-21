package com.module.controller.system.role;

import com.common.Response.QueryResponseResult;
import com.common.Response.ResponseResult;
import com.module.entity.system.role.Role;
import com.module.request.system.role.RoleAndPermissionRequest;
import com.module.request.system.role.RoleRequest;
import com.module.response.system.role.RoleResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * Created by Zhouxin on 2020/8/24;
 */
@Api(value="role接口",description = "角色")
public interface RoleControllerApi {

    @ApiOperation("分页查询角色列表")
    @ApiImplicitParams({
            //required=true是否必填，paramType="path"是http请求路径，dataType="int"数据类型
            @ApiImplicitParam(name="page",value = "页 码",required=true,paramType="path",dataType="int"),
            @ApiImplicitParam(name="size",value = "每页记录 数",required=true,paramType="path",dataType="int") })
    public QueryResponseResult findList(int page, int size, RoleRequest roleRequest) ;

    @ApiOperation("添加角色")
    public RoleResult add(Role role);

    @ApiOperation("通过id查询角色")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value = "角色id",required=true,paramType="path",dataType="String") })
    public RoleResult findById(String id);

    @ApiOperation("通过id修改角色")
    public RoleResult edit(String id, Role role);

    @ApiOperation("通过id删除角色")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value = "角色id",required=true,paramType="path",dataType="String") })
    public ResponseResult delete(String id);

    @ApiOperation("给角色分配权限")
    public ResponseResult assignPrem(RoleAndPermissionRequest roleAndPermissionRequest);

}
