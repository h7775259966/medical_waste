package com.module.controller.trashCollectController;

import com.common.Response.QueryResponseResult;
import com.common.Response.ResponseResult;
import com.module.entity.trashCollect.TrashCollect;
import com.module.request.trashCollect.TrashCollectRequest;
import com.module.response.trashCollect.TrashCollectResult;
import com.module.service.trashCollect.TrashCollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/trashCollect")
public class TrashCollectController implements TrashCollectControllerApi {

    @Autowired
    private TrashCollectService trashCollectService;


    /**
     * 分页同时自定义查询
     * @param page
     * @param size
     * @param trashCollectRequest
     * @return
     */
    @Override
    @GetMapping("/list/{page}/{size}")
    public QueryResponseResult findList(@PathVariable("page") int page, @PathVariable("size")int size, TrashCollectRequest trashCollectRequest) {

        return trashCollectService.findList(page,size, trashCollectRequest);
    }

    /**
     * 通过id查询公告
     * @param id
     * @return
     */
    @Override
    @GetMapping("/get/{id}")
    public TrashCollectResult findById(@PathVariable("id") String id) {

        return trashCollectService.findById(id);
    }


    /**
     * 添加公告
     * @param trashCollect
     * @return
     */
    @Override
    @PostMapping("/add")
    public TrashCollectResult add(@RequestBody TrashCollect trashCollect) {

        return trashCollectService.add(trashCollect);
    }

    /**
     * 通过id修改公告
     * @param id
     * @param trashCollect
     * @return
     */
    @Override
    @PutMapping("/edit/{id}")//这里使用put方法，http 方法中put表示更新
    public TrashCollectResult edit(@PathVariable("id") String id, @RequestBody TrashCollect trashCollect) {

        return trashCollectService.edit(id,trashCollect);
    }

    /**
     * 通过id删除公告
     * @param id
     * @return
     */
    @Override
    @DeleteMapping("/del/{id}") //使用http的delete方法完成删除操作
    public ResponseResult delete(@PathVariable("id") String id) {

        return trashCollectService.delete(id);
    }
}
