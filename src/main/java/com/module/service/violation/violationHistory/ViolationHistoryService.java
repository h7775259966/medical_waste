package com.module.service.violation.violationHistory;

import com.common.Response.CommonCode;
import com.common.Response.QueryResponseResult;
import com.common.Response.QueryResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.module.dao.violation.violationHistory.ViolationHistoryDao;
import com.module.entity.violation.violationExamine.ViolationExamine;
import com.common.Request.violation.violationHistory.ViolationHistoryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 * 违规历史
 * Created by huangbotao on 2020/9/21;
 */

@Service
@Transactional(readOnly = true)
public class ViolationHistoryService {

    @Autowired
    private ViolationHistoryDao violationHistoryDao;

    public QueryResponseResult findList(int page, int size, ViolationHistoryRequest violationHistoryRequest) {
        //为防止后面报空指针，先进行查询条件的非空判断
        if (violationHistoryRequest == null) {
            violationHistoryRequest = new ViolationHistoryRequest();
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
        //注意：如果violationHistoryRequest内参数不为空，则进行带值查询
        //violationHistoryDao.findList()为没有任何查询条件的分页查询
        List<ViolationExamine> list = violationHistoryDao.findList();
        PageInfo<ViolationExamine> pageInfo = new PageInfo<ViolationExamine>(list);

        /*System.out.println("总数量：" + pageInfo.getTotal());
        System.out.println("当前页查询记录：" + pageInfo.getList().size());
        System.out.println("当前页码：" + pageInfo.getPageNum());
        System.out.println("每页显示数量：" + pageInfo.getPageSize());
        System.out.println("总页：" + pageInfo.getPages());*/

        //封装结果
        QueryResult queryResult = new QueryResult();
        queryResult.setList(list);//数据列表
        queryResult.setTotal(pageInfo.getTotal());//数据总记录数
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS, queryResult);
        return queryResponseResult;

    }

}
