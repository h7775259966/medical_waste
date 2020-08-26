package com.module.dao.collect;

import com.common.CrudDao.CrudDao;
import com.module.entity.collect.Collect;
import org.apache.ibatis.annotations.Mapper;


/**
 * 收集人DAO接口
 * @author zx
 * @version 2020-08-24
 */
@Mapper
public interface CollectDao extends CrudDao<Collect>{

}