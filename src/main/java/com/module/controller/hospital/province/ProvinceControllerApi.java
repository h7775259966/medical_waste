package com.module.controller.hospital.province;

import com.common.Response.QueryResponseResult;
import com.common.Response.ResponseResult;
import com.module.entity.hospital.province.Province;
import com.common.Request.hospital.province.ProvinceRequest;
import com.common.Response.hospital.province.ProvinceResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Zhouxin on 2020/8/24;
 */
@Api(value="province接口",description = "省级单位")
public interface ProvinceControllerApi {

    @ApiOperation("分页查询省级单位列表")
    @ApiImplicitParams({
            //required=true是否必填，paramType="path"是http请求路径，dataType="int"数据类型
            @ApiImplicitParam(name="page",value = "页 码",required=true,paramType="path",dataType="int"),
            @ApiImplicitParam(name="size",value = "每页记录 数",required=true,paramType="path",dataType="int") })
    public QueryResponseResult findList(int page, int size, ProvinceRequest provinceRequest) ;

    @ApiOperation("查询所有省级单位")
    public QueryResponseResult all();

    @ApiOperation("添加省级单位")
    public ProvinceResult add(Province province);

    @ApiOperation("通过id查询省级单位")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value = "省级单位id",required=true,paramType="path",dataType="String") })
    public ProvinceResult findById(String id);

    @ApiOperation("通过id修改省级单位")
    public ProvinceResult edit(String id, Province province);

    @ApiOperation("通过id删除省级单位")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value = "省级单位id",required=true,paramType="path",dataType="String") })
    public ResponseResult delete(String id);

}
