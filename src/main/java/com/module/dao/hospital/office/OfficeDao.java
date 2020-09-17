package com.module.dao.hospital.office;

import com.common.CrudDao.CrudDao;
import com.module.entity.hospital.office.Office;
import com.module.request.hospital.office.OfficeRequest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * 医院科室DAO接口
 * @author zx
 * @version 2020-08-26
 */
@Mapper
public interface OfficeDao extends CrudDao<Office>{

    /**
     * 通过查询条件查询所有数据
     * @param officeRequest
     * @returno
     */
    public List<Office> findListByRequest(OfficeRequest officeRequest);
}