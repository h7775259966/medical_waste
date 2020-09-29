package com.module.service.warn.warnOutWeight;

import com.common.Response.CommonCode;
import com.common.Response.QueryResponseResult;
import com.common.Response.QueryResult;
import com.common.Response.ResponseResult;
import com.common.Utils.IdGen;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.common.Exception.ExceptionCast;
import com.module.dao.warn.warnOutWeight.WarnOutWeightDao;
import com.module.entity.warn.WarnOutWeight;
import com.common.Request.warn.warnOutWeight.WarnOutWeightRequest;
import com.common.Response.warn.warnOutWeight.WarnOutWeightCode;
import com.common.Response.warn.warnOutWeight.WarnOutWeightResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 出库重量预警Service
 * @author zx
 * @version 2020-08-24
 */
@Service
@Transactional(readOnly = true)
public class WarnOutWeightService {

	@Autowired
	private WarnOutWeightDao warnOutWeightDao;

    public QueryResponseResult findList(int page, int size, WarnOutWeightRequest warnOutWeightRequest) {
        //为防止后面报空指针，先进行查询条件的非空判断
        if (warnOutWeightRequest == null) {
            warnOutWeightRequest = new WarnOutWeightRequest();
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
        List<WarnOutWeight> list = warnOutWeightDao.findList();
        PageInfo<WarnOutWeight> pageInfo = new PageInfo<WarnOutWeight>(list);
        QueryResult queryResult = new QueryResult();
        queryResult.setList(list);//数据列表
        queryResult.setTotal(pageInfo.getTotal());//数据总记录数
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS, queryResult);
        return queryResponseResult;

    }

    /**
     * 添加出库重量预警
     * @param warnOutWeight
     * @return
     */
    @Transactional
    public WarnOutWeightResult add(WarnOutWeight warnOutWeight) {
            WarnOutWeight one = new WarnOutWeight();
            one.setWarnOutWeightId(IdGen.uuid());
            one.setStatus(warnOutWeight.getStatus());
            one.setCaseNum(warnOutWeight.getCaseNum());
            one.setMonitorId(warnOutWeight.getMonitorId());
            one.setInWeight(warnOutWeight.getInWeight());
            one.setOutWeight(warnOutWeight.getOutWeight());
            one.setOutPerson(warnOutWeight.getOutPerson());
            one.setOutTime(warnOutWeight.getOutTime());
            one.setWarnTime(warnOutWeight.getWarnTime());
            one.setRemarks(warnOutWeight.getRemarks());
            one.setCreateDate(new Date());
            int insert = warnOutWeightDao.insert(one);
            if (insert > 0) {
                //返回成功
                return new WarnOutWeightResult(CommonCode.SUCCESS, one);
            } else {
                //自定义异常处理
                ExceptionCast.cast(WarnOutWeightCode.CMS_INSERT_FALSE);
            }
        //返回失败
        return new WarnOutWeightResult(WarnOutWeightCode.CMS_INSERT_FALSE, null);
    }

    /**
     * 通过ID查询出库重量预警
     * @param id
     * @return
     */
    public WarnOutWeightResult findById(String id) {
        if (warnOutWeightDao.get(id) != null) {
            WarnOutWeight warnOutWeight = warnOutWeightDao.get(id);
            //返回成功
            return new WarnOutWeightResult(CommonCode.SUCCESS, warnOutWeight);
        }
        //返回失败
        return new WarnOutWeightResult(WarnOutWeightCode.CMS_GET_ISNULL, null);
    }

	/**
	 * 通过id修改出库重量预警
	 * @param id
	 * @return
	 */
    @Transactional
	public WarnOutWeightResult edit(String id, WarnOutWeight warnOutWeight) {
        if (warnOutWeightDao.get(id) != null) {
            WarnOutWeight one = warnOutWeightDao.get(id);
            one.setStatus(warnOutWeight.getStatus());
            one.setCaseNum(warnOutWeight.getCaseNum());
            one.setMonitorId(warnOutWeight.getMonitorId());
            one.setInWeight(warnOutWeight.getInWeight());
            one.setOutWeight(warnOutWeight.getOutWeight());
            one.setOutPerson(warnOutWeight.getOutPerson());
            one.setOutTime(warnOutWeight.getOutTime());
            one.setWarnTime(warnOutWeight.getWarnTime());
            one.setRemarks(warnOutWeight.getRemarks());
            int update = warnOutWeightDao.update(one);
            if (update > 0) {
                //返回成功
                return new WarnOutWeightResult(CommonCode.SUCCESS, one);
            } else {
                //自定义异常处理
                ExceptionCast.cast(WarnOutWeightCode.CMS_UPDATE_FALSE);
            }
        }
        //返回失败
        return new WarnOutWeightResult(WarnOutWeightCode.CMS_GET_ISNULL, null);
	}

	/**
	 * 通过id删除出库重量预警
	 * @param id
	 * @return
	 */
    @Transactional
	public ResponseResult delete(String id) {
        if (warnOutWeightDao.get(id) != null) {
            int delete = warnOutWeightDao.delete(id);
            if (delete > 0) {
                //返回成功
                return new ResponseResult(CommonCode.SUCCESS);
            } else {
                //自定义异常处理
                ExceptionCast.cast(WarnOutWeightCode.CMS_DELETE_FALSE);
            }
        }
        //返回失败
        return new WarnOutWeightResult(WarnOutWeightCode.CMS_GET_ISNULL, null);
	}

}