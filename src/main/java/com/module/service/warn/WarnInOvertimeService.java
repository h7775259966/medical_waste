package com.module.service.warn;

import com.common.Exception.ExceptionCast;
import com.common.Request.warn.WarnInOvertimeRequest;
import com.common.Response.CommonCode;
import com.common.Response.QueryResponseResult;
import com.common.Response.QueryResult;
import com.common.Response.ResponseResult;
import com.common.Response.warn.WarnInOvertimeCode;
import com.common.Response.warn.WarnInOvertimeResult;
import com.common.Utils.IdGen;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.module.dao.warn.WarnInOvertimeDao;
import com.module.entity.warn.WarnInOvertime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 入库超时预警Service
 * @author zx
 * @version 2020-08-24
 */
@Service
@Transactional(readOnly = true)
public class WarnInOvertimeService {

	@Autowired
	private WarnInOvertimeDao warnInOvertimeDao;

    public QueryResponseResult findList(int page, int size, WarnInOvertimeRequest warnInOvertimeRequest) {
        //为防止后面报空指针，先进行查询条件的非空判断
        if (warnInOvertimeRequest == null) {
            warnInOvertimeRequest = new WarnInOvertimeRequest();
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
        List<WarnInOvertime> list = warnInOvertimeDao.findList();
        PageInfo<WarnInOvertime> pageInfo = new PageInfo<WarnInOvertime>(list);
        QueryResult queryResult = new QueryResult();
        queryResult.setList(list);//数据列表
        queryResult.setTotal(pageInfo.getTotal());//数据总记录数
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS, queryResult);
        return queryResponseResult;

    }

    /**
     * 添加入库超时预警
     * @param warnInOvertime
     * @return
     */
    @Transactional
    public WarnInOvertimeResult add(WarnInOvertime warnInOvertime) {
            WarnInOvertime one = new WarnInOvertime();
            one.setWarnInOvertimeId(IdGen.uuid());
            one.setStatus(warnInOvertime.getStatus());
            one.setMonitorId(warnInOvertime.getMonitorId());
            one.setTrashCollectId(warnInOvertime.getTrashCollectId());
            one.setOutTimeLimit(warnInOvertime.getOutTimeLimit());
            one.setWarnTime(warnInOvertime.getWarnTime());
            one.setRemarks(warnInOvertime.getRemarks());
            one.setCreateDate(new Date());
            int insert = warnInOvertimeDao.insert(one);
            if (insert > 0) {
                //返回成功
                return new WarnInOvertimeResult(CommonCode.SUCCESS, one);
            } else {
                //自定义异常处理
                ExceptionCast.cast(WarnInOvertimeCode.CMS_INSERT_FALSE);
            }
        //返回失败
        return new WarnInOvertimeResult(WarnInOvertimeCode.CMS_INSERT_FALSE, null);
    }

    /**
     * 通过ID查询入库超时预警
     * @param id
     * @return
     */
    public WarnInOvertimeResult findById(String id) {
        if (warnInOvertimeDao.get(id) != null) {
            WarnInOvertime warnInOvertime = warnInOvertimeDao.get(id);
            //返回成功
            return new WarnInOvertimeResult(CommonCode.SUCCESS, warnInOvertime);
        }
        //返回失败
        return new WarnInOvertimeResult(WarnInOvertimeCode.CMS_GET_ISNULL, null);
    }

	/**
	 * 通过id修改入库超时预警
	 * @param id
	 * @return
	 */
    @Transactional
	public WarnInOvertimeResult edit(String id, WarnInOvertime warnInOvertime) {
        if (warnInOvertimeDao.get(id) != null) {
            WarnInOvertime one = warnInOvertimeDao.get(id);
            one.setStatus(warnInOvertime.getStatus());
            one.setMonitorId(warnInOvertime.getMonitorId());
            one.setTrashCollectId(warnInOvertime.getTrashCollectId());
            one.setOutTimeLimit(warnInOvertime.getOutTimeLimit());
            one.setWarnTime(warnInOvertime.getWarnTime());
            one.setRemarks(warnInOvertime.getRemarks());
            int update = warnInOvertimeDao.update(one);
            if (update > 0) {
                //返回成功
                return new WarnInOvertimeResult(CommonCode.SUCCESS, one);
            } else {
                //自定义异常处理
                ExceptionCast.cast(WarnInOvertimeCode.CMS_UPDATE_FALSE);
            }
        }
        //返回失败
        return new WarnInOvertimeResult(WarnInOvertimeCode.CMS_GET_ISNULL, null);
	}

	/**
	 * 通过id删除入库超时预警
	 * @param id
	 * @return
	 */
    @Transactional
	public ResponseResult delete(String id) {
        if (warnInOvertimeDao.get(id) != null) {
            int delete = warnInOvertimeDao.delete(id);
            if (delete > 0) {
                //返回成功
                return new ResponseResult(CommonCode.SUCCESS);
            } else {
                //自定义异常处理
                ExceptionCast.cast(WarnInOvertimeCode.CMS_DELETE_FALSE);
            }
        }
        //返回失败
        return new WarnInOvertimeResult(WarnInOvertimeCode.CMS_GET_ISNULL, null);
	}

}