package com.module.controller.custom;

import com.common.Response.QueryResponseResult;
import com.common.Request.custom.CustomRequest;
import com.common.Request.custom.CustomWarnRequest;
import com.module.service.custom.CustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * 自定义查询
 * Created by huangbotao on 2020/9/21;
 */

@RestController
@RequestMapping("/custom")
public class CustomController implements CustomControllerApi {


    @Autowired
    private CustomService customService;

    /**
     * 重量统计
     */
    @Override
    @GetMapping("/list/{page}/{size}")
    public QueryResponseResult customFind(@PathVariable("page") int page, @PathVariable("size") int size, CustomRequest customRequest) {

        return customService.customFind(page, size, customRequest);
    }


    /**
     * 预警统计
     */
    @Override
    @GetMapping("/warn/{page}/{size}")
    public QueryResponseResult customWarn(@PathVariable("page") int page, @PathVariable("size") int size, CustomWarnRequest customWarnRequest) {

        return customService.customWarn(page, size, customWarnRequest);

    }

}
