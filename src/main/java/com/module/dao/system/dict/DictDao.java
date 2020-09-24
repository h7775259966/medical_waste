package com.module.dao.system.dict;

import com.common.CrudDao.CrudDao;
import com.module.entity.system.dict.Dict;
import com.common.Request.system.dict.DictRequest;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;


/**
 * 系统字典DAO接口
 * @author zx
 * @version 2020-09-17
 */
@Mapper
public interface DictDao extends CrudDao<Dict>{
    /**
     * 通过查询条件查询所有数据
     * @param dictRequest
     * @returno
     */
    public List<Dict> findListByRequest(DictRequest dictRequest);

    /**
     * 通过字典api查询所有字典数据
     * @param dictApi
     * @returno
     */
    public List<Dict> findByDictApi(String dictApi);
}