package com.module.dao.notice;

import com.common.CrudDao.CrudDao;
import com.common.Request.notice.NoticeRequest;
import com.module.entity.notice.Notice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface NoticeDao extends CrudDao<Notice> {

    /**
     * 通过查询条件查询所有数据
     * @param noticeRequest
     * @returno
     */
    public List<Notice> findListByRequest(NoticeRequest noticeRequest);



    /**
     *  通过id修改发布状态
     * @param notice
     * @return
     */
    public int editStatus(Notice notice);
}
