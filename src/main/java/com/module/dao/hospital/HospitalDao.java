package com.module.dao.hospital;

import com.common.CrudDao.CrudDao;
import com.module.entity.hospital.Hospital;
import org.apache.ibatis.annotations.Mapper;


/**
 * 医院DAO接口
 * @author zx
 * @version 2020-08-24
 */
@Mapper
public interface HospitalDao extends CrudDao<Hospital>{

}