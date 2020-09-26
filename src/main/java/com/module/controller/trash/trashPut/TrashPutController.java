package com.module.controller.trash.trashPut;

import com.common.Response.QueryResponseResult;
import com.common.Response.ResponseResult;
import com.module.entity.trash.trashPut.TrashPut;
import com.common.Request.trash.trashPut.TrashPutRequest;
import com.common.Response.trash.trashPut.TrashPutResult;
import com.module.service.trash.trashPut.TrashPutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 医废入库Controller
 * Created by huangbotao on 2020/8/31;
 */
@RestController
@RequestMapping("/trashPut")
public class TrashPutController implements TrashPutControllerApi {

    @Autowired
    private TrashPutService trashPutService;


    /**
     * 分页同时自定义查询
     * @param page
     * @param size
     * @param trashPutRequest
     * @return
     */
    @Override
    @GetMapping("/list/{page}/{size}")
    public QueryResponseResult findListByRequest(@PathVariable("page") int page, @PathVariable("size")int size, TrashPutRequest trashPutRequest) {

        return trashPutService.findListByRequest(page,size, trashPutRequest);
    }

    /**
     * 通过id查询医废入库
     * @param id
     * @return
     */
    @Override
    @GetMapping("/get/{id}")
    public TrashPutResult findById(@PathVariable("id") String id) {

        return trashPutService.findById(id);
    }


    /**
     * 添加医废入库
     * @param trashPut
     * @return
     */
    @Override
    @PostMapping("/add")
    public TrashPutResult add(@RequestBody TrashPut trashPut) {

        return trashPutService.add(trashPut);
    }

    /**
     * 通过id修改医废入库
     * @param id
     * @param trashPut
     * @return
     */
    @Override
    @PutMapping("/edit/{id}")//这里使用put方法，http 方法中put表示更新
    public TrashPutResult edit(@PathVariable("id") String id, @RequestBody TrashPut trashPut) {

        return trashPutService.edit(id,trashPut);
    }

    /**
     * 通过id删除医废入库
     * @param id
     * @return
     */
    @Override
    @DeleteMapping("/del/{id}") //使用http的delete方法完成删除操作
    public ResponseResult delete(@PathVariable("id") String id) {

        return trashPutService.delete(id);
    }
}
