package com.module.dao.plan;

import com.common.CrudDao.CrudDao;
import com.module.entity.plan.Plan;
import org.apache.ibatis.annotations.Mapper;


/**
 * 计划DAO接口
 * @author hbt
 * @version 2020-08-27
 */
@Mapper
public interface PlanDao extends CrudDao<Plan>{

}