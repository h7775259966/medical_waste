package com.module.controller.system.role;

import com.common.Response.QueryResponseResult;
import com.common.Response.ResponseResult;
import com.module.entity.system.role.User;
import com.module.request.system.role.UserRequest;
import com.module.response.system.role.UserResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

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
    public UserResult findById(String id);

    @ApiOperation("通过id修改用户")
    public UserResult edit(String id, User user);

    @ApiOperation("通过id删除用户")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value = "用户id",required=true,paramType="path",dataType="String") })
    public ResponseResult delete(String id);

    @ApiOperation("通过id修改用户状态")
    public UserResult editStatus(String id, Integer status);
}
