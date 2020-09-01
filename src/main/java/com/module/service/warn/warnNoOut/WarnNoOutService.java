package com.module.service.warn.warnNoOut;

import com.common.Response.CommonCode;
import com.common.Response.QueryResponseResult;
import com.common.Response.QueryResult;
import com.common.Response.ResponseResult;
import com.common.Utils.IdGen;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.module.config.exception.ExceptionCast;
import com.module.dao.warn.warnNoOut.WarnNoOutDao;
import com.module.entity.warn.warnNoOut.WarnNoOut;
import com.module.request.warn.warnNoOut.WarnNoOutRequest;
import com.module.response.warn.warnNoOut.WarnNoOutCode;
import com.module.response.warn.warnNoOut.WarnNoOutResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 未出预警Service
 * @author zx
 * @version 2020-08-24
 */
@Service
@Transactional(readOnly = true)
public class WarnNoOutService {

	@Autowired
	private WarnNoOutDao warnNoOutDao;

    public QueryResponseResult findList(int page, int size, WarnNoOutRequest warnNoOutRequest) {
        //为防止后面报空指针，先进行查询条件的非空判断
        if (warnNoOutRequest == null) {
            warnNoOutRequest = new WarnNoOutRequest();
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
        //注意：如果warnNoOutRequest内参数不为空，则进行带值查询
        //warnNoOutDao.findList()为没有任何查询条件的分页查询
        List<WarnNoOut> list = warnNoOutDao.findList();
        PageInfo<WarnNoOut> pageInfo = new PageInfo<WarnNoOut>(list);

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
     * 添加未出预警
     * @param warnNoOut
     * @return
     */
    @Transactional
    public WarnNoOutResult add(WarnNoOut warnNoOut) {
            WarnNoOut one = new WarnNoOut();
            one.setWarnNoOutId(IdGen.uuid());
            one.setDepartmentId(warnNoOut.getDepartmentId());
            one.setOfficeId(warnNoOut.getOfficeId());
            one.setStatus(warnNoOut.getStatus());
            one.setNoOutTime(warnNoOut.getNoOutTime());
            one.setWarnTime(warnNoOut.getWarnTime());
            one.setWarnTimeLimit(warnNoOut.getWarnTimeLimit());
            one.setRemarks(warnNoOut.getRemarks());
            one.setCreateDate(new Date());
            int insert = warnNoOutDao.insert(one);
            if (insert > 0) {
                //返回成功
                return new WarnNoOutResult(CommonCode.SUCCESS, one);
            } else {
                //自定义异常处理
                ExceptionCast.cast(WarnNoOutCode.CMS_INSERT_FALSE);
            }
        //返回失败
        return new WarnNoOutResult(WarnNoOutCode.CMS_INSERT_FALSE, null);
    }

    /**
     * 通过ID查询未出预警
     * @param id
     * @return
     */
    public WarnNoOutResult findById(String id) {
        if (warnNoOutDao.get(id) != null) {
            WarnNoOut warnNoOut = warnNoOutDao.get(id);
            //返回成功
            return new WarnNoOutResult(CommonCode.SUCCESS, warnNoOut);
        }
        //返回失败
        return new WarnNoOutResult(WarnNoOutCode.CMS_GET_ISNULL, null);
    }

	/**
	 * 通过id修改未出预警
	 * @param id
	 * @return
	 */
    @Transactional
	public WarnNoOutResult edit(String id, WarnNoOut warnNoOut) {
        if (warnNoOutDao.get(id) != null) {
            WarnNoOut one = warnNoOutDao.get(id);
            one.setDepartmentId(warnNoOut.getDepartmentId());
            one.setOfficeId(warnNoOut.getOfficeId());
            one.setStatus(warnNoOut.getStatus());
            one.setNoOutTime(warnNoOut.getNoOutTime());
            one.setWarnTime(warnNoOut.getWarnTime());
            one.setWarnTimeLimit(warnNoOut.getWarnTimeLimit());
            one.setRemarks(warnNoOut.getRemarks());
            int update = warnNoOutDao.update(one);
            if (update > 0) {
                //返回成功
                return new WarnNoOutResult(CommonCode.SUCCESS, one);
            } else {
                //自定义异常处理
                ExceptionCast.cast(WarnNoOutCode.CMS_UPDATE_FALSE);
            }
        }
        //返回失败
        return new WarnNoOutResult(WarnNoOutCode.CMS_GET_ISNULL, null);
	}

	/**
	 * 通过id删除未出预警
	 * @param id
	 * @return
	 */
    @Transactional
	public ResponseResult delete(String id) {
        if (warnNoOutDao.get(id) != null) {
            int delete = warnNoOutDao.delete(id);
            if (delete > 0) {
                //返回成功
                return new ResponseResult(CommonCode.SUCCESS);
            } else {
                //自定义异常处理
                ExceptionCast.cast(WarnNoOutCode.CMS_DELETE_FALSE);
            }
        }
        //返回失败
        return new WarnNoOutResult(WarnNoOutCode.CMS_GET_ISNULL, null);
	}

}