package com.module.service.relevance;

import com.common.Request.relavance.RelavanceRequest;
import com.common.Response.CommonCode;
import com.common.Response.QueryResponseResult;
import com.common.Response.QueryResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.module.dao.relevance.RelevanceDao;
import com.module.entity.hospital.province.ProvinceList;
import com.module.entity.trash.trashCollect.TrashCollect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 医院医废分级统计重量和包数
 * Created by huangbotao on 2020/9/28;
 */

@Service
@Transactional(readOnly = true)
public class RelavanceService {

    @Autowired
    private RelevanceDao relevanceDao;


    /**
     * 医废分级统计
     * @param page
     * @param size
     * @param relavanceRequest
     * @return
     */
    public QueryResponseResult findRelavance(int page, int size, RelavanceRequest relavanceRequest) {
        //为防止后面报空指针，先进行查询条件的非空判断
        if (relavanceRequest == null) {
            relavanceRequest = new RelavanceRequest();
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
        List<ProvinceList> list = relevanceDao.findRelavance(relavanceRequest);
        PageInfo<ProvinceList> pageInfo = new PageInfo<ProvinceList>(list);
        QueryResult queryResult = new QueryResult();
        queryResult.setList(list);//数据列表
        queryResult.setTotal(pageInfo.getTotal());//数据总记录数
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS, queryResult);
        return queryResponseResult;

    }


    /**
     *
     * @param page
     * @param size
     * @param relavanceRequest
     * @return
     * 医废分级统计医院医废重量
     */
    public QueryResponseResult findSum(int page, int size, RelavanceRequest relavanceRequest) {
        //为防止后面报空指针，先进行查询条件的非空判断
        if (relavanceRequest == null) {
            relavanceRequest = new RelavanceRequest();
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
        List<TrashCollect> list = relevanceDao.findSum(relavanceRequest);
        PageInfo<TrashCollect> pageInfo = new PageInfo<TrashCollect>(list);
        QueryResult queryResult = new QueryResult();
        queryResult.setList(list);//数据列表
        queryResult.setTotal(pageInfo.getTotal());//数据总记录数
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS, queryResult);
        return queryResponseResult;

    }

    /**
     *
     * @param page
     * @param size
     * @param relavanceRequest
     * @return
     * 医废分级统计医院医废包数
     */

    public QueryResponseResult findSumPackets(int page, int size, RelavanceRequest relavanceRequest) {
        //为防止后面报空指针，先进行查询条件的非空判断
        if (relavanceRequest == null) {
            relavanceRequest = new RelavanceRequest();
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
        List<TrashCollect> list = relevanceDao.findSumPackets(relavanceRequest);
        PageInfo<TrashCollect> pageInfo = new PageInfo<TrashCollect>(list);
        QueryResult queryResult = new QueryResult();
        queryResult.setList(list);//数据列表
        queryResult.setTotal(pageInfo.getTotal());//数据总记录数
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS, queryResult);
        return queryResponseResult;

    }

}
