package com.module.service.warn.warnDamaged;

import com.common.Response.CommonCode;
import com.common.Response.QueryResponseResult;
import com.common.Response.QueryResult;
import com.common.Response.ResponseResult;
import com.common.Utils.IdGen;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.module.config.exception.ExceptionCast;
import com.module.dao.warn.warnDamaged.WarnDamagedDao;
import com.module.entity.warn.warnDamaged.WarnDamaged;
import com.module.request.warn.warnDamaged.WarnDamagedRequest;
import com.module.response.warn.warnDamaged.WarnDamagedCode;
import com.module.response.warn.warnDamaged.WarnDamagedResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 破损预警Service
 * @author zx
 * @version 2020-08-24
 */
@Service
@Transactional(readOnly = true)
public class WarnDamagedService {

	@Autowired
	private WarnDamagedDao warnDamagedDao;

    public QueryResponseResult findList(int page, int size, WarnDamagedRequest warnDamagedRequest) {
        //为防止后面报空指针，先进行查询条件的非空判断
        if (warnDamagedRequest == null) {
            warnDamagedRequest = new WarnDamagedRequest();
        }
        //分页参数处理
        if (page <= 0) {
            page = 1;
        }
        page = page - 1;
        if (size <= 0) {
            size = 10;
        }
        //分页处理
        PageHelper.startPage(page,size);
        //注意：如果warnDamagedRequest内参数不为空，则进行带值查询
        //warnDamagedDao.findList()为没有任何查询条件的分页查询
        List<WarnDamaged> list = warnDamagedDao.findList();
        PageInfo<WarnDamaged> pageInfo = new PageInfo<WarnDamaged>(list);
        QueryResult queryResult = new QueryResult();
        queryResult.setList(list);//数据列表
        queryResult.setTotal(pageInfo.getTotal());//数据总记录数
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS, queryResult);
        return queryResponseResult;

    }

    /**
     * 添加破损预警
     * @param warnDamaged
     * @return
     */
    @Transactional
    public WarnDamagedResult add(WarnDamaged warnDamaged) {
            WarnDamaged one = new WarnDamaged();
            one.setWarnDamagedId(IdGen.uuid());
            one.setDepartmentId(warnDamaged.getDepartmentId());
            one.setOfficeId(warnDamaged.getOfficeId());
            one.setStatus(warnDamaged.getStatus());
            one.setCode(warnDamaged.getCode());
            one.setCollectId(warnDamaged.getCollectId());
            one.setCollectNumber(warnDamaged.getCollectNumber());
            one.setTrashId(warnDamaged.getTrashId());
            one.setWeight(warnDamaged.getWeight());
            one.setWarnTime(warnDamaged.getWarnTime());
            one.setCollectTime(warnDamaged.getCollectTime());
            one.setPutInTime(warnDamaged.getPutInTime());
            one.setRemarks(warnDamaged.getRemarks());
            one.setCreateDate(new Date());
            int insert = warnDamagedDao.insert(one);
            if (insert > 0) {
                //返回成功
                return new WarnDamagedResult(CommonCode.SUCCESS, one);
            } else {
                //自定义异常处理
                ExceptionCast.cast(WarnDamagedCode.CMS_INSERT_FALSE);
            }
        //返回失败
        return new WarnDamagedResult(WarnDamagedCode.CMS_INSERT_FALSE, null);
    }

    /**
     * 通过ID查询破损预警
     * @param id
     * @return
     */
    public WarnDamagedResult findById(String id) {
        if (warnDamagedDao.get(id) != null) {
            WarnDamaged warnDamaged = warnDamagedDao.get(id);
            //返回成功
            return new WarnDamagedResult(CommonCode.SUCCESS, warnDamaged);
        }
        //返回失败
        return new WarnDamagedResult(WarnDamagedCode.CMS_GET_ISNULL, null);
    }

	/**
	 * 通过id修改破损预警
	 * @param id
	 * @return
	 */
    @Transactional
	public WarnDamagedResult edit(String id, WarnDamaged warnDamaged) {
        if (warnDamagedDao.get(id) != null) {
            WarnDamaged one = warnDamagedDao.get(id);
            one.setDepartmentId(warnDamaged.getDepartmentId());
            one.setOfficeId(warnDamaged.getOfficeId());
            one.setStatus(warnDamaged.getStatus());
            one.setCode(warnDamaged.getCode());
            one.setCollectId(warnDamaged.getCollectId());
            one.setCollectNumber(warnDamaged.getCollectNumber());
            one.setTrashId(warnDamaged.getTrashId());
            one.setWeight(warnDamaged.getWeight());
            one.setWarnTime(warnDamaged.getWarnTime());
            one.setCollectTime(warnDamaged.getCollectTime());
            one.setPutInTime(warnDamaged.getPutInTime());
            one.setRemarks(warnDamaged.getRemarks());
            int update = warnDamagedDao.update(one);
            if (update > 0) {
                //返回成功
                return new WarnDamagedResult(CommonCode.SUCCESS, one);
            } else {
                //自定义异常处理
                ExceptionCast.cast(WarnDamagedCode.CMS_UPDATE_FALSE);
            }
        }
        //返回失败
        return new WarnDamagedResult(WarnDamagedCode.CMS_GET_ISNULL, null);
	}

	/**
	 * 通过id删除破损预警
	 * @param id
	 * @return
	 */
    @Transactional
	public ResponseResult delete(String id) {
        if (warnDamagedDao.get(id) != null) {
            int delete = warnDamagedDao.delete(id);
            if (delete > 0) {
                //返回成功
                return new ResponseResult(CommonCode.SUCCESS);
            } else {
                //自定义异常处理
                ExceptionCast.cast(WarnDamagedCode.CMS_DELETE_FALSE);
            }
        }
        //返回失败
        return new WarnDamagedResult(WarnDamagedCode.CMS_GET_ISNULL, null);
	}

}