package com.module.service.warn.warnRecord;

import com.common.Response.CommonCode;
import com.common.Response.QueryResponseResult;
import com.common.Response.QueryResult;
import com.common.Response.ResponseResult;
import com.common.Utils.IdGen;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.module.config.exception.ExceptionCast;
import com.module.dao.warn.warnRecord.WarnRecordDao;
import com.module.entity.warn.warnRecord.WarnRecord;
import com.module.request.warn.warnRecord.WarnRecordRequest;
import com.module.response.warn.warnRecord.WarnRecordCode;
import com.module.response.warn.warnRecord.WarnRecordResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 预警记录Service
 * @author zx
 * @version 2020-08-24
 */
@Service
@Transactional(readOnly = true)
public class WarnRecordService {

	@Autowired
	private WarnRecordDao warnRecordDao;

    public QueryResponseResult findList(int page, int size, WarnRecordRequest warnRecordRequest) {
        //为防止后面报空指针，先进行查询条件的非空判断
        if (warnRecordRequest == null) {
            warnRecordRequest = new WarnRecordRequest();
        }
        //分页参数处理
        if (page <= 0) {
            page = 1;
        }
        page = page - 1;
        if (size <= 0) {
            size = 10;
        }
        //分页处理
        PageHelper.startPage(page,size);
        //注意：如果warnRecordRequest内参数不为空，则进行带值查询
        //warnRecordDao.findList()为没有任何查询条件的分页查询
        List<WarnRecord> list = warnRecordDao.findList();
        PageInfo<WarnRecord> pageInfo = new PageInfo<WarnRecord>(list);

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

    /**
     * 添加预警记录
     * @param warnRecord
     * @return
     */
    @Transactional
    public WarnRecordResult add(WarnRecord warnRecord) {
            WarnRecord one = new WarnRecord();
            one.setWarnRecordId(IdGen.uuid());
            one.setCode(warnRecord.getCode());
            one.setWarnPlace(warnRecord.getWarnPlace());
            one.setWarnContent(warnRecord.getWarnContent());
            one.setWarnTypeId(warnRecord.getWarnTypeId());
            one.setWarnTime(warnRecord.getWarnTime());
            one.setRemarks(warnRecord.getRemarks());
            one.setCreateDate(new Date());
            int insert = warnRecordDao.insert(one);
            if (insert > 0) {
                //返回成功
                return new WarnRecordResult(CommonCode.SUCCESS, one);
            } else {
                //自定义异常处理
                ExceptionCast.cast(WarnRecordCode.CMS_INSERT_FALSE);
            }
        //返回失败
        return new WarnRecordResult(WarnRecordCode.CMS_NAME_REPETITION, null);
    }

    /**
     * 通过ID查询预警记录
     * @param id
     * @return
     */
    public WarnRecordResult findById(String id) {
        if (warnRecordDao.get(id) != null) {
            WarnRecord warnRecord = warnRecordDao.get(id);
            //返回成功
            return new WarnRecordResult(CommonCode.SUCCESS, warnRecord);
        }
        //返回失败
        return new WarnRecordResult(WarnRecordCode.CMS_GET_ISNULL, null);
    }

	/**
	 * 通过id修改预警记录
	 * @param id
	 * @return
	 */
    @Transactional
	public WarnRecordResult edit(String id, WarnRecord warnRecord) {
        if (warnRecordDao.get(id) != null) {
            WarnRecord one = warnRecordDao.get(id);
            one.setCode(warnRecord.getCode());
            one.setWarnPlace(warnRecord.getWarnPlace());
            one.setWarnContent(warnRecord.getWarnContent());
            one.setWarnTypeId(warnRecord.getWarnTypeId());
            one.setWarnTime(warnRecord.getWarnTime());
            one.setRemarks(warnRecord.getRemarks());
            int update = warnRecordDao.update(one);
            if (update > 0) {
                //返回成功
                return new WarnRecordResult(CommonCode.SUCCESS, one);
            } else {
                //自定义异常处理
                ExceptionCast.cast(WarnRecordCode.CMS_UPDATE_FALSE);
            }
        }
        //返回失败
        return new WarnRecordResult(WarnRecordCode.CMS_GET_ISNULL, null);
	}

	/**
	 * 通过id删除预警记录
	 * @param id
	 * @return
	 */
    @Transactional
	public ResponseResult delete(String id) {
        if (warnRecordDao.get(id) != null) {
            int delete = warnRecordDao.delete(id);
            if (delete > 0) {
                //返回成功
                return new ResponseResult(CommonCode.SUCCESS);
            } else {
                //自定义异常处理
                ExceptionCast.cast(WarnRecordCode.CMS_DELETE_FALSE);
            }
        }
        //返回失败
        return new WarnRecordResult(WarnRecordCode.CMS_GET_ISNULL, null);
	}

}