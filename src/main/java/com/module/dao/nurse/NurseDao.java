package com.module.dao.nurse;

import com.common.CrudDao.CrudDao;
import com.module.entity.nurse.Nurse;
import org.apache.ibatis.annotations.Mapper;


/**
 * 医院护士DAO接口
 * @author zx
 * @version 2020-08-24
 */
@Mapper
public interface NurseDao extends CrudDao<Nurse>{

}