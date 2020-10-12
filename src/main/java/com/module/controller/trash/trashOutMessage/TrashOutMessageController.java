package com.module.controller.trash.trashOutMessage;

import com.common.Request.trash.trashOutMessage.TrashOutMessageRequest;
import com.common.Response.QueryResponseResult;
import com.common.Response.ResponseResult;
import com.common.Response.trash.trashOutMessage.TrashOutMessageResult;
import com.module.entity.trash.trashOutMessage.TrashOutMessage;
import com.module.service.trash.trashOutMessage.TrashOutMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 出库转运信息Controller
 * @author hbt
 * @version 2020-09-03
 */

@RestController
@RequestMapping("/trashOutMessage")
public class TrashOutMessageController implements TrashOutMessageControllerApi {

    @Autowired
    private TrashOutMessageService trashOutMessageService;


    /**
     * 分页同时自定义查询
     * @param page
     * @param size
     * @param trashOutMessageRequest
     * @return
     */
    @Override
    @GetMapping("/list/{page}/{size}")
    public QueryResponseResult findList(@PathVariable("page") int page, @PathVariable("size")int size, TrashOutMessageRequest trashOutMessageRequest) {

        return trashOutMessageService.findList(page,size, trashOutMessageRequest);
    }


    /**
     * 通过id查询出库转运信息
     * @param id
     * @return
     */
    @Override
    @GetMapping("/get/{id}")
    public TrashOutMessageResult findById(@PathVariable("id") String id) {

        return trashOutMessageService.findById(id);
    }



    /**
     * 添加出库转运信息
     * @param trashOutMessage
     * @return
     */
    @Override
    @PostMapping("/add")
    public TrashOutMessageResult add(@RequestBody TrashOutMessage trashOutMessage) {

        return trashOutMessageService.add(trashOutMessage);
    }

    /**
     * 通过id修改出库转运信息
     * @param id
     * @param trashOutMessage
     * @return
     */
    @Override
    @PutMapping("/edit/{id}")//这里使用put方法，http 方法中put表示更新
    public TrashOutMessageResult edit(@PathVariable("id") String id, @RequestBody TrashOutMessage trashOutMessage) {

        return trashOutMessageService.edit(id,trashOutMessage);
    }

    /**
     * 通过id删除出库转运信息
     * @param id
     * @return
     */
    @Override
    @DeleteMapping("/del/{id}") //使用http的delete方法完成删除操作
    public ResponseResult delete(@PathVariable("id") String id) {

        return trashOutMessageService.delete(id);
    }
}
