package com.module.controller.violationStandard;

import com.common.Response.QueryResponseResult;
import com.common.Response.ResponseResult;
import com.module.entity.violationStandard.ViolationStandard;
import com.module.request.violationStandard.ViolationStandardRequest;
import com.module.response.violationStandard.ViolationStandardResult;
import com.module.service.violationStandard.ViolationStandardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by huangbotao on 2020/8/27;
 */
@RestController
@RequestMapping("/violationStandard")
public class ViolationStandardController implements ViolationStandardControllerApi {

    @Autowired
    private ViolationStandardService violationStandardService;

    /**
     * 分页同时自定义查询
     * @param page
     * @param size
     * @param violationStandardRequest
     * @return
     */
    @Override
    @GetMapping("/list/{page}/{size}")
    public QueryResponseResult findList(@PathVariable("page") int page, @PathVariable("size")int size, ViolationStandardRequest violationStandardRequest) {

        return violationStandardService.findList(page,size, violationStandardRequest);
    }


    /**
     * 添加计划
     * @param violationStandard
     * @return
     */
    @Override
    @PostMapping("/add")
    public ViolationStandardResult add(@RequestBody ViolationStandard violationStandard) {

        return violationStandardService.add(violationStandard);
    }

    /**
     * 通过id查询计划
     * @param id
     * @return
     */
    @Override
    @GetMapping("/get/{id}")
    public ViolationStandardResult findById(@PathVariable("id") String id) {

        return violationStandardService.findById(id);
    }

    /**
     * 通过id修改计划
     * @param id
     * @param violationStandard
     * @return
     */
    @Override
    @PutMapping("/edit/{id}")//这里使用put方法，http 方法中put表示更新
    public ViolationStandardResult edit(@PathVariable("id") String id, @RequestBody ViolationStandard violationStandard) {

        return violationStandardService.edit(id,violationStandard);
    }

    /**
     * 通过id删除计划
     * @param id
     * @return
     */
    @Override
    @DeleteMapping("/del/{id}") //使用http的delete方法完成删除操作
    public ResponseResult delete(@PathVariable("id") String id) {

        return violationStandardService.delete(id);
    }
}