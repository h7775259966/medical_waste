package com.module.service.custom;

import com.common.Response.CommonCode;
import com.common.Response.QueryResponseResult;
import com.common.Response.QueryResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.module.dao.custom.CustomDao;
import com.module.entity.custom.Custom;
import com.module.entity.trash.trashCollect.TrashCollect;
import com.module.entity.warn.warnType.WarnType;
import com.common.Request.custom.CustomRequest;
import com.common.Request.custom.CustomWarnRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 * 自定义查询
 * Created by huangbotao on 2020/9/21;
 */
@Service
@Transactional(readOnly = true)
public class CustomService {

    @Autowired
    private CustomDao customDao;


    /**
     *
     * @param page
     * @param size
     * @param customRequest
     * @return 查询重量
     */
    public QueryResponseResult customFind(int page, int size, CustomRequest customRequest) {
        //为防止后面报空指针，先进行查询条件的非空判断
        if (customRequest == null) {
            customRequest = new CustomRequest();
        }
        //分页参数处理
        if (page <= 0) {
            page = 1;
        }
        if (size <= 0) {
            size = 10;
        }
        //分页处理
        PageHelper.startPage(page, size);

        List<Custom> list = customDao.customFind(customRequest);
        PageInfo<Custom> pageInfo = new PageInfo<Custom>(list);


        //封装结果
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
     * @param customWarnRequest
     * @return 自定义查询预警
     */

    public QueryResponseResult customWarn(int page, int size, CustomWarnRequest customWarnRequest) {
        //为防止后面报空指针，先进行查询条件的非空判断
        if (customWarnRequest == null) {
            customWarnRequest = new CustomWarnRequest();
        }
        //分页参数处理
        if (page <= 0) {
            page = 1;
        }
        if (size <= 0) {
            size = 10;
        }
        //分页处理
        PageHelper.startPage(page, size);

        List<WarnType> list = customDao.customWarn(customWarnRequest);
        PageInfo<WarnType> pageInfo = new PageInfo<>(list);



        //封装结果
        QueryResult queryResult = new QueryResult();
        queryResult.setList(list);//数据列表
        queryResult.setTotal(pageInfo.getTotal());//数据总记录数
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS, queryResult);
        return queryResponseResult;

    }

}
