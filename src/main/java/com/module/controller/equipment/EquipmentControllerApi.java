package com.module.controller.equipment;


import com.common.Response.QueryResponseResult;
import com.common.Response.ResponseResult;
import com.module.entity.equipment.Equipment;
import com.module.request.equipment.EquipmentRequest;
import com.module.response.equipment.EquipmentResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value="equipment接口",description = "提供设备的增、删、改、查")
public interface EquipmentControllerApi {

    @ApiOperation("分页查询设备列表")
    @ApiImplicitParams({
            //required=true是否必填，paramType="path"是http请求路径，dataType="int"数据类型
            @ApiImplicitParam(name="page",value = "页 码",required=true,paramType="path",dataType="int"),
            @ApiImplicitParam(name="size",value = "每页记录 数",required=true,paramType="path",dataType="int") })
    public QueryResponseResult findList(int page, int size, EquipmentRequest equipmentRequest) ;

    @ApiOperation("添加设备")
    public EquipmentResult add(Equipment equipment);

    @ApiOperation("通过id查询设备")
    public EquipmentResult findById(String id);

    @ApiOperation("通过id修改设备")
    public EquipmentResult edit(String id, Equipment equipment);

    @ApiOperation("通过id删除设备")
    public ResponseResult delete(String id);
}
