package com.module.controller.manage;

import com.common.CrudDao.ExcelData;
import com.common.Response.QueryResponseResult;
import com.common.Utils.ExportExcelUtils;
import com.module.dao.custom.CustomDao;
import com.module.entity.trash.trashCollect.TrashCollect;
import com.common.Request.custom.CustomRequest;
import com.module.service.custom.CustomService;
import com.module.service.manage.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * 重量统计导出Excel
 * Created by huangbotao on 2020/9/21;
 */

@RestController
@RequestMapping("/weight")
public class WeightExcelController {

    @Autowired
    private ManageService manageService;

    @RequestMapping(value = "/excel", method = RequestMethod.GET)
    public void excel(HttpServletResponse response) throws Exception {


        List<TrashCollect> info =  manageService.findExcel();
        ExcelData data = new ExcelData();
        data.setName("hello");
        List<String> titles = new ArrayList();
        titles.add("物品重量");
        titles.add("医废包数");
        data.setTitles(titles);

        List<List<Object>> rows = new ArrayList();
        for (int i = 0; i < info.size(); i++) {//遍历数组，把数组内容放进Excel的行中
            List<Object> row = new ArrayList();
            row.add(info.get(i).getViolationWeight());
            row.add(info.get(i).getPackets());
//            row.add(info.get(i).getGender());
//            row.add(info.get(i).getAge());
            rows.add(i, row);
        }

        data.setRows(rows);


        //生成本地
        /*File f = new File("c:/test.xlsx");
        FileOutputStream out = new FileOutputStream(f);
        ExportExcelUtils.exportExcel(data, out);
        out.close();*/
        ExportExcelUtils.exportExcel(response, "hello.xlsx", data);
    }
}
