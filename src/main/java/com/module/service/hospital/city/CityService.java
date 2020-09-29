package com.module.service.hospital.city;

import com.common.Response.CommonCode;
import com.common.Response.QueryResponseResult;
import com.common.Response.QueryResult;
import com.common.Response.ResponseResult;
import com.common.Utils.CryptoUtil;
import com.common.Utils.IdGen;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.common.Exception.ExceptionCast;
import com.module.dao.hospital.city.CityDao;
import com.module.entity.hospital.city.City;
import com.common.Request.hospital.city.CityRequest;
import com.common.Response.hospital.city.CityCode;
import com.common.Response.hospital.city.CityResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 市级单位Service
 * @author zx
 * @version 2020-08-24
 */
@Service
@Transactional(readOnly = true)
public class CityService {

	@Autowired
	private CityDao cityDao;


    public QueryResponseResult findList(int page, int size, CityRequest cityRequest) {
        //为防止后面报空指针，先进行查询条件的非空判断
        if (cityRequest == null) {
            cityRequest = new CityRequest();
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
        List<City> list = cityDao.findListByRequest(cityRequest);
        PageInfo<City> pageInfo = new PageInfo<City>(list);
        QueryResult queryResult = new QueryResult();
        queryResult.setList(list);//数据列表
        queryResult.setTotal(pageInfo.getTotal());//数据总记录数
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS, queryResult);
        return queryResponseResult;

    }

    /**
     * 查询所有市级单位
     * @return
     */
    public QueryResponseResult all() {
        List<City> list = cityDao.findList();
        PageInfo<City> pageInfo = new PageInfo<City>(list);
        QueryResult queryResult = new QueryResult();
        queryResult.setList(list);//数据列表
        queryResult.setTotal(pageInfo.getTotal());//数据总记录数
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS, queryResult);
        return queryResponseResult;
    }

    /**
     * 添加市级单位
     * @param city
     * @return
     */
    @Transactional
    public CityResult add(City city) {
        if (cityDao.getByName(city.getCityName()) == null) {
            City one = new City();
            one.setCityId(IdGen.uuid());
            one.setCityName(city.getCityName());
            one.setCityNumber(city.getCityNumber());
            one.setProvinceId(city.getProvinceId());
            one.setArea(city.getArea());
            one.setPrincipal(city.getPrincipal());
            one.setGrade("2");//等级 1为省,2为市,3为区县
            one.setLatitude(city.getLatitude());
            one.setLongitude(city.getLongitude());
            one.setRemarks(city.getRemarks());
            one.setCreateDate(new Date());
            int insert = cityDao.insert(one);
            if (insert > 0) {
                //返回成功
                return new CityResult(CommonCode.SUCCESS, one);
            } else {
                //自定义异常处理
                ExceptionCast.cast(CityCode.CMS_INSERT_FALSE);
            }
        }
        //返回失败
        return new CityResult(CityCode.CMS_NAME_REPETITION, null);
    }

    /**
     * 通过ID查询市级单位
     * @param id
     * @return
     */
    public CityResult findById(String id) {
        if (cityDao.get(id) != null) {
            City city = cityDao.get(id);
            //返回成功
            return new CityResult(CommonCode.SUCCESS, city);
        }
        //返回失败
        return new CityResult(CityCode.CMS_GET_ISNULL, null);
    }

	/**
	 * 通过id修改市级单位
	 * @param id
	 * @return
	 */
    @Transactional
	public CityResult edit(String id, City city) {
        if (cityDao.get(id) != null) {
            City one = cityDao.get(id);
            one.setCityName(city.getCityName());
            one.setCityNumber(city.getCityNumber());
            one.setProvinceId(city.getProvinceId());
            one.setArea(city.getArea());
            one.setPrincipal(city.getPrincipal());
            //one.setGrade(city.getGrade());等级默认无法修改
            one.setLatitude(city.getLatitude());
            one.setLongitude(city.getLongitude());
            one.setRemarks(city.getRemarks());
            int update = cityDao.update(one);
            if (update > 0) {
                //返回成功
                return new CityResult(CommonCode.SUCCESS, one);
            } else {
                //自定义异常处理
                ExceptionCast.cast(CityCode.CMS_UPDATE_FALSE);
            }
        }
        //返回失败
        return new CityResult(CityCode.CMS_GET_ISNULL, null);
	}

	/**
	 * 通过id删除市级单位
	 * @param id
	 * @return
	 */
    @Transactional
	public ResponseResult delete(String id) {
        if (cityDao.get(id) != null) {
            int delete = cityDao.delete(id);
            if (delete > 0) {
                //返回成功
                return new ResponseResult(CommonCode.SUCCESS);
            } else {
                //自定义异常处理
                ExceptionCast.cast(CityCode.CMS_DELETE_FALSE);
            }
        }
        //返回失败
        return new CityResult(CityCode.CMS_GET_ISNULL, null);
	}

    /**
     * 通过省级id查询所属市级
     * @return
     */
    public QueryResponseResult findByProvinceId(String provinceId) {
        List<City> list = cityDao.findByProvinceId(provinceId);
        PageInfo<City> pageInfo = new PageInfo<City>(list);
        QueryResult queryResult = new QueryResult();
        queryResult.setList(list);//数据列表
        queryResult.setTotal(pageInfo.getTotal());//数据总记录数
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS, queryResult);
        return queryResponseResult;
    }
}