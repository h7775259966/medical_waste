package com.module.service.warn.warnOpinion;

import com.common.Exception.ExceptionCast;
import com.common.Request.warn.warnOpinion.WarnOpinionRequest;
import com.common.Response.CommonCode;
import com.common.Response.QueryResponseResult;
import com.common.Response.QueryResult;
import com.common.Response.ResponseResult;
import com.common.Response.warn.warnOpinion.WarnOpinionCode;
import com.common.Response.warn.warnOpinion.WarnOpinionResult;
import com.common.Utils.IdGen;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.module.dao.warn.warnOpinion.WarnOpinionDao;
import com.module.entity.warn.warnOpinion.WarnOpinion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 预警意见Service
 * @author zx
 * @version 2020-08-24
 */
@Service
@Transactional(readOnly = true)
public class WarnOpinionService {

	@Autowired
	private WarnOpinionDao warnOpinionDao;

    public QueryResponseResult findList(int page, int size, WarnOpinionRequest warnOpinionRequest) {
        //为防止后面报空指针，先进行查询条件的非空判断
        if (warnOpinionRequest == null) {
            warnOpinionRequest = new WarnOpinionRequest();
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
        List<WarnOpinion> list = warnOpinionDao.findListByRequest(warnOpinionRequest);
        PageInfo<WarnOpinion> pageInfo = new PageInfo<WarnOpinion>(list);
        //封装结果
        QueryResult queryResult = new QueryResult();
        queryResult.setList(list);//数据列表
        queryResult.setTotal(pageInfo.getTotal());//数据总记录数
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS, queryResult);
        return queryResponseResult;

    }

    /**
     * 添加预警意见
     * @param warnOpinion
     * @return
     */
    @Transactional
    public WarnOpinionResult add(WarnOpinion warnOpinion) {
            WarnOpinion one = new WarnOpinion();
            one.setOpinionId(IdGen.uuid());
            one.setHospitalId(warnOpinion.getWarnTypeId());
            one.setWarnTypeId(warnOpinion.getWarnTypeId());
            one.setStep(warnOpinion.getStep());
            one.setOpinion(warnOpinion.getOpinion());
            one.setReason(warnOpinion.getReason());
            one.setCreateDate(new Date());
            int insert = warnOpinionDao.insert(one);
            if (insert > 0) {
                //返回成功
                return new WarnOpinionResult(CommonCode.SUCCESS, one);
            } else {
                //自定义异常处理
                ExceptionCast.cast(WarnOpinionCode.CMS_INSERT_FALSE);
            }
        //返回失败
        return new WarnOpinionResult(WarnOpinionCode.CMS_INSERT_FALSE, null);
    }

    /**
     * 通过id查询预警意见
     * @param id
     * @return
     */
    public WarnOpinionResult findById(String id) {
        if (warnOpinionDao.get(id) != null) {
            WarnOpinion warnOpinion = warnOpinionDao.get(id);
            //返回成功
            return new WarnOpinionResult(CommonCode.SUCCESS, warnOpinion);
        }
        //返回失败
        return new WarnOpinionResult(WarnOpinionCode.CMS_GET_ISNULL, null);
    }

	/**
	 * 通过id修改预警意见
	 * @param id
	 * @return
	 */
    @Transactional
	public WarnOpinionResult edit(String id, WarnOpinion warnOpinion) {
        if (warnOpinionDao.get(id) != null) {
            WarnOpinion one = warnOpinionDao.get(id);
            one.setHospitalId(warnOpinion.getWarnTypeId());
            one.setWarnTypeId(warnOpinion.getWarnTypeId());
            one.setStep(warnOpinion.getStep());
            one.setOpinion(warnOpinion.getOpinion());
            one.setReason(warnOpinion.getReason());
            int update = warnOpinionDao.update(one);
            if (update > 0) {
                //返回成功
                return new WarnOpinionResult(CommonCode.SUCCESS, one);
            } else {
                //自定义异常处理
                ExceptionCast.cast(WarnOpinionCode.CMS_UPDATE_FALSE);
            }
        }
        //返回失败
        return new WarnOpinionResult(WarnOpinionCode.CMS_GET_ISNULL, null);
	}

	/**
	 * 通过id删除预警意见
	 * @param id
	 * @return
	 */
    @Transactional
	public ResponseResult delete(String id) {
        if (warnOpinionDao.get(id) != null) {
            int delete = warnOpinionDao.delete(id);
            if (delete > 0) {
                //返回成功
                return new ResponseResult(CommonCode.SUCCESS);
            } else {
                //自定义异常处理
                ExceptionCast.cast(WarnOpinionCode.CMS_DELETE_FALSE);
            }
        }
        //返回失败
        return new WarnOpinionResult(WarnOpinionCode.CMS_GET_ISNULL, null);
	}

}