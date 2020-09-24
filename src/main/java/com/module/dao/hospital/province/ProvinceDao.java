package com.module.dao.hospital.province;

import com.common.CrudDao.CrudDao;
import com.module.entity.hospital.province.Province;
import com.common.Request.hospital.province.ProvinceRequest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * 省级单位DAO接口
 * @author zx
 * @version 2020-08-24
 */
@Mapper
public interface ProvinceDao extends CrudDao<Province>{

    /**
     * 通过查询条件查询所有数据
     * @param provinceRequest
     * @return
     */
    public List<Province> findListByRequest(ProvinceRequest provinceRequest);

}