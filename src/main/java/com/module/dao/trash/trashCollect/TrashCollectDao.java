package com.module.dao.trash.trashCollect;

import com.common.CrudDao.CrudDao;
import com.common.Request.trash.trashCollect.TrashCollectRequest;
import com.common.Request.trash.trashOut.TrashOutRequest;
import com.module.entity.trash.trashCollect.TrashCollect;
import com.module.entity.trash.trashOut.TrashOut;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by huangbotao on 2020/8/31;
 */
@Mapper
public interface TrashCollectDao extends CrudDao<TrashCollect> {

    public List<TrashCollect> findList(TrashCollectRequest trashCollectRequest);
}
