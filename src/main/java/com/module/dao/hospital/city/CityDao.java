package com.module.dao.hospital.city;

import com.common.CrudDao.CrudDao;
import com.module.entity.hospital.city.City;
import com.module.request.hospital.city.CityRequest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * 市级单位DAO接口
 * @author zx
 * @version 2020-08-24
 */
@Mapper
public interface CityDao extends CrudDao<City>{

    /**
     * 通过查询条件查询所有数据
     * @param cityRequest
     * @return
     */
    public List<City> findListByRequest(CityRequest cityRequest);

}