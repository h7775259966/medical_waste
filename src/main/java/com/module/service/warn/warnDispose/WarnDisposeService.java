package com.module.service.warn.warnDispose;

import com.common.Response.CommonCode;
import com.common.Response.QueryResponseResult;
import com.common.Response.QueryResult;
import com.common.Response.ResponseResult;
import com.common.Utils.IdGen;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.common.Exception.ExceptionCast;
import com.module.dao.warn.warnDispose.WarnDisposeDao;
import com.module.entity.warn.warnDispose.WarnDispose;
import com.common.Request.warn.warnDispose.WarnDisposeRequest;
import com.common.Response.warn.warnDispose.WarnDisposeCode;
import com.common.Response.warn.warnDispose.WarnDisposeResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 预警处理Service
 * @author zx
 * @version 2020-08-24
 */
@Service
@Transactional(readOnly = true)
public class WarnDisposeService {

	@Autowired
	private WarnDisposeDao warnDisposeDao;

    public QueryResponseResult findList(int page, int size, WarnDisposeRequest warnDisposeRequest) {
        //为防止后面报空指针，先进行查询条件的非空判断
        if (warnDisposeRequest == null) {
            warnDisposeRequest = new WarnDisposeRequest();
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
        //注意：如果warnDisposeRequest内参数不为空，则进行带值查询
        //warnDisposeDao.findList()为没有任何查询条件的分页查询
        List<WarnDispose> list = warnDisposeDao.findList();
        PageInfo<WarnDispose> pageInfo = new PageInfo<WarnDispose>(list);

        /*System.out.println("总数量：" + pageInfo.getTotal());
        System.out.println("当前页查询记录：" + pageInfo.getList().size());
        System.out.println("当前页码：" + pageInfo.getPageNum());
        System.out.println("每页显示数量：" + pageInfo.getPageSize());
        System.out.println("总页：" + pageInfo.getPages());*/

        //封装结果
        QueryResult queryResult = new QueryResult();
        queryResult.setList(list);//数据列表
        queryResult.setTotal(pageInfo.getTotal());//数据总记录数
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS, queryResult);
        return queryResponseResult;

    }

    /**
     * 添加预警处理
     * @param warnDispose
     * @return
     */
    @Transactional
    public WarnDisposeResult add(WarnDispose warnDispose) {
            WarnDispose one = new WarnDispose();
            one.setWarnDisposeId(IdGen.uuid());
            one.setStatus(warnDispose.getStatus());
            one.setConductor(warnDispose.getConductor());
            one.setWarnReason(warnDispose.getWarnReason());
            one.setWarnSuggestion(warnDispose.getWarnSuggestion());
            one.setWarnTypeId(warnDispose.getWarnTypeId());
            one.setRemarks(warnDispose.getRemarks());
            one.setCreateDate(new Date());
            int insert = warnDisposeDao.insert(one);
            if (insert > 0) {
                //返回成功
                return new WarnDisposeResult(CommonCode.SUCCESS, one);
            } else {
                //自定义异常处理
                ExceptionCast.cast(WarnDisposeCode.CMS_INSERT_FALSE);
            }
        //返回失败
        return new WarnDisposeResult(WarnDisposeCode.CMS_NAME_REPETITION, null);
    }

    /**
     * 通过ID查询预警处理
     * @param id
     * @return
     */
    public WarnDisposeResult findById(String id) {
        if (warnDisposeDao.get(id) != null) {
            WarnDispose warnDispose = warnDisposeDao.get(id);
            //返回成功
            return new WarnDisposeResult(CommonCode.SUCCESS, warnDispose);
        }
        //返回失败
        return new WarnDisposeResult(WarnDisposeCode.CMS_GET_ISNULL, null);
    }

	/**
	 * 通过id修改预警处理
	 * @param id
	 * @return
	 */
    @Transactional
	public WarnDisposeResult edit(String id, WarnDispose warnDispose) {
        if (warnDisposeDao.get(id) != null) {
            WarnDispose one = warnDisposeDao.get(id);
            one.setStatus(warnDispose.getStatus());
            one.setConductor(warnDispose.getConductor());
            one.setWarnReason(warnDispose.getWarnReason());
            one.setWarnSuggestion(warnDispose.getWarnSuggestion());
            one.setWarnTypeId(warnDispose.getWarnTypeId());
            one.setRemarks(warnDispose.getRemarks());
            int update = warnDisposeDao.update(one);
            if (update > 0) {
                //返回成功
                return new WarnDisposeResult(CommonCode.SUCCESS, one);
            } else {
                //自定义异常处理
                ExceptionCast.cast(WarnDisposeCode.CMS_UPDATE_FALSE);
            }
        }
        //返回失败
        return new WarnDisposeResult(WarnDisposeCode.CMS_GET_ISNULL, null);
	}

	/**
	 * 通过id删除预警处理
	 * @param id
	 * @return
	 */
    @Transactional
	public ResponseResult delete(String id) {
        if (warnDisposeDao.get(id) != null) {
            int delete = warnDisposeDao.delete(id);
            if (delete > 0) {
                //返回成功
                return new ResponseResult(CommonCode.SUCCESS);
            } else {
                //自定义异常处理
                ExceptionCast.cast(WarnDisposeCode.CMS_DELETE_FALSE);
            }
        }
        //返回失败
        return new WarnDisposeResult(WarnDisposeCode.CMS_GET_ISNULL, null);
	}

}