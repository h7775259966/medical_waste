package com.module.service.warn.warnViolation;

import com.common.Response.CommonCode;
import com.common.Response.QueryResponseResult;
import com.common.Response.QueryResult;
import com.common.Response.ResponseResult;
import com.common.Utils.IdGen;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.common.Exception.ExceptionCast;
import com.module.dao.warn.warnViolation.WarnViolationDao;
import com.module.entity.warn.warnViolation.WarnViolation;
import com.common.Request.warn.warnViolation.WarnViolationRequest;
import com.common.Response.warn.warnViolation.WarnViolationCode;
import com.common.Response.warn.warnViolation.WarnViolationResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 违规预警Service
 * @author zx
 * @version 2020-08-24
 */
@Service
@Transactional(readOnly = true)
public class WarnViolationService {

	@Autowired
	private WarnViolationDao warnViolationDao;

    public QueryResponseResult findList(int page, int size, WarnViolationRequest warnViolationRequest) {
        //为防止后面报空指针，先进行查询条件的非空判断
        if (warnViolationRequest == null) {
            warnViolationRequest = new WarnViolationRequest();
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
        //注意：如果warnViolationRequest内参数不为空，则进行带值查询
        //warnViolationDao.findList()为没有任何查询条件的分页查询
        List<WarnViolation> list = warnViolationDao.findList();
        PageInfo<WarnViolation> pageInfo = new PageInfo<WarnViolation>(list);

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
     * 添加违规预警
     * @param warnViolation
     * @return
     */
    @Transactional
    public WarnViolationResult add(WarnViolation warnViolation) {
            WarnViolation one = new WarnViolation();
            one.setWarnViolationId(IdGen.uuid());
            one.setDepartmentId(warnViolation.getDepartmentId());
            one.setOfficeId(warnViolation.getOfficeId());
            one.setStatus(warnViolation.getStatus());
            one.setCode(warnViolation.getCode());
            one.setCollectId(warnViolation.getCollectId());
            one.setCollectNumber(warnViolation.getCollectNumber());
            one.setTrashId(warnViolation.getTrashId());
            one.setWeight(warnViolation.getWeight());
            one.setWarnTime(warnViolation.getWarnTime());
            one.setCollectTime(warnViolation.getCollectTime());
            one.setPutInTime(warnViolation.getPutInTime());
            one.setRemarks(warnViolation.getRemarks());
            one.setCreateDate(new Date());
            int insert = warnViolationDao.insert(one);
            if (insert > 0) {
                //返回成功
                return new WarnViolationResult(CommonCode.SUCCESS, one);
            } else {
                //自定义异常处理
                ExceptionCast.cast(WarnViolationCode.CMS_INSERT_FALSE);
            }
        //返回失败
        return new WarnViolationResult(WarnViolationCode.CMS_INSERT_FALSE, null);
    }

    /**
     * 通过ID查询违规预警
     * @param id
     * @return
     */
    public WarnViolationResult findById(String id) {
        if (warnViolationDao.get(id) != null) {
            WarnViolation warnViolation = warnViolationDao.get(id);
            //返回成功
            return new WarnViolationResult(CommonCode.SUCCESS, warnViolation);
        }
        //返回失败
        return new WarnViolationResult(WarnViolationCode.CMS_GET_ISNULL, null);
    }

	/**
	 * 通过id修改违规预警
	 * @param id
	 * @return
	 */
    @Transactional
	public WarnViolationResult edit(String id, WarnViolation warnViolation) {
        if (warnViolationDao.get(id) != null) {
            WarnViolation one = warnViolationDao.get(id);
            one.setDepartmentId(warnViolation.getDepartmentId());
            one.setOfficeId(warnViolation.getOfficeId());
            one.setStatus(warnViolation.getStatus());
            one.setCode(warnViolation.getCode());
            one.setCollectId(warnViolation.getCollectId());
            one.setCollectNumber(warnViolation.getCollectNumber());
            one.setTrashId(warnViolation.getTrashId());
            one.setWeight(warnViolation.getWeight());
            one.setWarnTime(warnViolation.getWarnTime());
            one.setCollectTime(warnViolation.getCollectTime());
            one.setPutInTime(warnViolation.getPutInTime());
            one.setRemarks(warnViolation.getRemarks());
            int update = warnViolationDao.update(one);
            if (update > 0) {
                //返回成功
                return new WarnViolationResult(CommonCode.SUCCESS, one);
            } else {
                //自定义异常处理
                ExceptionCast.cast(WarnViolationCode.CMS_UPDATE_FALSE);
            }
        }
        //返回失败
        return new WarnViolationResult(WarnViolationCode.CMS_GET_ISNULL, null);
	}

	/**
	 * 通过id删除违规预警
	 * @param id
	 * @return
	 */
    @Transactional
	public ResponseResult delete(String id) {
        if (warnViolationDao.get(id) != null) {
            int delete = warnViolationDao.delete(id);
            if (delete > 0) {
                //返回成功
                return new ResponseResult(CommonCode.SUCCESS);
            } else {
                //自定义异常处理
                ExceptionCast.cast(WarnViolationCode.CMS_DELETE_FALSE);
            }
        }
        //返回失败
        return new WarnViolationResult(WarnViolationCode.CMS_GET_ISNULL, null);
	}

}