package com.module.controller.system.user;

import com.common.Response.MapResult;
import com.common.Response.QueryResponseResult;
import com.common.Response.ResponseResult;
import com.module.entity.system.user.User;
import com.common.Request.system.user.LoginRequest;
import com.common.Request.system.user.UserAndRoleRequest;
import com.common.Request.system.user.UserRequest;
import com.common.Response.system.user.LoginResult;
import com.common.Response.system.user.UserResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Zhouxin on 2020/8/24;
 */
@Api(value="user接口",description = "用户")
public interface UserControllerApi {

    @ApiOperation("分页查询用户列表")
    @ApiImplicitParams({
            //required=true是否必填，paramType="path"是http请求路径，dataType="int"数据类型
            @ApiImplicitParam(name="page",value = "页 码",required=true,paramType="path",dataType="int"),
            @ApiImplicitParam(name="size",value = "每页记录 数",required=true,paramType="path",dataType="int") })
    public QueryResponseResult findList(int page, int size, UserRequest userRequest) ;

    @ApiOperation("添加用户")
    public UserResult add(User user);

    @ApiOperation("通过id查询用户")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value = "用户id",required=true,paramType="path",dataType="String") })
    public MapResult findById(String id);

    @ApiOperation("通过id修改用户")
    public UserResult edit(String id, User user);

    @ApiOperation("通过id删除用户")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value = "用户id",required=true,paramType="path",dataType="String") })
    public ResponseResult delete(String id);

    @ApiOperation("通过id修改用户状态")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value = "用户id",required=true,paramType="path",dataType="String"),
            @ApiImplicitParam(name="status",value = "启用状态",required=true,paramType="path",dataType="Integer")})
    public UserResult editStatus(String id, Integer status);

    @ApiOperation("给用户分配角色")
    public ResponseResult assignRoles(UserAndRoleRequest userAndRoleRequest);

    @ApiOperation("用户登录,认证后返回token")
    public LoginResult login(LoginRequest loginRequest) ;

    @ApiOperation("登录成功后，根据token获取用户信息和所有权限标识")
    public MapResult profile(HttpServletRequest request) ;
}
