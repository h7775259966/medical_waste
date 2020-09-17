package com.module.service.system.dict;

import com.common.Response.CommonCode;
import com.common.Response.QueryResponseResult;
import com.common.Response.QueryResult;
import com.common.Response.ResponseResult;
import com.common.Utils.IdGen;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.module.config.exception.ExceptionCast;
import com.module.dao.system.dict.DictDao;
import com.module.entity.hospital.department.Department;
import com.module.entity.hospital.office.Office;
import com.module.entity.system.dict.Dict;
import com.module.request.system.dict.DictRequest;
import com.module.response.system.dict.DictCode;
import com.module.response.system.dict.DictResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
import java.util.List;

/**
 * 系统字典Service
 * @author zx
 * @version 2020-08-24
 */
@Service
@Transactional(readOnly = true)
public class DictService {

	@Autowired
	private DictDao dictDao;

    public QueryResponseResult findList(int page, int size, DictRequest dictRequest) {
        //为防止后面报空指针，先进行查询条件的非空判断
        if (dictRequest == null) {
            dictRequest = new DictRequest();
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
        List<Dict> list = dictDao.findListByRequest(dictRequest);
        PageInfo<Dict> pageInfo = new PageInfo<Dict>(list);
        //封装结果
        QueryResult queryResult = new QueryResult();
        queryResult.setList(list);//数据列表
        queryResult.setTotal(pageInfo.getTotal());//数据总记录数
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS, queryResult);
        return queryResponseResult;

    }

    /**
     * 添加系统字典
     * @param dict
     * @return
     */
    @Transactional
    public DictResult add(Dict dict) {
            Dict one = new Dict();
            one.setId(IdGen.uuid());
            one.setDictApi(dict.getDictApi());
            one.setDictLabel(dict.getDictLabel());
            one.setDictValue(dict.getDictValue());
            one.setRemarks(dict.getRemarks());
            one.setCreateDate(new Date());
            int insert = dictDao.insert(one);
            if (insert > 0) {
                //返回成功
                return new DictResult(CommonCode.SUCCESS, one);
            } else {
                //自定义异常处理
                ExceptionCast.cast(DictCode.CMS_INSERT_FALSE);
            }
        //返回失败
        return new DictResult(DictCode.CMS_NAME_REPETITION, null);
    }

    /**
     * 通过id查询系统字典
     * @param id
     * @return
     */
    public DictResult findById(String id) {
        if (dictDao.get(id) != null) {
            Dict dict = dictDao.get(id);
            //返回成功
            return new DictResult(CommonCode.SUCCESS, dict);
        }
        //返回失败
        return new DictResult(DictCode.CMS_GET_ISNULL, null);
    }

	/**
	 * 通过id修改系统字典
	 * @param id
	 * @return
	 */
    @Transactional
	public DictResult edit(String id, Dict dict) {
        if (dictDao.get(id) != null) {
            Dict one = dictDao.get(id);
            one.setDictApi(dict.getDictApi());
            one.setDictLabel(dict.getDictLabel());
            one.setDictValue(dict.getDictValue());
            one.setRemarks(dict.getRemarks());
            int update = dictDao.update(one);
            if (update > 0) {
                //返回成功
                return new DictResult(CommonCode.SUCCESS, one);
            } else {
                //自定义异常处理
                ExceptionCast.cast(DictCode.CMS_UPDATE_FALSE);
            }
        }
        //返回失败
        return new DictResult(DictCode.CMS_GET_ISNULL, null);
	}

	/**
	 * 通过id删除系统字典
	 * @param id
	 * @return
	 */
    @Transactional
	public ResponseResult delete(String id) {
        if (dictDao.get(id) != null) {
            int delete = dictDao.delete(id);
            if (delete > 0) {
                //返回成功
                return new ResponseResult(CommonCode.SUCCESS);
            } else {
                //自定义异常处理
                ExceptionCast.cast(DictCode.CMS_DELETE_FALSE);
            }
        }
        //返回失败
        return new DictResult(DictCode.CMS_GET_ISNULL, null);
	}

    /**
     * 通过字典api查询所有字典数据
     * @return
     */
    public QueryResponseResult findByDictApi(String dictApi) {
        List<Dict> list = dictDao.findByDictApi(dictApi);
        PageInfo<Dict> pageInfo = new PageInfo<Dict>(list);
        QueryResult queryResult = new QueryResult();
        queryResult.setList(list);//数据列表
        queryResult.setTotal(pageInfo.getTotal());//数据总记录数
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS, queryResult);
        return queryResponseResult;
    }
}