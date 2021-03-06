package com.module.service.manage;

import com.module.dao.manage.ManageDao;
import com.module.entity.trash.trashCollect.TrashCollect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 导出报表EXCEL
 *
 * Created by huangbotao on 2020/9/22;
 */

@Service
@Transactional(readOnly = true)
public class ManageService {

    @Autowired
    private ManageDao manageDao;

    @Transactional
    public List<TrashCollect> findExcel() {
         return   manageDao.findExcel();
    }
}
