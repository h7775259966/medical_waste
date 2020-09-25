package com.module.dao.hospital.zone;

import com.common.CrudDao.CrudDao;
import com.module.entity.hospital.city.City;
import com.module.entity.hospital.zone.Zone;
import com.common.Request.hospital.zone.ZoneRequest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * 区县级单位DAO接口
 * @author zx
 * @version 2020-08-24
 */
@Mapper
public interface ZoneDao extends CrudDao<Zone>{

    /**
     * 通过查询条件查询所有数据
     * @param zoneRequest
     * @return
     */
    public List<Zone> findListByRequest(ZoneRequest zoneRequest);

    /**
     * 通过市级id查询所属区县级
     * @param CityId
     * @returno
     */
    public List<Zone> findByCityId(String CityId);
}