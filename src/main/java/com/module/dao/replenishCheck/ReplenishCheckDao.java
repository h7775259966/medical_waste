package com.module.dao.replenishCheck;

import com.common.CrudDao.CrudDao;
import com.module.entity.replenish.Replenish;
import com.module.entity.replenishCheck.ReplenishCheck;
import org.apache.ibatis.annotations.Mapper;


/**
 * 医废补录审核DAO接口
 * @author zx
 * @version 2020-08-24
 */
@Mapper
public interface ReplenishCheckDao extends CrudDao<ReplenishCheck>{

}