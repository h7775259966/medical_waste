package com.module.dao.trash.trashOut;

import com.common.CrudDao.CrudDao;
import com.module.entity.trash.trashOut.TrashOut;
import com.module.request.trash.trashOut.TrashOutRequest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by huangbotao on 2020/8/31;
 */
@Mapper
public interface TrashOutDao extends CrudDao<TrashOut> {

    List<TrashOut> search(TrashOutRequest trashOutRequest);
}
