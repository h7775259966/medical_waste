package com.module.service.warn;

import com.common.Response.CommonCode;
import com.common.Response.QueryResponseResult;
import com.common.Response.QueryResult;
import com.common.Response.ResponseResult;
import com.common.Utils.IdGen;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.common.Exception.ExceptionCast;
import com.module.dao.warn.WarnLeakageDao;
import com.module.entity.warn.WarnLeakage;
import com.common.Request.warn.WarnLeakageRequest;
import com.common.Response.warn.WarnLeakageCode;
import com.common.Response.warn.WarnLeakageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 泄漏预警Service
 * @author zx
 * @version 2020-08-24
 */
@Service
@Transactional(readOnly = true)
public class WarnLeakageService {

	@Autowired
	private WarnLeakageDao warnLeakageDao;

    public QueryResponseResult findList(int page, int size, WarnLeakageRequest warnLeakageRequest) {
        //为防止后面报空指针，先进行查询条件的非空判断
        if (warnLeakageRequest == null) {
            warnLeakageRequest = new WarnLeakageRequest();
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
        //注意：如果warnLeakageRequest内参数不为空，则进行带值查询
        //warnLeakageDao.findList()为没有任何查询条件的分页查询
        List<WarnLeakage> list = warnLeakageDao.findList();
        PageInfo<WarnLeakage> pageInfo = new PageInfo<WarnLeakage>(list);
        QueryResult queryResult = new QueryResult();
        queryResult.setList(list);//数据列表
        queryResult.setTotal(pageInfo.getTotal());//数据总记录数
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS, queryResult);
        return queryResponseResult;

    }

    /**
     * 添加泄漏预警
     * @param warnLeakage
     * @return
     */
    @Transactional
    public WarnLeakageResult add(WarnLeakage warnLeakage) {
            WarnLeakage one = new WarnLeakage();
            one.setWarnLeakageId(IdGen.uuid());
            one.setTrashCollectId(warnLeakage.getTrashCollectId());
            one.setStatus(warnLeakage.getStatus());
            one.setWarnTime(warnLeakage.getWarnTime());
            one.setRemarks(warnLeakage.getRemarks());
            one.setCreateDate(new Date());
            int insert = warnLeakageDao.insert(one);
            if (insert > 0) {
                //返回成功
                return new WarnLeakageResult(CommonCode.SUCCESS, one);
            } else {
                //自定义异常处理
                ExceptionCast.cast(WarnLeakageCode.CMS_INSERT_FALSE);
            }
        //返回失败
        return new WarnLeakageResult(WarnLeakageCode.CMS_INSERT_FALSE, null);
    }

    /**
     * 通过ID查询泄漏预警
     * @param id
     * @return
     */
    public WarnLeakageResult findById(String id) {
        if (warnLeakageDao.get(id) != null) {
            WarnLeakage warnLeakage = warnLeakageDao.get(id);
            //返回成功
            return new WarnLeakageResult(CommonCode.SUCCESS, warnLeakage);
        }
        //返回失败
        return new WarnLeakageResult(WarnLeakageCode.CMS_GET_ISNULL, null);
    }

	/**
	 * 通过id修改泄漏预警
	 * @param id
	 * @return
	 */
    @Transactional
	public WarnLeakageResult edit(String id, WarnLeakage warnLeakage) {
        if (warnLeakageDao.get(id) != null) {
            WarnLeakage one = warnLeakageDao.get(id);
            one.setTrashCollectId(warnLeakage.getTrashCollectId());
            one.setStatus(warnLeakage.getStatus());
            one.setWarnTime(warnLeakage.getWarnTime());
            one.setRemarks(warnLeakage.getRemarks());
            int update = warnLeakageDao.update(one);
            if (update > 0) {
                //返回成功
                return new WarnLeakageResult(CommonCode.SUCCESS, one);
            } else {
                //自定义异常处理
                ExceptionCast.cast(WarnLeakageCode.CMS_UPDATE_FALSE);
            }
        }
        //返回失败
        return new WarnLeakageResult(WarnLeakageCode.CMS_GET_ISNULL, null);
	}

	/**
	 * 通过id删除泄漏预警
	 * @param id
	 * @return
	 */
    @Transactional
	public ResponseResult delete(String id) {
        if (warnLeakageDao.get(id) != null) {
            int delete = warnLeakageDao.delete(id);
            if (delete > 0) {
                //返回成功
                return new ResponseResult(CommonCode.SUCCESS);
            } else {
                //自定义异常处理
                ExceptionCast.cast(WarnLeakageCode.CMS_DELETE_FALSE);
            }
        }
        //返回失败
        return new WarnLeakageResult(WarnLeakageCode.CMS_GET_ISNULL, null);
	}

}