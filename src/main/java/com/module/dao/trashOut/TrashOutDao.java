package com.module.dao.trashOut;

import com.common.CrudDao.CrudDao;
import com.module.entity.trashOut.TrashOut;
import com.module.request.trashOut.TrashOutRequest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by huangbotao on 2020/8/31;
 */
@Mapper
public interface TrashOutDao extends CrudDao<TrashOut> {

    List<TrashOut> search(TrashOutRequest trashOutRequest);
}
