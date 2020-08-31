package com.module.dao.collect;

import com.common.CrudDao.CrudDao;
import com.module.entity.collect.Collect;
import com.module.request.collect.CollectRequest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * 收集人DAO接口
 * @author zx
 * @version 2020-08-24
 */
@Mapper
public interface CollectDao extends CrudDao<Collect>{

    /**
     * 通过查询条件查询所有数据
     * @param collectRequest
     * @return
     */
    public List<Collect> findListByRequest(CollectRequest collectRequest);
}