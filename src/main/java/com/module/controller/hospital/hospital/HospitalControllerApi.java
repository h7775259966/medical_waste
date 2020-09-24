package com.module.controller.hospital.hospital;

import com.common.Response.QueryResponseResult;
import com.common.Response.ResponseResult;
import com.module.entity.hospital.hospital.Hospital;
import com.common.Request.hospital.hospital.HospitalRequest;
import com.common.Response.hospital.hospital.HospitalResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * Created by Zhouxin on 2020/8/24;
 */
@Api(value="hospital接口",description = "医院")
public interface HospitalControllerApi {

    @ApiOperation("分页查询医院列表")
    @ApiImplicitParams({
            //required=true是否必填，paramType="path"是http请求路径，dataType="int"数据类型
            @ApiImplicitParam(name="page",value = "页 码",required=true,paramType="path",dataType="int"),
            @ApiImplicitParam(name="size",value = "每页记录 数",required=true,paramType="path",dataType="int") })
    public QueryResponseResult findList(int page, int size, HospitalRequest hospitalRequest) ;

    @ApiOperation("查询所有医院")
    public QueryResponseResult all();

    @ApiOperation("添加医院")
    public HospitalResult add(Hospital hospital);

    @ApiOperation("通过id查询医院")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value = "医院id",required=true,paramType="path",dataType="String") })
    public HospitalResult findById(String id);

    @ApiOperation("通过id修改医院")
    public HospitalResult edit(String id, Hospital hospital);

    @ApiOperation("通过id删除医院")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value = "医院id",required=true,paramType="path",dataType="String") })
    public ResponseResult delete(String id);


    @ApiOperation("通过图片上传")
    public ResponseResult fileUpload(MultipartFile file);
}
