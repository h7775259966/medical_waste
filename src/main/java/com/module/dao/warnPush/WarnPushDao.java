package com.module.dao.warnPush;

import com.common.CrudDao.CrudDao;
import com.module.entity.trashType.TrashType;
import com.module.entity.warnPush.WarnPush;
import com.module.request.warnPush.WarnPushRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.poi.ss.formula.functions.T;

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