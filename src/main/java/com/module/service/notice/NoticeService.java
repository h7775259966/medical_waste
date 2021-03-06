package com.module.service.notice;
import com.common.Response.CommonCode;
import com.common.Response.QueryResponseResult;
import com.common.Response.QueryResult;
import com.common.Response.ResponseResult;
import com.common.Utils.IdGen;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.common.Exception.ExceptionCast;
import com.module.dao.notice.NoticeDao;
import com.module.entity.notice.Notice;
import com.common.Request.notice.NoticeRequest;
import com.common.Response.notice.NoticeCode;
import com.common.Response.notice.NoticeResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


/**
 * 公告Service
 * @author hbt
 * @version 2020-09-03
 */

@Service
@Transactional(readOnly = true)
public class NoticeService {

    @Autowired
    private NoticeDao noticeDao;


    public QueryResponseResult findList(int page, int size, NoticeRequest noticeRequest) {
        //为防止后面报空指针，先进行查询条件的非空判断
        if (noticeRequest == null) {
            System.out.println("noticeRequest == null");
            noticeRequest = new NoticeRequest();
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
        List<Notice> list = noticeDao.findListByRequest(noticeRequest);
        PageInfo<Notice> pageInfo = new PageInfo<Notice>(list);

        //封装结果
        QueryResult queryResult = new QueryResult();
        queryResult.setList(list);//数据列表
        queryResult.setTotal(pageInfo.getTotal());//数据总记录数
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS, queryResult);
        return queryResponseResult;

    }

    /**
     * 添加公告
     * @param notice
     * @return
     */
    @Transactional
    public NoticeResult add(Notice notice) {
        if (noticeDao.getByName(notice.getHeadline()) == null) {
            Notice one = new Notice();
            one.setNoticeWriteId(IdGen.uuid());
            one.setHeadline(notice.getHeadline());
            one.setIssuer(notice.getIssuer());
            one.setWriter(notice.getWriter());
            one.setContent(notice.getContent());
            one.setUnit(notice.getUnit());
            one.setStatus(1); //发布状态 1为未发布,2为已发布
            one.setPicture(notice.getPicture());
            one.setCreateDate(new Date());
            int insert = noticeDao.insert(one);
            if (insert > 0) {
                //返回成功
                return new NoticeResult(CommonCode.SUCCESS, one);
            } else {
                //自定义异常处理
                ExceptionCast.cast(NoticeCode.CMS_INSERT_FALSE);
            }
        }
        //返回失败
        return new NoticeResult(NoticeCode.CMS_NAME_REPETITION, null);
    }

    /**
     * 通过ID查询公告
     * @param id
     * @return
     */
    @Transactional
    public NoticeResult findById(String id) {
        if (noticeDao.get(id) != null) {
            Notice notice = noticeDao.get(id);
            //返回成功
            return new NoticeResult(CommonCode.SUCCESS, notice);
        }
        //返回失败
        return new NoticeResult(NoticeCode.CMS_GET_ISNULL, null);
    }

    /**
     * 通过id修改公告
     * @param id
     * @return
     */
    @Transactional
    public NoticeResult edit(String id, Notice notice) {
        if (noticeDao.get(id) != null) {
            Notice one = noticeDao.get(id);
            one.setHeadline(notice.getHeadline());
            one.setIssuer(notice.getIssuer());
            one.setWriter(notice.getWriter());
            one.setContent(notice.getContent());
            one.setUnit(notice.getUnit());
            //one.setWriteTime(notice.getWriteTime());
            //one.setStatus(notice.getStatus());
            one.setPicture(notice.getPicture());
            int update = noticeDao.update(one);
            if (update > 0) {
                //返回成功
                return new NoticeResult(CommonCode.SUCCESS, one);
            } else {
                //自定义异常处理
                ExceptionCast.cast(NoticeCode.CMS_UPDATE_FALSE);
            }
        }
        //返回失败
        return new NoticeResult(NoticeCode.CMS_GET_ISNULL, null);
    }

    /**
     * 通过id删除公告
     * @param id
     * @return
     */
    @Transactional
    public ResponseResult delete(String id) {
        if (noticeDao.get(id) != null) {
            int delete = noticeDao.delete(id);
            if (delete > 0) {
                //返回成功
                return new ResponseResult(CommonCode.SUCCESS);
            } else {
                //自定义异常处理
                ExceptionCast.cast(NoticeCode.CMS_DELETE_FALSE);
            }
        }
        //返回失败
        return new NoticeResult(NoticeCode.CMS_GET_ISNULL, null);
    }

    /**
     * 通过id修改发布状态
     * @param id
     * @return
     */
    @Transactional
    public NoticeResult editStatus(String id,Integer status) {
        if (noticeDao.get(id) != null && status != null) {
            Notice one = noticeDao.get(id);
            one.setStatus(status);
            if(status==2){//发布状态 1为未发布,2为已发布
                one.setWriteTime(new Date());
            }
            if(status==1){
                one.setWriteTime(null);
            }
            int update = noticeDao.editStatus(one);
            if (update > 0) {
                //返回成功
                return new NoticeResult(CommonCode.SUCCESS, one);
            } else {
                //自定义异常处理
                ExceptionCast.cast(NoticeCode.CMS_EDITSTATUS_FALSE);
            }
        }
        //返回失败
        return new NoticeResult(NoticeCode.CMS_GET_ISNULL, null);
    }

}
