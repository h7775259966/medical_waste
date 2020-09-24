package com.module.dao.trash.trashCollectHistory;

import com.common.CrudDao.CrudDao;
import com.module.entity.trash.trashCollectHistory.TrashCollectHistory;
import com.module.entity.trash.trashPut.TrashPut;
import com.common.Request.trash.trashCollectHistory.TrashCollectHistoryRequest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by huangbotao on 2020/8/31;
 */
@Mapper
public interface TrashCollectHistoryDao extends CrudDao<TrashPut> {

   public List<TrashCollectHistory> findHistory(TrashCollectHistoryRequest trashCollectHistoryRequest);

}
