package com.module.service.replenish.replenishCheck;

import com.common.Response.CommonCode;
import com.common.Response.QueryResponseResult;
import com.common.Response.QueryResult;
import com.common.Response.ResponseResult;
import com.common.Utils.IdGen;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.module.config.exception.ExceptionCast;
import com.module.dao.replenish.replenishCheck.ReplenishCheckDao;
import com.module.entity.replenish.replenishCheck.ReplenishCheck;
import com.module.request.replenish.replenishCheck.ReplenishCheckRequest;
import com.module.response.replenish.replenishCheck.ReplenishCheckCode;
import com.module.response.replenish.replenishCheck.ReplenishCheckResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 医废补录审核Service
 * @author zx
 * @version 2020-08-24
 */
@Service
@Transactional(readOnly = true)
public class ReplenishCheckService {

	@Autowired
	private ReplenishCheckDao replenishCheckDao;

    public QueryResponseResult findList(int page, int size, ReplenishCheckRequest replenishCheckRequest) {
        //为防止后面报空指针，先进行查询条件的非空判断
        if (replenishCheckRequest == null) {
            replenishCheckRequest = new ReplenishCheckRequest();
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
        //注意：如果replenishCheckRequest内参数不为空，则进行带值查询
        //replenishCheckDao.findList()为没有任何查询条件的分页查询
        List<ReplenishCheck> list = replenishCheckDao.findList();
        PageInfo<ReplenishCheck> pageInfo = new PageInfo<ReplenishCheck>(list);

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
     * 添加医废补录审核
     * @param replenishCheck
     * @return
     */
    @Transactional
    public ReplenishCheckResult add(ReplenishCheck replenishCheck) {
            ReplenishCheck one = new ReplenishCheck();
            one.setReplenishCheckId(IdGen.uuid());
            one.setReplenishId(replenishCheck.getReplenishId());
            one.setReplenishCheckCause(replenishCheck.getReplenishCheckCause());
            one.setReplenishCheckStatus(replenishCheck.getReplenishCheckStatus());
            one.setReplenishCheckSuggest(replenishCheck.getReplenishCheckSuggest());
            one.setRemarks(replenishCheck.getRemarks());
            one.setCreateDate(new Date());
            int insert = replenishCheckDao.insert(one);
            if (insert > 0) {
                //返回成功
                return new ReplenishCheckResult(CommonCode.SUCCESS, one);
            } else {
                //自定义异常处理
                ExceptionCast.cast(ReplenishCheckCode.CMS_INSERT_FALSE);
            }
        //返回失败
        return new ReplenishCheckResult(ReplenishCheckCode.CMS_INSERT_FALSE, null);
    }

    /**
     * 通过ID查询医废补录审核
     * @param id
     * @return
     */
    public ReplenishCheckResult findById(String id) {
        if (replenishCheckDao.get(id) != null) {
            ReplenishCheck replenishCheck = replenishCheckDao.get(id);
            //返回成功
            return new ReplenishCheckResult(CommonCode.SUCCESS, replenishCheck);
        }
        //返回失败
        return new ReplenishCheckResult(ReplenishCheckCode.CMS_GET_ISNULL, null);
    }

	/**
	 * 通过id修改医废补录审核
	 * @param id
	 * @return
	 */
    @Transactional
	public ReplenishCheckResult edit(String id, ReplenishCheck replenishCheck) {
        if (replenishCheckDao.get(id) != null) {
            ReplenishCheck one = replenishCheckDao.get(id);
            one.setReplenishId(replenishCheck.getReplenishId());
            one.setReplenishCheckCause(replenishCheck.getReplenishCheckCause());
            one.setReplenishCheckStatus(replenishCheck.getReplenishCheckStatus());
            one.setReplenishCheckSuggest(replenishCheck.getReplenishCheckSuggest());
            one.setRemarks(replenishCheck.getRemarks());
            int update = replenishCheckDao.update(one);
            if (update > 0) {
                //返回成功
                return new ReplenishCheckResult(CommonCode.SUCCESS, one);
            } else {
                //自定义异常处理
                ExceptionCast.cast(ReplenishCheckCode.CMS_UPDATE_FALSE);
            }
        }
        //返回失败
        return new ReplenishCheckResult(ReplenishCheckCode.CMS_GET_ISNULL, null);
	}

	/**
	 * 通过id删除医废补录审核
	 * @param id
	 * @return
	 */
    @Transactional
	public ResponseResult delete(String id) {
        if (replenishCheckDao.get(id) != null) {
            int delete = replenishCheckDao.delete(id);
            if (delete > 0) {
                //返回成功
                return new ResponseResult(CommonCode.SUCCESS);
            } else {
                //自定义异常处理
                ExceptionCast.cast(ReplenishCheckCode.CMS_DELETE_FALSE);
            }
        }
        //返回失败
        return new ReplenishCheckResult(ReplenishCheckCode.CMS_GET_ISNULL, null);
	}

}