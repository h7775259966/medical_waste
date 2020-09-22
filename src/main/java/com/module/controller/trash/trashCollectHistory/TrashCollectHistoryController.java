package com.module.controller.trash.trashCollectHistory;

import com.common.Response.QueryResponseResult;
import com.module.request.trash.trashCollectHistory.TrashCollectHistoryRequest;
import com.module.service.trash.trashCollectHistory.TrashCollectHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 收集历史
 * Created by huangbotao on 2020/9/22;
 */
@RestController
@RequestMapping("/trashCollectHistory")
public class TrashCollectHistoryController implements  TrashCollectHistoryControllerApi{


    @Autowired
    private TrashCollectHistoryService trashCollectHistoryService;


    /**
     * 分页同时自定义查询
     * @param page
     * @param size
     * @return
     */
    @Override
    @GetMapping("/list/{page}/{size}")
    public QueryResponseResult findHistory(@PathVariable("page") int page, @PathVariable("size")int size, TrashCollectHistoryRequest trashCollectHistoryRequest) {

        return trashCollectHistoryService.findHistory(page,size, trashCollectHistoryRequest);
    }
}
