package com.module.dao.relevance;

import com.common.CrudDao.CrudDao;
import com.common.Request.relavance.RelavanceRequest;
import com.module.entity.hospital.province.ProvinceList;
import com.module.entity.trash.trashCollect.TrashCollect;
import org.apache.ibatis.annotations.Mapper;
import org.apache.poi.ss.formula.functions.T;

import java.util.List;

/**
 * Created by huangbotao on 2020/9/28;
 */

@Mapper
public interface RelevanceDao extends CrudDao<T> {


    public List<ProvinceList> findRelavance(RelavanceRequest relavanceRequest);

    public List<TrashCollect> findSum(RelavanceRequest relavanceRequest);

    public List<TrashCollect> findSumPackets(RelavanceRequest relavanceRequest);


}
