package com.module.dao.office;

import com.common.CrudDao.CrudDao;
import com.module.entity.office.Office;
import org.apache.ibatis.annotations.Mapper;


/**
 * 医院科室DAO接口
 * @author zx
 * @version 2020-08-26
 */
@Mapper
public interface OfficeDao extends CrudDao<Office>{

}