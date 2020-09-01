package com.module.dao.warn.warnPush;

import com.common.CrudDao.CrudDao;
import com.module.entity.warn.warnPush.WarnPush;
import com.module.request.warn.warnPush.WarnPushRequest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * 预警推送DAO接口
 * @author zx
 * @version 2020-08-26
 */
@Mapper
public interface WarnPushDao extends CrudDao<WarnPush>{

    /**
     * 通过查询条件查询所有数据
     * @param warnPushRequest
     * @return
     */
    public List<WarnPush> findListByRequest(WarnPushRequest warnPushRequest);

}