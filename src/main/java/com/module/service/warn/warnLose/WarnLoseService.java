package com.module.service.warn.warnLose;

import com.common.Response.CommonCode;
import com.common.Response.QueryResponseResult;
import com.common.Response.QueryResult;
import com.common.Response.ResponseResult;
import com.common.Utils.IdGen;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.common.Exception.ExceptionCast;
import com.module.dao.warn.warnLose.WarnLoseDao;
import com.module.entity.warn.WarnLose;
import com.common.Request.warn.warnLose.WarnLoseRequest;
import com.common.Response.warn.warnLose.WarnLoseCode;
import com.common.Response.warn.warnLose.WarnLoseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 遗失预警Service
 * @author zx
 * @version 2020-08-24
 */
@Service
@Transactional(readOnly = true)
public class WarnLoseService {

	@Autowired
	private WarnLoseDao warnLoseDao;

    public QueryResponseResult findList(int page, int size, WarnLoseRequest warnLoseRequest) {
        //为防止后面报空指针，先进行查询条件的非空判断
        if (warnLoseRequest == null) {
            warnLoseRequest = new WarnLoseRequest();
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
        //注意：如果warnLoseRequest内参数不为空，则进行带值查询
        //warnLoseDao.findList()为没有任何查询条件的分页查询
        List<WarnLose> list = warnLoseDao.findList();
        PageInfo<WarnLose> pageInfo = new PageInfo<WarnLose>(list);
        QueryResult queryResult = new QueryResult();
        queryResult.setList(list);//数据列表
        queryResult.setTotal(pageInfo.getTotal());//数据总记录数
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS, queryResult);
        return queryResponseResult;

    }

    /**
     * 添加遗失预警
     * @param warnLose
     * @return
     */
    @Transactional
    public WarnLoseResult add(WarnLose warnLose) {
            WarnLose one = new WarnLose();
            one.setWarnLoseId(IdGen.uuid());
            one.setDepartmentId(warnLose.getDepartmentId());
            one.setOfficeId(warnLose.getOfficeId());
            one.setStatus(warnLose.getStatus());
            one.setCode(warnLose.getCode());
            one.setCollectId(warnLose.getCollectId());
            one.setCollectNumber(warnLose.getCollectNumber());
            one.setTrashId(warnLose.getTrashId());
            one.setWeight(warnLose.getWeight());
            one.setWarnTime(warnLose.getWarnTime());
            one.setCollectTime(warnLose.getCollectTime());
            one.setPutInTime(warnLose.getPutInTime());
            one.setRemarks(warnLose.getRemarks());
            one.setCreateDate(new Date());
            int insert = warnLoseDao.insert(one);
            if (insert > 0) {
                //返回成功
                return new WarnLoseResult(CommonCode.SUCCESS, one);
            } else {
                //自定义异常处理
                ExceptionCast.cast(WarnLoseCode.CMS_INSERT_FALSE);
            }
        //返回失败
        return new WarnLoseResult(WarnLoseCode.CMS_INSERT_FALSE, null);
    }

    /**
     * 通过ID查询遗失预警
     * @param id
     * @return
     */
    public WarnLoseResult findById(String id) {
        if (warnLoseDao.get(id) != null) {
            WarnLose warnLose = warnLoseDao.get(id);
            //返回成功
            return new WarnLoseResult(CommonCode.SUCCESS, warnLose);
        }
        //返回失败
        return new WarnLoseResult(WarnLoseCode.CMS_GET_ISNULL, null);
    }

	/**
	 * 通过id修改遗失预警
	 * @param id
	 * @return
	 */
    @Transactional
	public WarnLoseResult edit(String id, WarnLose warnLose) {
        if (warnLoseDao.get(id) != null) {
            WarnLose one = warnLoseDao.get(id);
            one.setDepartmentId(warnLose.getDepartmentId());
            one.setOfficeId(warnLose.getOfficeId());
            one.setStatus(warnLose.getStatus());
            one.setCode(warnLose.getCode());
            one.setCollectId(warnLose.getCollectId());
            one.setCollectNumber(warnLose.getCollectNumber());
            one.setTrashId(warnLose.getTrashId());
            one.setWeight(warnLose.getWeight());
            one.setWarnTime(warnLose.getWarnTime());
            one.setCollectTime(warnLose.getCollectTime());
            one.setPutInTime(warnLose.getPutInTime());
            one.setRemarks(warnLose.getRemarks());
            int update = warnLoseDao.update(one);
            if (update > 0) {
                //返回成功
                return new WarnLoseResult(CommonCode.SUCCESS, one);
            } else {
                //自定义异常处理
                ExceptionCast.cast(WarnLoseCode.CMS_UPDATE_FALSE);
            }
        }
        //返回失败
        return new WarnLoseResult(WarnLoseCode.CMS_GET_ISNULL, null);
	}

	/**
	 * 通过id删除遗失预警
	 * @param id
	 * @return
	 */
    @Transactional
	public ResponseResult delete(String id) {
        if (warnLoseDao.get(id) != null) {
            int delete = warnLoseDao.delete(id);
            if (delete > 0) {
                //返回成功
                return new ResponseResult(CommonCode.SUCCESS);
            } else {
                //自定义异常处理
                ExceptionCast.cast(WarnLoseCode.CMS_DELETE_FALSE);
            }
        }
        //返回失败
        return new WarnLoseResult(WarnLoseCode.CMS_GET_ISNULL, null);
	}

}