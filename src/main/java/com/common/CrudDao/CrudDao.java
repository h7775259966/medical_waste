package com.common.CrudDao;

import com.module.entity.notice.Notice;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * DAO支持类实现
 * Created by Zhouxin on 2020/8/24;
 */
public interface CrudDao<T> {

    /**
     * 获取单条数据
     * @param id
     * @return
     */
    public T get(String id);

    /**
     * 根据名称查询
     * @param value
     * @return
     */
    public T getByName(String value);

    /**
     * 查询所有数据
     * @param
     * @return
     */
    public List<T> findList();


    /**
     * 插入数据
     * @param entity
     * @return
     */
    public int insert(T entity);

    /**
     * 更新数据
     * @param entity
     * @return
     */
    public int update(T entity);

    /**
     * 删除数据（物理删除，从数据库中彻底删除）
     * @param id
     * @return
     */
    public int delete(String id);

    /**
     * 删除数据（逻辑删除，更新del_flag字段为1,在表包含字段del_flag时，可以调用此方法，将数据隐藏）
     * @param id
     * @see public int delete(T entity)
     * @return
     */
    public int deleteByLogic(String id);

}
