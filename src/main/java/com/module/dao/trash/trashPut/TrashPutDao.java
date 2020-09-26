package com.module.dao.trash.trashPut;

import com.common.CrudDao.CrudDao;
import com.common.Request.collect.CollectRequest;
import com.common.Request.trash.trashPut.TrashPutRequest;
import com.module.entity.collect.Collect;
import com.module.entity.trash.trashPut.TrashPut;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by huangbotao on 2020/8/31;
 */
@Mapper
public interface TrashPutDao extends CrudDao<TrashPut> {


    public List<TrashPut> findListByRequest(TrashPutRequest trashPutRequest);
}
