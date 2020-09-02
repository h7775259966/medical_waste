package com.module.controller.violation.violationExamine;

import com.common.Response.QueryResponseResult;
import com.common.Response.ResponseResult;
import com.module.entity.violation.violationExamine.ViolationExamine;
import com.module.request.violation.violationExamine.ViolationExamineRequest;
import com.module.response.violation.violationExamine.ViolationExamineResult;
import com.module.service.violationExamine.ViolationExamineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by huangbotao on 2020/8/28;
 */
@RestController
@RequestMapping("/violationExamine")
public class ViolationExamineController implements ViolationExamineControllerApi{

    @Autowired
    private ViolationExamineService violationExamineService;

    /**
     * 分页同时自定义查询
     * @param page
     * @param size
     * @param violationExamineRequest
     * @return
     */
    @Override
    @GetMapping("/list/{page}/{size}")
    public QueryResponseResult findList(@PathVariable("page") int page, @PathVariable("size")int size, ViolationExamineRequest violationExamineRequest) {

        return violationExamineService.findList(page,size, violationExamineRequest);
    }


    /**
     * 添加计划
     * @param violationExamine
     * @return
     */
    @Override
    @PostMapping("/add")
    public ViolationExamineResult add(@RequestBody ViolationExamine violationExamine) {

        return violationExamineService.add(violationExamine);
    }

    /**
     * 通过id查询计划
     * @param id
     * @return
     */
    @Override
    @GetMapping("/get/{id}")
    public ViolationExamineResult findById(@PathVariable("id") String id) {

        return violationExamineService.findById(id);
    }

    /**
     * 通过id修改计划
     * @param id
     * @param violationExamine
     * @return
     */
    @Override
    @PutMapping("/edit/{id}")//这里使用put方法，http 方法中put表示更新
    public ViolationExamineResult edit(@PathVariable("id") String id, @RequestBody ViolationExamine violationExamine) {

        return violationExamineService.edit(id,violationExamine);
    }

    /**
     * 通过id删除计划
     * @param id
     * @return
     */
    @Override
    @DeleteMapping("/del/{id}") //使用http的delete方法完成删除操作
    public ResponseResult delete(@PathVariable("id") String id) {

        return violationExamineService.delete(id);
    }
}
