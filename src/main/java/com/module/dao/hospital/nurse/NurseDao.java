package com.module.dao.hospital.nurse;

import com.common.CrudDao.CrudDao;
import com.module.entity.hospital.nurse.Nurse;
import com.module.request.hospital.nurse.NurseRequest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * 医院护士DAO接口
 * @author zx
 * @version 2020-08-24
 */
@Mapper
public interface NurseDao extends CrudDao<Nurse>{

    /**
     * 通过查询条件查询所有数据
     * @param nurseRequest
     * @return
     */
    public List<Nurse> findListByRequest(NurseRequest nurseRequest);
}