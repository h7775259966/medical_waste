package com.module.controller.equipment;

import com.common.Response.QueryResponseResult;
import com.common.Response.ResponseResult;
import com.module.entity.equipment.Equipment;
import com.module.request.equipment.EquipmentRequest;
import com.module.response.equipment.EquipmentResult;
import com.module.service.equipment.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



/**
 * 设备Controller
 * @author hbt
 * @version 2020-09-03
 */


@RestController
@RequestMapping("/equipment")
public class EquipmentController implements EquipmentControllerApi {

    @Autowired
    private EquipmentService equipmentService;


    /**
     * 分页同时自定义查询
     * @param page
     * @param size
     * @param equipmentRequest
     * @return
     */
    @Override
    @GetMapping("/list/{page}/{size}")
    public QueryResponseResult findList(@PathVariable("page") int page, @PathVariable("size")int size, EquipmentRequest equipmentRequest) {

        return equipmentService.findList(page,size, equipmentRequest);
    }

    /**
     * 通过id查询设备
     * @param id
     * @return
     */
    @Override
    @GetMapping("/get/{id}")
    public EquipmentResult findById(@PathVariable("id") String id) {

        return equipmentService.findById(id);
    }



    /**
     * 添加设备
     * @param equipment
     * @return
     */
    @Override
    @PostMapping("/add")
    public EquipmentResult add(@RequestBody Equipment equipment) {

        return equipmentService.add(equipment);
    }

    /**
     * 通过id修改设备
     * @param id
     * @param equipment
     * @return
     */
    @Override
    @PutMapping("/edit/{id}")//这里使用put方法，http 方法中put表示更新
    public EquipmentResult edit(@PathVariable("id") String id, @RequestBody Equipment equipment) {

        return equipmentService.edit(id,equipment);
    }

    /**
     * 通过id删除设备
     * @param id
     * @return
     */
    @Override
    @DeleteMapping("/del/{id}") //使用http的delete方法完成删除操作
    public ResponseResult delete(@PathVariable("id") String id) {

        return equipmentService.delete(id);
    }
}
