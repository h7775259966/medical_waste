package com.module.dao.hospital.hospital;

import com.common.CrudDao.CrudDao;
import com.module.entity.hospital.hospital.Hospital;
import com.common.Request.hospital.hospital.HospitalRequest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * 医院DAO接口
 * @author zx
 * @version 2020-08-24
 */
@Mapper
public interface HospitalDao extends CrudDao<Hospital>{

    /**
     * 通过查询条件查询所有数据
     * @param hospitalRequest
     * @return
     */
    public List<Hospital> findListByRequest(HospitalRequest hospitalRequest);

}