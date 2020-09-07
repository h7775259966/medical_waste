package com.module.service.warn.warnInWeight;

import com.common.Response.CommonCode;
import com.common.Response.QueryResponseResult;
import com.common.Response.QueryResult;
import com.common.Response.ResponseResult;
import com.common.Utils.IdGen;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.module.config.exception.ExceptionCast;
import com.module.dao.warn.warnInWeight.WarnInWeightDao;
import com.module.entity.warn.warnInWeight.WarnInWeight;
import com.module.request.warn.warnInWeight.WarnInWeightRequest;
import com.module.response.warn.warnInWeight.WarnInWeightCode;
import com.module.response.warn.warnInWeight.WarnInWeightResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 入库重量预警Service
 * @author zx
 * @version 2020-08-24
 */
@Service
@Transactional(readOnly = true)
public class WarnInWeightService {

	@Autowired
	private WarnInWeightDao warnInWeightDao;

    public QueryResponseResult findList(int page, int size, WarnInWeightRequest warnInWeightRequest) {
        //为防止后面报空指针，先进行查询条件的非空判断
        if (warnInWeightRequest == null) {
            warnInWeightRequest = new WarnInWeightRequest();
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
        List<WarnInWeight> list = warnInWeightDao.findList();
        PageInfo<WarnInWeight> pageInfo = new PageInfo<WarnInWeight>(list);
        QueryResult queryResult = new QueryResult();
        queryResult.setList(list);//数据列表
        queryResult.setTotal(pageInfo.getTotal());//数据总记录数
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS, queryResult);
        return queryResponseResult;

    }

    /**
     * 添加入库重量预警
     * @param warnInWeight
     * @return
     */
    @Transactional
    public WarnInWeightResult add(WarnInWeight warnInWeight) {
            WarnInWeight one = new WarnInWeight();
            one.setWarnInWeightId(IdGen.uuid());
            one.setDepartmentId(warnInWeight.getDepartmentId());
            one.setOfficeId(warnInWeight.getOfficeId());
            one.setCode(warnInWeight.getCode());
            one.setCollectId(warnInWeight.getCollectId());
            one.setCollectWeight(warnInWeight.getCollectWeight());
            one.setInWeight(warnInWeight.getInWeight());
            one.setInPerson(warnInWeight.getInPerson());
            one.setTrashId(warnInWeight.getTrashId());
            one.setInTime(warnInWeight.getInTime());
            one.setWarnTime(warnInWeight.getWarnTime());
            one.setRemarks(warnInWeight.getRemarks());
            one.setCreateDate(new Date());
            int insert = warnInWeightDao.insert(one);
            if (insert > 0) {
                //返回成功
                return new WarnInWeightResult(CommonCode.SUCCESS, one);
            } else {
                //自定义异常处理
                ExceptionCast.cast(WarnInWeightCode.CMS_INSERT_FALSE);
            }
        //返回失败
        return new WarnInWeightResult(WarnInWeightCode.CMS_INSERT_FALSE, null);
    }

    /**
     * 通过ID查询入库重量预警
     * @param id
     * @return
     */
    public WarnInWeightResult findById(String id) {
        if (warnInWeightDao.get(id) != null) {
            WarnInWeight warnInWeight = warnInWeightDao.get(id);
            //返回成功
            return new WarnInWeightResult(CommonCode.SUCCESS, warnInWeight);
        }
        //返回失败
        return new WarnInWeightResult(WarnInWeightCode.CMS_GET_ISNULL, null);
    }

	/**
	 * 通过id修改入库重量预警
	 * @param id
	 * @return
	 */
    @Transactional
	public WarnInWeightResult edit(String id, WarnInWeight warnInWeight) {
        if (warnInWeightDao.get(id) != null) {
            WarnInWeight one = warnInWeightDao.get(id);
            one.setDepartmentId(warnInWeight.getDepartmentId());
            one.setOfficeId(warnInWeight.getOfficeId());
            one.setCode(warnInWeight.getCode());
            one.setCollectId(warnInWeight.getCollectId());
            one.setCollectWeight(warnInWeight.getCollectWeight());
            one.setInWeight(warnInWeight.getInWeight());
            one.setInPerson(warnInWeight.getInPerson());
            one.setTrashId(warnInWeight.getTrashId());
            one.setInTime(warnInWeight.getInTime());
            one.setWarnTime(warnInWeight.getWarnTime());
            one.setRemarks(warnInWeight.getRemarks());
            int update = warnInWeightDao.update(one);
            if (update > 0) {
                //返回成功
                return new WarnInWeightResult(CommonCode.SUCCESS, one);
            } else {
                //自定义异常处理
                ExceptionCast.cast(WarnInWeightCode.CMS_UPDATE_FALSE);
            }
        }
        //返回失败
        return new WarnInWeightResult(WarnInWeightCode.CMS_GET_ISNULL, null);
	}

	/**
	 * 通过id删除入库重量预警
	 * @param id
	 * @return
	 */
    @Transactional
	public ResponseResult delete(String id) {
        if (warnInWeightDao.get(id) != null) {
            int delete = warnInWeightDao.delete(id);
            if (delete > 0) {
                //返回成功
                return new ResponseResult(CommonCode.SUCCESS);
            } else {
                //自定义异常处理
                ExceptionCast.cast(WarnInWeightCode.CMS_DELETE_FALSE);
            }
        }
        //返回失败
        return new WarnInWeightResult(WarnInWeightCode.CMS_GET_ISNULL, null);
	}

}