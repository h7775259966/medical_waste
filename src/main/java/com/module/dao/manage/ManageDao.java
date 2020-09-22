package com.module.dao.manage;

import com.common.CrudDao.CrudDao;
import com.module.entity.trash.trashCollect.TrashCollect;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 *
 * 导出EXCEL  dao层
 * Created by huangbotao on 2020/9/22;
 */

@Mapper
public interface ManageDao  extends CrudDao<TrashCollect> {


    List<TrashCollect> findExcel();
}
