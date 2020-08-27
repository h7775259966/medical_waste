package com.module.dao.notice;

import com.common.CrudDao.CrudDao;
import com.module.entity.notice.Notice;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NoticeDao extends CrudDao<Notice> {


}
