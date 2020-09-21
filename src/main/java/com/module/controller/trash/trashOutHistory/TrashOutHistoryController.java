package com.module.controller.trash.trashOutHistory;

import com.common.Response.QueryResponseResult;
import com.common.Response.ResponseResult;
import com.module.entity.trash.trashOutHistory.TrashOutHistory;
import com.module.request.trash.trashOutHistory.TrashOutHistoryRequest;
import com.module.response.trash.trashOutHistory.TrashOutHistoryResult;
import com.module.service.trash.TrashOutHistory.TrashOutHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 出库记录Controller
 * Created by huangbotao on 2020/8/27;
 */
@RestController
@RequestMapping("/trashOutHistory")
public class TrashOutHistoryController implements TrashOutHistoryControllerApi {

    @Autowired
    private TrashOutHistoryService trashOutHService;

    /**
     * 分页同时自定义查询
     * @param page
     * @param size
     * @param trashOutHRequest
     * @return
     */
    @Override
    @GetMapping("/list/{page}/{size}")
    public QueryResponseResult findList(@PathVariable("page") int page, @PathVariable("size")int size, TrashOutHistoryRequest trashOutHRequest) {

        return trashOutHService.findList(page,size, trashOutHRequest);
    }


    /**
     * 添加计划
     * @param trashOutH
     * @return
     */
    @Override
    @PostMapping("/add")
    public TrashOutHistoryResult add(@RequestBody TrashOutHistory trashOutH) {

        return trashOutHService.add(trashOutH);
    }

    /**
     * 通过id查询计划
     * @param id
     * @return
     */
    @Override
    @GetMapping("/get/{id}")
    public TrashOutHistoryResult findById(@PathVariable("id") String id) {

        return trashOutHService.findById(id);
    }

    /**
     * 通过id修改计划
     * @param id
     * @param trashOutH
     * @return
     */
    @Override
    @PutMapping("/edit/{id}")//这里使用put方法，http 方法中put表示更新
    public TrashOutHistoryResult edit(@PathVariable("id") String id, @RequestBody TrashOutHistory trashOutH) {

        return trashOutHService.edit(id,trashOutH);
    }

    /**
     * 通过id删除计划
     * @param id
     * @return
     */
    @Override
    @DeleteMapping("/del/{id}") //使用http的delete方法完成删除操作
    public ResponseResult delete(@PathVariable("id") String id) {

        return trashOutHService.delete(id);
    }
}