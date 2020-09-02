package com.module.controller.trash.trashOut;

import com.common.Response.QueryResponseResult;
import com.common.Response.ResponseResult;
import com.module.entity.trash.trashOut.TrashOut;
import com.module.request.trash.trashOut.TrashOutRequest;
import com.module.response.trash.trashOut.TrashOutResult;
import com.module.service.trash.trashOut.TrashOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/trashOut")
public class TrashOutController implements TrashOutControllerApi {

    @Autowired
    private TrashOutService trashOutService;


    /**
     * 分页同时自定义查询
     * @param page
     * @param size
     * @param trashOutRequest
     * @return
     */
    @Override
    @GetMapping("/list/{page}/{size}")
    public QueryResponseResult findList(@PathVariable("page") int page, @PathVariable("size")int size, TrashOutRequest trashOutRequest) {

        return trashOutService.findList(page,size, trashOutRequest);
    }

    @Override
    @GetMapping("/search/{page}/{size}")
    public QueryResponseResult search(@PathVariable("page") int page, @PathVariable("size")int size, TrashOutRequest trashOutRequest) {

        return trashOutService.findList(page,size, trashOutRequest);
    }

    /**
     * 通过id查询医废收集
     * @param id
     * @return
     */
    @Override
    @GetMapping("/get/{id}")
    public TrashOutResult findById(@PathVariable("id") String id) {

        return trashOutService.findById(id);
    }



    /**
     * 添加医废收集
     * @param trashOut
     * @return
     */
    @Override
    @PostMapping("/add")
    public TrashOutResult add(@RequestBody TrashOut trashOut) {

        return trashOutService.add(trashOut);
    }

    /**
     * 通过id修改医废收集
     * @param id
     * @param trashOut
     * @return
     */
    @Override
    @PutMapping("/edit/{id}")//这里使用put方法，http 方法中put表示更新
    public TrashOutResult edit(@PathVariable("id") String id, @RequestBody TrashOut trashOut) {

        return trashOutService.edit(id,trashOut);
    }

    /**
     * 通过id删除医废收集
     * @param id
     * @return
     */
    @Override
    @DeleteMapping("/del/{id}") //使用http的delete方法完成删除操作
    public ResponseResult delete(@PathVariable("id") String id) {

        return trashOutService.delete(id);
    }
}
