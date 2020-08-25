package com.module.controller.User;

import com.module.entity.User.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.util.List;

/**
 * Created by Zhouxin on 2020/8/24;
 */
@Api(value="user管理接口",description = "提供user页面的增、删、改、查")
public interface UserControllerApi {

    @ApiOperation("查询所有")
    public List<User> queryUserList();

    @ApiOperation("查询所有2")
    public List<User> queryUserList2();
}
