package com.module.controller.plan;

import com.common.Exception.ExceptionCast;
import com.common.Response.CommonCode;
import com.common.Response.QueryResponseResult;
import com.common.Response.ResponseResult;
import com.common.Response.violation.violationStandard.ViolationStandardCode;
import com.common.Response.violation.violationStandard.ViolationStandardResult;
import com.module.entity.plan.Plan;
import com.common.Request.plan.PlanRequest;
import com.common.Response.plan.PlanResult;
import com.module.entity.violation.violationStandard.ViolationStandard;
import com.module.service.plan.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * 计划Controller
 * Created by huangbotao on 2020/8/27;
 */
@RestController
@RequestMapping("/plan")
public class PlanController implements PlanControllerApi {

    @Autowired
    private PlanService planService;

    /**
     * 分页同时自定义查询
     * @param page
     * @param size
     * @param planRequest
     * @return
     */
    @Override
    @GetMapping("/list/{page}/{size}")
    public QueryResponseResult findList(@PathVariable("page") int page, @PathVariable("size")int size, PlanRequest planRequest) {

        return planService.findList(page,size, planRequest);
    }


    /**
     * 添加计划
     * @param plan
     * @return
     */
    @Override
    @PostMapping("/add")
    public PlanResult add(@RequestBody Plan plan) {

        return planService.add(plan);
    }

    /**
     * 通过id查询计划
     * @param id
     * @return
     */
    @Override
    @GetMapping("/get/{id}")
    public PlanResult findById(@PathVariable("id") String id) {

        return planService.findById(id);
    }

    /**
     * 通过id修改计划
     * @param id
     * @param plan
     * @return
     */
    @Override
    @PutMapping("/edit/{id}")//这里使用put方法，http 方法中put表示更新
    public PlanResult edit(@PathVariable("id") String id, @RequestBody Plan plan) {

        return planService.edit(id,plan);
    }

    /**
     * 通过id删除计划
     * @param id
     * @return
     */
    @Override
    @DeleteMapping("/del/{id}") //使用http的delete方法完成删除操作
    public ResponseResult delete(@PathVariable("id") String id) {

        return planService.delete(id);
    }

    /**
     * 通过id修改计划状态
     * @param id
     * @param status
     * @return
     */
    @Override
    @PutMapping(value="/editStatus/{id}/{status}")
    public PlanResult editStatus(@PathVariable("id") String id, @PathVariable("status") Integer status) {

        return planService.editStatus(id,status);
    }
}