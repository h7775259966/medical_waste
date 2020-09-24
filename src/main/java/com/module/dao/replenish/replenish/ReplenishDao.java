package com.module.dao.replenish.replenish;

import com.common.CrudDao.CrudDao;
import com.module.entity.replenish.replenish.Replenish;
import org.apache.ibatis.annotations.Mapper;


/**
 * 医废补录DAO接口
 * @author zx
 * @version 2020-08-24
 */
@Mapper
public interface ReplenishDao extends CrudDao<Replenish>{

}