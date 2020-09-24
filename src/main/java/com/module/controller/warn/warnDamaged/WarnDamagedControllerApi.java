package com.module.controller.warn.warnDamaged;

import com.common.Response.QueryResponseResult;
import com.common.Response.ResponseResult;
import com.module.entity.warn.warnDamaged.WarnDamaged;
import com.common.Request.warn.warnDamaged.WarnDamagedRequest;
import com.common.Response.warn.warnDamaged.WarnDamagedResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * Created by Zhouxin on 2020/8/24;
 */
@Api(value="warnDamaged接口",description = "破损预警")
public interface WarnDamagedControllerApi {

    @ApiOperation("分页查询破损预警列表")
    @ApiImplicitParams({
            //required=true是否必填，paramType="path"是http请求路径，dataType="int"数据类型
            @ApiImplicitParam(name="page",value = "页 码",required=true,paramType="path",dataType="int"),
            @ApiImplicitParam(name="size",value = "每页记录 数",required=true,paramType="path",dataType="int") })
    public QueryResponseResult findList(int page, int size, WarnDamagedRequest warnDamagedRequest) ;

    @ApiOperation("添加破损预警")
    public WarnDamagedResult add(WarnDamaged warnDamaged);

    @ApiOperation("通过id查询破损预警")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value = "破损预警id",required=true,paramType="path",dataType="String") })
    public WarnDamagedResult findById(String id);

    @ApiOperation("通过id修改破损预警")
    public WarnDamagedResult edit(String id, WarnDamaged warnDamaged);

    @ApiOperation("通过id删除破损预警")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value = "破损预警id",required=true,paramType="path",dataType="String") })
    public ResponseResult delete(String id);
}
