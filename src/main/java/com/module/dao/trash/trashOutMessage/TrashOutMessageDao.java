package com.module.dao.trash.trashOutMessage;

import com.common.CrudDao.CrudDao;
import com.common.Request.trash.trashOutMessage.TrashOutMessageRequest;
import com.module.entity.trash.trashOutMessage.TrashOutMessage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * Created zx on 2020/10/12;
 */
@Mapper
public interface TrashOutMessageDao extends CrudDao<TrashOutMessage> {

    /**
     * 通过查询条件查询所有数据
     * @param trashOutMessageRequest
     * @returno
     */
    public List<TrashOutMessage> findListByRequest(TrashOutMessageRequest trashOutMessageRequest);
}
