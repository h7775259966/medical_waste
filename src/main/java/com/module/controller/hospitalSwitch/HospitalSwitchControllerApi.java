package com.module.controller.hospitalSwitch;

import com.common.Response.hospitalSwitch.HospitalSwitchResult;
import com.module.entity.hospitalSwitch.HospitalSwitch;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**医院功能开关管理
 * Created by Zhouxin on 2020/8/24;
 */
@Api(value="hospitalSwitch接口",description = "医院功能开关管理")
public interface HospitalSwitchControllerApi {

    @ApiOperation("根据医院id查询所有功能开关")
    @ApiImplicitParams({@ApiImplicitParam(name="hospitalId",value = "医院id",required=true,paramType="path",dataType="String") })
    public HospitalSwitchResult findByHospitalId(String hospitalId);

    @ApiOperation("通过医院id保存所有功能开关")
    public HospitalSwitchResult save(String hospitalId, HospitalSwitch hospitalSwitch);

}
