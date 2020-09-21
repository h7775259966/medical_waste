package com.module.controller.violation.violationHistory;

import com.common.Response.QueryResponseResult;
import com.module.request.violation.violationExamine.ViolationExamineRequest;
import com.module.request.violation.violationHistory.ViolationHistoryRequest;
import com.module.service.violationExamine.ViolationExamineService;
import com.module.service.violationHistory.ViolationHistoryService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by huangbotao on 2020/9/21;
 *
 * 违规历史
 */


@RestController
@RequestMapping("/violationHistory")
public class ViolationHistoryController implements ViolationHistoryContollerApi{


    @Autowired
    private ViolationHistoryService violationHistoryService;

    /**
     * 分页同时自定义查询
     * @param page
     * @param size
     * @param violationHistoryRequest
     * @return 违规历史查询
     */
    @Override
    @GetMapping("/list/{page}/{size}")
    public QueryResponseResult findList(@PathVariable("page") int page, @PathVariable("size")int size, ViolationHistoryRequest violationHistoryRequest) {

        return violationHistoryService.findList(page,size, violationHistoryRequest);
    }


}
