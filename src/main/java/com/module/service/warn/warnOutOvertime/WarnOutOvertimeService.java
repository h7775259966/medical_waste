package com.module.service.warn.warnOutOvertime;

import com.common.Response.CommonCode;
import com.common.Response.QueryResponseResult;
import com.common.Response.QueryResult;
import com.common.Response.ResponseResult;
import com.common.Utils.IdGen;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.module.config.exception.ExceptionCast;
import com.module.dao.warn.warnOutOvertime.WarnOutOvertimeDao;
import com.module.entity.warn.warnOutOvertime.WarnOutOvertime;
import com.module.request.warn.warnOutOvertime.WarnOutOvertimeRequest;
import com.module.response.warn.warnOutOvertime.WarnOutOvertimeCode;
import com.module.response.warn.warnOutOvertime.WarnOutOvertimeResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 出库超时预警Service
 * @author zx
 * @version 2020-08-24
 */
@Service
@Transactional(readOnly = true)
public class WarnOutOvertimeService {

	@Autowired
	private WarnOutOvertimeDao warnOutOvertimeDao;

    public QueryResponseResult findList(int page, int size, WarnOutOvertimeRequest warnOutOvertimeRequest) {
        //为防止后面报空指针，先进行查询条件的非空判断
        if (warnOutOvertimeRequest == null) {
            warnOutOvertimeRequest = new WarnOutOvertimeRequest();
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
        List<WarnOutOvertime> list = warnOutOvertimeDao.findList();
        PageInfo<WarnOutOvertime> pageInfo = new PageInfo<WarnOutOvertime>(list);
        QueryResult queryResult = new QueryResult();
        queryResult.setList(list);//数据列表
        queryResult.setTotal(pageInfo.getTotal());//数据总记录数
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS, queryResult);
        return queryResponseResult;

    }

    /**
     * 添加出库超时预警
     * @param warnOutOvertime
     * @return
     */
    @Transactional
    public WarnOutOvertimeResult add(WarnOutOvertime warnOutOvertime) {
            WarnOutOvertime one = new WarnOutOvertime();
            one.setWarnOutOvertimeId(IdGen.uuid());
            one.setStatus(warnOutOvertime.getStatus());
            one.setMonitorId(warnOutOvertime.getMonitorId());
            one.setNoOutTime(warnOutOvertime.getNoOutTime());
            one.setOutTimeLimit(warnOutOvertime.getOutTimeLimit());
            one.setWarnTime(warnOutOvertime.getWarnTime());
            one.setRemarks(warnOutOvertime.getRemarks());
            one.setCreateDate(new Date());
            int insert = warnOutOvertimeDao.insert(one);
            if (insert > 0) {
                //返回成功
                return new WarnOutOvertimeResult(CommonCode.SUCCESS, one);
            } else {
                //自定义异常处理
                ExceptionCast.cast(WarnOutOvertimeCode.CMS_INSERT_FALSE);
            }
        //返回失败
        return new WarnOutOvertimeResult(WarnOutOvertimeCode.CMS_INSERT_FALSE, null);
    }

    /**
     * 通过ID查询出库超时预警
     * @param id
     * @return
     */
    public WarnOutOvertimeResult findById(String id) {
        if (warnOutOvertimeDao.get(id) != null) {
            WarnOutOvertime warnOutOvertime = warnOutOvertimeDao.get(id);
            //返回成功
            return new WarnOutOvertimeResult(CommonCode.SUCCESS, warnOutOvertime);
        }
        //返回失败
        return new WarnOutOvertimeResult(WarnOutOvertimeCode.CMS_GET_ISNULL, null);
    }

	/**
	 * 通过id修改出库超时预警
	 * @param id
	 * @return
	 */
    @Transactional
	public WarnOutOvertimeResult edit(String id, WarnOutOvertime warnOutOvertime) {
        if (warnOutOvertimeDao.get(id) != null) {
            WarnOutOvertime one = warnOutOvertimeDao.get(id);
            one.setStatus(warnOutOvertime.getStatus());
            one.setMonitorId(warnOutOvertime.getMonitorId());
            one.setNoOutTime(warnOutOvertime.getNoOutTime());
            one.setOutTimeLimit(warnOutOvertime.getOutTimeLimit());
            one.setWarnTime(warnOutOvertime.getWarnTime());
            one.setRemarks(warnOutOvertime.getRemarks());
            int update = warnOutOvertimeDao.update(one);
            if (update > 0) {
                //返回成功
                return new WarnOutOvertimeResult(CommonCode.SUCCESS, one);
            } else {
                //自定义异常处理
                ExceptionCast.cast(WarnOutOvertimeCode.CMS_UPDATE_FALSE);
            }
        }
        //返回失败
        return new WarnOutOvertimeResult(WarnOutOvertimeCode.CMS_GET_ISNULL, null);
	}

	/**
	 * 通过id删除出库超时预警
	 * @param id
	 * @return
	 */
    @Transactional
	public ResponseResult delete(String id) {
        if (warnOutOvertimeDao.get(id) != null) {
            int delete = warnOutOvertimeDao.delete(id);
            if (delete > 0) {
                //返回成功
                return new ResponseResult(CommonCode.SUCCESS);
            } else {
                //自定义异常处理
                ExceptionCast.cast(WarnOutOvertimeCode.CMS_DELETE_FALSE);
            }
        }
        //返回失败
        return new WarnOutOvertimeResult(WarnOutOvertimeCode.CMS_GET_ISNULL, null);
	}

}