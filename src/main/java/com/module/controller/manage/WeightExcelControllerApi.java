package com.module.controller.manage;

import com.module.entity.trash.trashCollect.TrashCollect;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * Created by huangbotao on 2020/9/22;
 */

@Api(value="导出医废重量Excel",description = "导出医废重量Excel")
public class WeightExcelControllerApi {

    @ApiOperation(value = "通过Excel导出重量", notes = "参数:无", produces = "application/octet-stream")
    public void excel(){

    }


}
