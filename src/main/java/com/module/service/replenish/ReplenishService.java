package com.module.service.replenish;

import com.common.Response.CommonCode;
import com.common.Response.QueryResponseResult;
import com.common.Response.QueryResult;
import com.common.Response.ResponseResult;
import com.common.Utils.IdGen;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.module.config.exception.ExceptionCast;
import com.module.dao.replenish.ReplenishDao;
import com.module.entity.replenish.Replenish;
import com.module.request.replenish.ReplenishRequest;
import com.module.response.replenish.ReplenishCode;
import com.module.response.replenish.ReplenishResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 医废补录Service
 * @author zx
 * @version 2020-08-24
 */
@Service
@Transactional(readOnly = true)
public class ReplenishService {

	@Autowired
	private ReplenishDao replenishDao;

    public QueryResponseResult findList(int page, int size, ReplenishRequest replenishRequest) {
        //为防止后面报空指针，先进行查询条件的非空判断
        if (replenishRequest == null) {
            replenishRequest = new ReplenishRequest();
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
        //注意：如果replenishRequest内参数不为空，则进行带值查询
        //replenishDao.findList()为没有任何查询条件的分页查询
        List<Replenish> list = replenishDao.findList();
        PageInfo<Replenish> pageInfo = new PageInfo<Replenish>(list);

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
     * 添加医废补录
     * @param replenish
     * @return
     */
    @Transactional
    public ReplenishResult add(Replenish replenish) {
            Replenish one = new Replenish();
            one.setReplenishId(IdGen.uuid());
            one.setCheckStatus(replenish.getCheckStatus());
            one.setWarehouseStatus(replenish.getWarehouseStatus());
            one.setUserId(replenish.getUserId());
            one.setCollectId(replenish.getCollectId());
            one.setNurseId(replenish.getNurseId());
            one.setOfficeId(replenish.getOfficeId());
            one.setTrashId(replenish.getTrashId());
            one.setReplenishNumber(replenish.getReplenishNumber());
            one.setReplenishWeight(replenish.getReplenishWeight());
            one.setRemarks(replenish.getRemarks());
            one.setReplenishTime(replenish.getReplenishTime());
            one.setCollectTime(replenish.getCollectTime());
            one.setCreateDate(new Date());
            int insert = replenishDao.insert(one);
            if (insert > 0) {
                //返回成功
                return new ReplenishResult(CommonCode.SUCCESS, one);
            } else {
                //自定义异常处理
                ExceptionCast.cast(ReplenishCode.CMS_INSERT_FALSE);
            }
        //返回失败
        return new ReplenishResult(ReplenishCode.CMS_NAME_REPETITION, null);
    }

    /**
     * 通过ID查询医废补录
     * @param id
     * @return
     */
    public ReplenishResult findById(String id) {
        if (replenishDao.get(id) != null) {
            Replenish replenish = replenishDao.get(id);
            //返回成功
            return new ReplenishResult(CommonCode.SUCCESS, replenish);
        }
        //返回失败
        return new ReplenishResult(ReplenishCode.CMS_GET_ISNULL, null);
    }

	/**
	 * 通过id修改医废补录
	 * @param id
	 * @return
	 */
    @Transactional
	public ReplenishResult edit(String id, Replenish replenish) {
        if (replenishDao.get(id) != null) {
            Replenish one = replenishDao.get(id);
            one.setCheckStatus(replenish.getCheckStatus());
            one.setWarehouseStatus(replenish.getWarehouseStatus());
            one.setUserId(replenish.getUserId());
            one.setCollectId(replenish.getCollectId());
            one.setNurseId(replenish.getNurseId());
            one.setOfficeId(replenish.getOfficeId());
            one.setTrashId(replenish.getTrashId());
            one.setReplenishNumber(replenish.getReplenishNumber());
            one.setReplenishWeight(replenish.getReplenishWeight());
            one.setRemarks(replenish.getRemarks());
            one.setReplenishTime(replenish.getReplenishTime());
            one.setCollectTime(replenish.getCollectTime());
            int update = replenishDao.update(one);
            if (update > 0) {
                //返回成功
                return new ReplenishResult(CommonCode.SUCCESS, one);
            } else {
                //自定义异常处理
                ExceptionCast.cast(ReplenishCode.CMS_UPDATE_FALSE);
            }
        }
        //返回失败
        return new ReplenishResult(ReplenishCode.CMS_GET_ISNULL, null);
	}

	/**
	 * 通过id删除医废补录
	 * @param id
	 * @return
	 */
    @Transactional
	public ResponseResult delete(String id) {
        if (replenishDao.get(id) != null) {
            int delete = replenishDao.delete(id);
            if (delete > 0) {
                //返回成功
                return new ResponseResult(CommonCode.SUCCESS);
            } else {
                //自定义异常处理
                ExceptionCast.cast(ReplenishCode.CMS_DELETE_FALSE);
            }
        }
        //返回失败
        return new ReplenishResult(ReplenishCode.CMS_GET_ISNULL, null);
	}

}