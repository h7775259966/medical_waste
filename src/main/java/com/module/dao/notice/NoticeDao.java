package com.module.dao.notice;

import com.common.CrudDao.CrudDao;
import com.module.entity.notice.Notice;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface NoticeDao extends CrudDao<Notice> {

    /**
     *  通过id修改发布状态
     * @param notice
     * @return
     */
    public int editStatus(Notice notice);
}
