package com.module.dao.warn.warnOpinion;

import com.common.CrudDao.CrudDao;
import com.common.Request.warn.warnOpinion.WarnOpinionRequest;
import com.module.entity.warn.warnOpinion.WarnOpinion;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * 预警意见DAO接口
 * @author zx
 * @version 2020-08-26
 */
@Mapper
public interface WarnOpinionDao extends CrudDao<WarnOpinion>{

    /**
     * 通过查询条件查询所有数据
     * @param warnOpinionRequest
     * @return
     */
    public List<WarnOpinion> findListByRequest(WarnOpinionRequest warnOpinionRequest);

}