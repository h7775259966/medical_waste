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
     * 破损预警统计
     */
    @Override
    @GetMapping("/damage/{page}/{size}")
    public QueryResponseResult customWarn(@PathVariable("page") int page, @PathVariable("size") int size, CustomWarnRequest customWarnRequest) {

        return customService.customWarn(page, size, customWarnRequest);

    }

    /**
     *
     * @param page
     * @param size
     * @param customWarnRequest
     * @return
     * 入库预警
     */
    @Override
    @GetMapping("/InWeight/{page}/{size}")
    public QueryResponseResult customInWeight(@PathVariable("page") int page, @PathVariable("size") int size, CustomWarnRequest customWarnRequest) {

        return customService.customInWeight(page, size, customWarnRequest);

    }

    /**
     *
     * @param page
     * @param size
     * @param customWarnRequest
     * @return
     * 破损预警
     */
    @Override
    @GetMapping("/leakage/{page}/{size}")
    public QueryResponseResult customLeakage(@PathVariable("page") int page, @PathVariable("size") int size, CustomWarnRequest customWarnRequest) {

        return customService.customLeakage(page, size, customWarnRequest);

    }

    /**
     *
     * @param page
     * @param size
     * @param customWarnRequest
     * @return
     * 遗失预警
     */

    @Override
    @GetMapping("/lose/{page}/{size}")
    public QueryResponseResult customLose(@PathVariable("page") int page, @PathVariable("size") int size, CustomWarnRequest customWarnRequest) {

        return customService.customLose(page, size, customWarnRequest);

    }


    /**
     *
     * 未出预警
     * @param page
     * @param size
     * @param customWarnRequest
     * @return
     */
    @Override
    @GetMapping("/noOut/{page}/{size}")
    public QueryResponseResult customNoOut(@PathVariable("page") int page, @PathVariable("size") int size, CustomWarnRequest customWarnRequest) {

        return customService.customNoOut(page, size, customWarnRequest);

    }


    /**
     *
     * @param page
     * @param size
     * @param customWarnRequest
     * @return
     * 超时预警
     */

    @Override
    @GetMapping("/overtime/{page}/{size}")
    public QueryResponseResult customOutOvertime(@PathVariable("page") int page, @PathVariable("size") int size, CustomWarnRequest customWarnRequest) {

        return customService.customOutOvertime(page, size, customWarnRequest);

    }


    /**
     *
     * @param page
     * @param size
     * @param customWarnRequest
     * @return
     * 出库重量预警
     */
    @Override
    @GetMapping("/OutWeight/{page}/{size}")
    public QueryResponseResult customOutWeight(@PathVariable("page") int page, @PathVariable("size") int size, CustomWarnRequest customWarnRequest) {

        return customService.customOutWeight(page, size, customWarnRequest);

    }


    /**
     *
     * @param page
     * @param size
     * @param customWarnRequest
     * @return
     * 违规预警
     */
    @Override
    @GetMapping("/Violation/{page}/{size}")
    public QueryResponseResult customViolation(@PathVariable("page") int page, @PathVariable("size") int size, CustomWarnRequest customWarnRequest) {

        return customService.customViolation(page, size, customWarnRequest);

    }
}
