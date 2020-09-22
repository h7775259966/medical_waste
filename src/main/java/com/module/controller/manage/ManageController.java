package com.module.controller.manage;

import com.module.entity.trash.trashCollect.TrashCollect;
import com.module.service.manage.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 导出医废重量Excel的查询语句
 * Created by huangbotao on 2020/9/21;
 */
@RestController
@RequestMapping("/manage")
public class ManageController implements ManageControllerApi {

    @Autowired
    private ManageService manageService;

    /**
     导出重量Excel
     */

    @Override
    @GetMapping("/find/weight")
    public List<TrashCollect> findExcel(Map<String, Object> map) {

        List<TrashCollect> list = manageService.findExcel();
        map.put("trashCollect", list);
        return list;
    }

}
