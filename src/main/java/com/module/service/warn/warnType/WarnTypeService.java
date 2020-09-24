package com.module.service.warn.warnType;

import com.common.Response.CommonCode;
import com.common.Response.QueryResponseResult;
import com.common.Response.QueryResult;
import com.common.Response.ResponseResult;
import com.common.Utils.IdGen;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.common.Exception.ExceptionCast;
import com.module.dao.warn.warnType.WarnTypeDao;
import com.module.entity.warn.warnType.WarnType;
import com.common.Request.warn.warnType.WarnTypeRequest;
import com.common.Response.warn.warnType.WarnTypeCode;
import com.common.Response.warn.warnType.WarnTypeResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 预警类型Service
 * @author zx
 * @version 2020-08-24
 */
@Service
@Transactional(readOnly = true)
public class WarnTypeService {

	@Autowired
	private WarnTypeDao warnTypeDao;

    public QueryResponseResult findList(int page, int size, WarnTypeRequest warnTypeRequest) {
        //为防止后面报空指针，先进行查询条件的非空判断
        if (warnTypeRequest == null) {
            warnTypeRequest = new WarnTypeRequest();
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
        //注意：如果warnTypeRequest内参数不为空，则进行带值查询
        //warnTypeDao.findList()为没有任何查询条件的分页查询
        List<WarnType> list = warnTypeDao.findList();
        PageInfo<WarnType> pageInfo = new PageInfo<WarnType>(list);

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
     * 添加预警类型
     * @param warnType
     * @return
     */
    @Transactional
    public WarnTypeResult add(WarnType warnType) {
        if (warnTypeDao.getByName(warnType.getWarnType()) == null) {
            WarnType one = new WarnType();
            one.setWarnTypeId(IdGen.uuid());
            one.setWarnType(warnType.getWarnType());
            one.setWarnContent(warnType.getWarnContent());
            one.setRemarks(warnType.getRemarks());
            one.setCreateDate(new Date());
            int insert = warnTypeDao.insert(one);
            if (insert > 0) {
                //返回成功
                return new WarnTypeResult(CommonCode.SUCCESS, one);
            } else {
                //自定义异常处理
                ExceptionCast.cast(WarnTypeCode.CMS_INSERT_FALSE);
            }
        }
        //返回失败
        return new WarnTypeResult(WarnTypeCode.CMS_NAME_REPETITION, null);
    }

    /**
     * 通过ID查询预警类型
     * @param id
     * @return
     */
    public WarnTypeResult findById(String id) {
        if (warnTypeDao.get(id) != null) {
            WarnType warnType = warnTypeDao.get(id);
            //返回成功
            return new WarnTypeResult(CommonCode.SUCCESS, warnType);
        }
        //返回失败
        return new WarnTypeResult(WarnTypeCode.CMS_GET_ISNULL, null);
    }

	/**
	 * 通过id修改预警类型
	 * @param id
	 * @return
	 */
    @Transactional
	public WarnTypeResult edit(String id, WarnType warnType) {
        if (warnTypeDao.get(id) != null) {
            WarnType one = warnTypeDao.get(id);
            one.setWarnType(warnType.getWarnType());
            one.setWarnContent(warnType.getWarnContent());
            one.setRemarks(warnType.getRemarks());
            int update = warnTypeDao.update(one);
            if (update > 0) {
                //返回成功
                return new WarnTypeResult(CommonCode.SUCCESS, one);
            } else {
                //自定义异常处理
                ExceptionCast.cast(WarnTypeCode.CMS_UPDATE_FALSE);
            }
        }
        //返回失败
        return new WarnTypeResult(WarnTypeCode.CMS_GET_ISNULL, null);
	}

	/**
	 * 通过id删除预警类型
	 * @param id
	 * @return
	 */
    @Transactional
	public ResponseResult delete(String id) {
        if (warnTypeDao.get(id) != null) {
            int delete = warnTypeDao.delete(id);
            if (delete > 0) {
                //返回成功
                return new ResponseResult(CommonCode.SUCCESS);
            } else {
                //自定义异常处理
                ExceptionCast.cast(WarnTypeCode.CMS_DELETE_FALSE);
            }
        }
        //返回失败
        return new WarnTypeResult(WarnTypeCode.CMS_GET_ISNULL, null);
	}

}