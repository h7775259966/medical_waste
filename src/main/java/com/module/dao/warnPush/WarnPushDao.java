package com.module.dao.warnPush;

import com.common.CrudDao.CrudDao;
import com.module.entity.trashType.TrashType;
import com.module.entity.warnPush.WarnPush;
import org.apache.ibatis.annotations.Mapper;


/**
 * 预警推送DAO接口
 * @author zx
 * @version 2020-08-26
 */
@Mapper
public interface WarnPushDao extends CrudDao<WarnPush>{

}