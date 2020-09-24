package com.module.controller.system.dict;

import com.common.Response.QueryResponseResult;
import com.common.Response.ResponseResult;
import com.module.entity.system.dict.Dict;
import com.common.Request.system.dict.DictRequest;
import com.common.Response.system.dict.DictResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * Created by Zhouxin on 2020/8/24;
 */
@Api(value="dict接口",description = "系统字典")
public interface DictControllerApi {

    @ApiOperation("分页查询系统字典列表")
    @ApiImplicitParams({
            //required=true是否必填，paramType="path"是http请求路径，dataType="int"数据类型
            @ApiImplicitParam(name="page",value = "页 码",required=true,paramType="path",dataType="int"),
            @ApiImplicitParam(name="size",value = "每页记录 数",required=true,paramType="path",dataType="int") })
    public QueryResponseResult findList(int page, int size, DictRequest dictRequest) ;

    @ApiOperation("添加系统字典")
    public DictResult add(Dict dict);

    @ApiOperation("通过id查询系统字典")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value = "系统字典id",required=true,paramType="path",dataType="String") })
    public DictResult findById(String id);

    @ApiOperation("通过id修改系统字典")
    public DictResult edit(String id, Dict dict);

    @ApiOperation("通过id删除系统字典")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value = "系统字典id",required=true,paramType="path",dataType="String") })
    public ResponseResult delete(String id);

    @ApiOperation("通过字典api查询所有字典数据")
    @ApiImplicitParams({@ApiImplicitParam(name="dictApi",value = "字典api",required=true,paramType="path",dataType="String") })
    public QueryResponseResult findByDictApi(String dictApi);
}
