package com.module.service.hospital.zone;

import com.common.Response.CommonCode;
import com.common.Response.QueryResponseResult;
import com.common.Response.QueryResult;
import com.common.Response.ResponseResult;
import com.common.Utils.IdGen;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.module.config.exception.ExceptionCast;
import com.module.dao.hospital.zone.ZoneDao;
import com.module.entity.hospital.zone.Zone;
import com.module.request.hospital.zone.ZoneRequest;
import com.module.response.hospital.zone.ZoneCode;
import com.module.response.hospital.zone.ZoneResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 区县级单位Service
 * @author zx
 * @version 2020-08-24
 */
@Service
@Transactional(readOnly = true)
public class ZoneService {

	@Autowired
	private ZoneDao zoneDao;


    public QueryResponseResult findList(int page, int size, ZoneRequest zoneRequest) {
        //为防止后面报空指针，先进行查询条件的非空判断
        if (zoneRequest == null) {
            zoneRequest = new ZoneRequest();
        }
        //分页参数处理
        if (page <= 0) {
            page = 1;
        }
        if (size <= 0) {
            size = 10;
        }
        //分页处理
        PageHelper.startPage(page,size);
        List<Zone> list = zoneDao.findListByRequest(zoneRequest);
        PageInfo<Zone> pageInfo = new PageInfo<Zone>(list);
        QueryResult queryResult = new QueryResult();
        queryResult.setList(list);//数据列表
        queryResult.setTotal(pageInfo.getTotal());//数据总记录数
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS, queryResult);
        return queryResponseResult;

    }

    /**
     * 查询所有区县级单位
     * @return
     */
    public QueryResponseResult all() {
        List<Zone> list = zoneDao.findList();
        PageInfo<Zone> pageInfo = new PageInfo<Zone>(list);
        QueryResult queryResult = new QueryResult();
        queryResult.setList(list);//数据列表
        queryResult.setTotal(pageInfo.getTotal());//数据总记录数
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS, queryResult);
        return queryResponseResult;
    }

    /**
     * 添加区县级单位
     * @param zone
     * @return
     */
    @Transactional
    public ZoneResult add(Zone zone) {
        if (zoneDao.getByName(zone.getZoneName()) == null) {
            Zone one = new Zone();
            one.setZoneId(IdGen.uuid());
            one.setZoneName(zone.getZoneName());
            one.setZoneNumber(zone.getZoneNumber());
            one.setCityId(zone.getCityId());
            one.setArea(zone.getArea());
            one.setPrincipal(zone.getPrincipal());
            one.setGrade(zone.getGrade());
            one.setLatitude(zone.getLatitude());
            one.setLongitude(zone.getLongitude());
            one.setRemarks(zone.getRemarks());
            one.setCreateDate(new Date());
            int insert = zoneDao.insert(one);
            if (insert > 0) {
                //返回成功
                return new ZoneResult(CommonCode.SUCCESS, one);
            } else {
                //自定义异常处理
                ExceptionCast.cast(ZoneCode.CMS_INSERT_FALSE);
            }
        }
        //返回失败
        return new ZoneResult(ZoneCode.CMS_NAME_REPETITION, null);
    }

    /**
     * 通过ID查询区县级单位
     * @param id
     * @return
     */
    public ZoneResult findById(String id) {
        if (zoneDao.get(id) != null) {
            Zone zone = zoneDao.get(id);
            //返回成功
            return new ZoneResult(CommonCode.SUCCESS, zone);
        }
        //返回失败
        return new ZoneResult(ZoneCode.CMS_GET_ISNULL, null);
    }

	/**
	 * 通过id修改区县级单位
	 * @param id
	 * @return
	 */
    @Transactional
	public ZoneResult edit(String id, Zone zone) {
        if (zoneDao.get(id) != null) {
            Zone one = zoneDao.get(id);
            one.setZoneName(zone.getZoneName());
            one.setZoneNumber(zone.getZoneNumber());
            one.setCityId(zone.getCityId());
            one.setArea(zone.getArea());
            one.setPrincipal(zone.getPrincipal());
            one.setGrade(zone.getGrade());
            one.setLatitude(zone.getLatitude());
            one.setLongitude(zone.getLongitude());
            one.setRemarks(zone.getRemarks());
            int update = zoneDao.update(one);
            if (update > 0) {
                //返回成功
                return new ZoneResult(CommonCode.SUCCESS, one);
            } else {
                //自定义异常处理
                ExceptionCast.cast(ZoneCode.CMS_UPDATE_FALSE);
            }
        }
        //返回失败
        return new ZoneResult(ZoneCode.CMS_GET_ISNULL, null);
	}

	/**
	 * 通过id删除区县级单位
	 * @param id
	 * @return
	 */
    @Transactional
	public ResponseResult delete(String id) {
        if (zoneDao.get(id) != null) {
            int delete = zoneDao.delete(id);
            if (delete > 0) {
                //返回成功
                return new ResponseResult(CommonCode.SUCCESS);
            } else {
                //自定义异常处理
                ExceptionCast.cast(ZoneCode.CMS_DELETE_FALSE);
            }
        }
        //返回失败
        return new ZoneResult(ZoneCode.CMS_GET_ISNULL, null);
	}

}