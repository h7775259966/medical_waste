package com.module.service.hospital.province;

import com.common.Response.CommonCode;
import com.common.Response.QueryResponseResult;
import com.common.Response.QueryResult;
import com.common.Response.ResponseResult;
import com.common.Utils.IdGen;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.common.Exception.ExceptionCast;
import com.module.dao.hospital.province.ProvinceDao;
import com.module.entity.hospital.province.Province;
import com.common.Request.hospital.province.ProvinceRequest;
import com.common.Response.hospital.province.ProvinceCode;
import com.common.Response.hospital.province.ProvinceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 省级单位Service
 * @author zx
 * @version 2020-08-24
 */
@Service
@Transactional(readOnly = true)
public class ProvinceService {

	@Autowired
	private ProvinceDao provinceDao;


    public QueryResponseResult findList(int page, int size, ProvinceRequest provinceRequest) {
        //为防止后面报空指针，先进行查询条件的非空判断
        if (provinceRequest == null) {
            provinceRequest = new ProvinceRequest();
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
        List<Province> list = provinceDao.findListByRequest(provinceRequest);
        PageInfo<Province> pageInfo = new PageInfo<Province>(list);
        QueryResult queryResult = new QueryResult();
        queryResult.setList(list);//数据列表
        queryResult.setTotal(pageInfo.getTotal());//数据总记录数
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS, queryResult);
        return queryResponseResult;

    }

    /**
     * 查询所有省级单位
     * @return
     */
    public QueryResponseResult all() {
        List<Province> list = provinceDao.findList();
        PageInfo<Province> pageInfo = new PageInfo<Province>(list);
        QueryResult queryResult = new QueryResult();
        queryResult.setList(list);//数据列表
        queryResult.setTotal(pageInfo.getTotal());//数据总记录数
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS, queryResult);
        return queryResponseResult;
    }

    /**
     * 添加省级单位
     * @param province
     * @return
     */
    @Transactional
    public ProvinceResult add(Province province) {
        if (provinceDao.getByName(province.getProvinceName()) == null) {
            Province one = new Province();
            one.setProvinceId(IdGen.uuid());
            one.setProvinceName(province.getProvinceName());
            one.setProvinceNumber(province.getProvinceNumber());
            one.setArea(province.getArea());
            one.setPrincipal(province.getPrincipal());
            one.setGrade("1");//等级 1为省,2为市,3为区县
            one.setLatitude(province.getLatitude());
            one.setLongitude(province.getLongitude());
            one.setRemarks(province.getRemarks());
            one.setCreateDate(new Date());
            int insert = provinceDao.insert(one);
            if (insert > 0) {
                //返回成功
                return new ProvinceResult(CommonCode.SUCCESS, one);
            } else {
                //自定义异常处理
                ExceptionCast.cast(ProvinceCode.CMS_INSERT_FALSE);
            }
        }
        //返回失败
        return new ProvinceResult(ProvinceCode.CMS_NAME_REPETITION, null);
    }

    /**
     * 通过ID查询省级单位
     * @param id
     * @return
     */
    public ProvinceResult findById(String id) {
        if (provinceDao.get(id) != null) {
            Province province = provinceDao.get(id);
            //返回成功
            return new ProvinceResult(CommonCode.SUCCESS, province);
        }
        //返回失败
        return new ProvinceResult(ProvinceCode.CMS_GET_ISNULL, null);
    }

	/**
	 * 通过id修改省级单位
	 * @param id
	 * @return
	 */
    @Transactional
	public ProvinceResult edit(String id, Province province) {
        if (provinceDao.get(id) != null) {
            Province one = provinceDao.get(id);
            one.setProvinceName(province.getProvinceName());
            one.setProvinceNumber(province.getProvinceNumber());
            one.setArea(province.getArea());
            one.setPrincipal(province.getPrincipal());
            //one.setGrade(province.getGrade());默认等级无法修改
            one.setLatitude(province.getLatitude());
            one.setLongitude(province.getLongitude());
            one.setRemarks(province.getRemarks());
            int update = provinceDao.update(one);
            if (update > 0) {
                //返回成功
                return new ProvinceResult(CommonCode.SUCCESS, one);
            } else {
                //自定义异常处理
                ExceptionCast.cast(ProvinceCode.CMS_UPDATE_FALSE);
            }
        }
        //返回失败
        return new ProvinceResult(ProvinceCode.CMS_GET_ISNULL, null);
	}

	/**
	 * 通过id删除省级单位
	 * @param id
	 * @return
	 */
    @Transactional
	public ResponseResult delete(String id) {
        if (provinceDao.get(id) != null) {
            int delete = provinceDao.delete(id);
            if (delete > 0) {
                //返回成功
                return new ResponseResult(CommonCode.SUCCESS);
            } else {
                //自定义异常处理
                ExceptionCast.cast(ProvinceCode.CMS_DELETE_FALSE);
            }
        }
        //返回失败
        return new ProvinceResult(ProvinceCode.CMS_GET_ISNULL, null);
	}

}