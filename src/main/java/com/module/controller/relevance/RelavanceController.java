package com.module.controller.relevance;

import com.common.Request.collect.CollectRequest;
import com.common.Request.relavance.RelavanceRequest;
import com.common.Response.QueryResponseResult;
import com.module.service.relevance.RelavanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by huangbotao on 2020/9/28;
 */

@RestController
@RequestMapping("/relavance")
public class RelavanceController implements RelavanceControllerApi{

    @Autowired
    private RelavanceService relavanceService;

    @Override
    @GetMapping("/list/{page}/{size}")
    public QueryResponseResult findRelavance(@PathVariable("page") int page, @PathVariable("size")int size, RelavanceRequest relavanceRequest) {

        return relavanceService.findRelavance(page,size, relavanceRequest);
    }

    @Override
    @GetMapping("/sum/{page}/{size}")
    public QueryResponseResult findSum(@PathVariable("page") int page, @PathVariable("size")int size, RelavanceRequest relavanceRequest) {

        return relavanceService.findSum(page,size, relavanceRequest);
    }

    @Override
    @GetMapping("/sumPackets/{page}/{size}")
    public QueryResponseResult findSumPackets(@PathVariable("page") int page, @PathVariable("size")int size, RelavanceRequest relavanceRequest) {

        return relavanceService.findSumPackets(page,size, relavanceRequest);
    }
}
