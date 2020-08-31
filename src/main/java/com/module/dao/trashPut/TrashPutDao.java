package com.module.dao.trashPut;

import com.common.CrudDao.CrudDao;
import com.module.entity.trashCollect.TrashCollect;
import com.module.entity.trashPut.TrashPut;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by huangbotao on 2020/8/31;
 */
@Mapper
public interface TrashPutDao extends CrudDao<TrashPut> {

}
