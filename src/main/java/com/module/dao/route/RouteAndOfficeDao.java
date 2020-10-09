package com.module.dao.route;

import com.common.CrudDao.CrudDao;
import com.module.entity.route.RouteAndOffice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by huangbotao on 2020/9/30;
 */
@Mapper
public interface RouteAndOfficeDao extends CrudDao<RouteAndOffice> {


    /**
     *
     * @param routeId
     * @return
     * 根据officeId查询所有数据
     */
    public List<RouteAndOffice> getByRouteId(String routeId);

    /**
     *
     * @param routeId
     * @return
     * 根据OFFICEid删除所有数据
     */
    public int deleteByRouteId(String routeId);

}
