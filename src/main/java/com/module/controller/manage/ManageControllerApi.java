package com.module.controller.manage;

import com.module.entity.trash.trashCollect.TrashCollect;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;
import java.util.Map;

/**
 * Created by huangbotao on 2020/9/21;
 */


@Api(value="导出医废Excel的查询语句",description = "导出医废Excel的查询语句")
public interface ManageControllerApi {


    @ApiOperation("通过Excel导出重量的查询语句")
    public List<TrashCollect> findExcel(Map<String, Object> map);

}
