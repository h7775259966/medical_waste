package com.module.service.trash.trashCollectHistory;

import com.common.Response.CommonCode;
import com.common.Response.QueryResponseResult;
import com.common.Response.QueryResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.module.dao.trash.trashCollectHistory.TrashCollectHistoryDao;
import com.module.entity.trash.trashCollectHistory.TrashCollectHistory;
import com.common.Request.trash.trashCollectHistory.TrashCollectHistoryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by huangbotao on 2020/9/22;
 */


@Service
@Transactional(readOnly = true)
public class TrashCollectHistoryService {

    @Autowired
    private TrashCollectHistoryDao trashCollectHistoryDao;


    public QueryResponseResult findHistory(int page, int size, TrashCollectHistoryRequest trashCollectHistoryRequest) {
        //为防止后面报空指针，先进行查询条件的非空判断
        if (trashCollectHistoryRequest == null) {
            trashCollectHistoryRequest = new TrashCollectHistoryRequest();
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
        List<TrashCollectHistory> list = trashCollectHistoryDao.findHistory(trashCollectHistoryRequest);
        PageInfo<TrashCollectHistory> pageInfo = new PageInfo<TrashCollectHistory>(list);
        

        //封装结果
        QueryResult queryResult = new QueryResult();
        queryResult.setList(list);//数据列表
        queryResult.setTotal(pageInfo.getTotal());//数据总记录数
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS, queryResult);
        return queryResponseResult;

    }

}
