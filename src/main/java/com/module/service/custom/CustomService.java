package com.module.service.custom;

import com.common.Request.custom.CustomRequest;
import com.common.Request.custom.CustomWarnRequest;
import com.common.Response.CommonCode;
import com.common.Response.QueryResponseResult;
import com.common.Response.QueryResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.module.dao.custom.CustomDao;
import com.module.entity.custom.Custom;
import com.module.entity.warn.warnInWeight.WarnInWeight;
import com.module.entity.warn.warnLeakage.WarnLeakage;
import com.module.entity.warn.warnLose.WarnLose;
import com.module.entity.warn.warnNoOut.WarnNoOut;
import com.module.entity.warn.warnOutOvertime.WarnOutOvertime;
import com.module.entity.warn.warnOutWeight.WarnOutWeight;
import com.module.entity.warn.warnType.WarnType;
import com.module.entity.warn.warnViolation.WarnViolation;
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

    public QueryResponseResult customInWeight(int page, int size, CustomWarnRequest customWarnRequest) {
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

        List<WarnInWeight> list = customDao.customInWeight(customWarnRequest);
        PageInfo<WarnInWeight> pageInfo = new PageInfo<WarnInWeight>(list);



        //封装结果
        QueryResult queryResult = new QueryResult();
        queryResult.setList(list);//数据列表
        queryResult.setTotal(pageInfo.getTotal());//数据总记录数
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS, queryResult);
        return queryResponseResult;

    }

    public QueryResponseResult customLeakage(int page, int size, CustomWarnRequest customWarnRequest) {
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

        List<WarnLeakage> list = customDao.customLeakage(customWarnRequest);
        PageInfo<WarnLeakage> pageInfo = new PageInfo<WarnLeakage>(list);



        //封装结果
        QueryResult queryResult = new QueryResult();
        queryResult.setList(list);//数据列表
        queryResult.setTotal(pageInfo.getTotal());//数据总记录数
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS, queryResult);
        return queryResponseResult;

    }

    public QueryResponseResult customLose(int page, int size, CustomWarnRequest customWarnRequest) {
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

        List<WarnLose> list = customDao.customLose(customWarnRequest);
        PageInfo<WarnLose> pageInfo = new PageInfo<WarnLose>(list);



        //封装结果
        QueryResult queryResult = new QueryResult();
        queryResult.setList(list);//数据列表
        queryResult.setTotal(pageInfo.getTotal());//数据总记录数
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS, queryResult);
        return queryResponseResult;

    }

    public QueryResponseResult customNoOut(int page, int size, CustomWarnRequest customWarnRequest) {
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

        List<WarnNoOut> list = customDao.customNoOut(customWarnRequest);
        PageInfo<WarnNoOut> pageInfo = new PageInfo<WarnNoOut>(list);



        //封装结果
        QueryResult queryResult = new QueryResult();
        queryResult.setList(list);//数据列表
        queryResult.setTotal(pageInfo.getTotal());//数据总记录数
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS, queryResult);
        return queryResponseResult;

    }

    public QueryResponseResult customOutOvertime(int page, int size, CustomWarnRequest customWarnRequest) {
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

        List<WarnOutOvertime> list = customDao.customOutOvertime(customWarnRequest);
        PageInfo<WarnOutOvertime> pageInfo = new PageInfo<WarnOutOvertime>(list);



        //封装结果
        QueryResult queryResult = new QueryResult();
        queryResult.setList(list);//数据列表
        queryResult.setTotal(pageInfo.getTotal());//数据总记录数
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS, queryResult);
        return queryResponseResult;

    }


    public QueryResponseResult customOutWeight(int page, int size, CustomWarnRequest customWarnRequest) {
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

        List<WarnOutWeight> list = customDao.customOutWeight(customWarnRequest);
        PageInfo<WarnOutWeight> pageInfo = new PageInfo<WarnOutWeight>(list);



        //封装结果
        QueryResult queryResult = new QueryResult();
        queryResult.setList(list);//数据列表
        queryResult.setTotal(pageInfo.getTotal());//数据总记录数
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS, queryResult);
        return queryResponseResult;

    }

    public QueryResponseResult customViolation(int page, int size, CustomWarnRequest customWarnRequest) {
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

        List<WarnViolation> list = customDao.customViolation(customWarnRequest);
        PageInfo<WarnViolation> pageInfo = new PageInfo<WarnViolation>(list);



        //封装结果
        QueryResult queryResult = new QueryResult();
        queryResult.setList(list);//数据列表
        queryResult.setTotal(pageInfo.getTotal());//数据总记录数
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS, queryResult);
        return queryResponseResult;

    }


}
