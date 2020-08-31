package com.module.service.warnPush;

import com.common.Response.CommonCode;
import com.common.Response.QueryResponseResult;
import com.common.Response.QueryResult;
import com.common.Response.ResponseResult;
import com.common.Utils.IdGen;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.module.config.exception.ExceptionCast;
import com.module.dao.warnPush.WarnPushDao;
import com.module.entity.warnPush.WarnPush;
import com.module.request.warnPush.WarnPushRequest;
import com.module.response.warnPush.WarnPushCode;
import com.module.response.warnPush.WarnPushResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 预警推送Service
 * @author zx
 * @version 2020-08-24
 */
@Service
@Transactional(readOnly = true)
public class WarnPushService {

	@Autowired
	private WarnPushDao warnPushDao;

    public QueryResponseResult findList(int page, int size, WarnPushRequest warnPushRequest) {
        //为防止后面报空指针，先进行查询条件的非空判断
        if (warnPushRequest == null) {
            warnPushRequest = new WarnPushRequest();
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
        List<WarnPush> list = warnPushDao.findListByRequest(warnPushRequest);
        PageInfo<WarnPush> pageInfo = new PageInfo<WarnPush>(list);
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
     * 添加预警推送
     * @param warnPush
     * @return
     */
    @Transactional
    public WarnPushResult add(WarnPush warnPush) {
            WarnPush one = new WarnPush();
            one.setPushId(IdGen.uuid());
            one.setPushTime(warnPush.getPushTime());
            one.setWarnTypeId(warnPush.getWarnTypeId());
            one.setWarnContent(warnPush.getWarnContent());
            one.setPushUrl(warnPush.getPushUrl());
            one.setRemarks(warnPush.getRemarks());
            one.setCreateDate(new Date());
            int insert = warnPushDao.insert(one);
            if (insert > 0) {
                //返回成功
                return new WarnPushResult(CommonCode.SUCCESS, one);
            } else {
                //自定义异常处理
                ExceptionCast.cast(WarnPushCode.CMS_INSERT_FALSE);
            }
        //返回失败
        return new WarnPushResult(WarnPushCode.CMS_INSERT_FALSE, null);
    }

    /**
     * 通过ID查询预警推送
     * @param id
     * @return
     */
    public WarnPushResult findById(String id) {
        if (warnPushDao.get(id) != null) {
            WarnPush warnPush = warnPushDao.get(id);
            //返回成功
            return new WarnPushResult(CommonCode.SUCCESS, warnPush);
        }
        //返回失败
        return new WarnPushResult(WarnPushCode.CMS_GET_ISNULL, null);
    }

	/**
	 * 通过id修改预警推送
	 * @param id
	 * @return
	 */
    @Transactional
	public WarnPushResult edit(String id, WarnPush warnPush) {
        if (warnPushDao.get(id) != null) {
            WarnPush one = warnPushDao.get(id);
            one.setPushTime(warnPush.getPushTime());
            one.setWarnTypeId(warnPush.getWarnTypeId());
            one.setWarnContent(warnPush.getWarnContent());
            one.setPushUrl(warnPush.getPushUrl());
            one.setRemarks(warnPush.getRemarks());
            int update = warnPushDao.update(one);
            if (update > 0) {
                //返回成功
                return new WarnPushResult(CommonCode.SUCCESS, one);
            } else {
                //自定义异常处理
                ExceptionCast.cast(WarnPushCode.CMS_UPDATE_FALSE);
            }
        }
        //返回失败
        return new WarnPushResult(WarnPushCode.CMS_GET_ISNULL, null);
	}

	/**
	 * 通过id删除预警推送
	 * @param id
	 * @return
	 */
    @Transactional
	public ResponseResult delete(String id) {
        if (warnPushDao.get(id) != null) {
            int delete = warnPushDao.delete(id);
            if (delete > 0) {
                //返回成功
                return new ResponseResult(CommonCode.SUCCESS);
            } else {
                //自定义异常处理
                ExceptionCast.cast(WarnPushCode.CMS_DELETE_FALSE);
            }
        }
        //返回失败
        return new WarnPushResult(WarnPushCode.CMS_GET_ISNULL, null);
	}

}