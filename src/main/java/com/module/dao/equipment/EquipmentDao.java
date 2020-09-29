package com.module.dao.equipment;

import com.common.CrudDao.CrudDao;
import com.common.Request.equipment.EquipmentRequest;
import com.module.entity.equipment.Equipment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EquipmentDao extends CrudDao<Equipment> {

    /**
     * 通过查询条件查询所有数据
     * @param equipmentRequest
     * @return
     */
    public List<Equipment> findListByRequest(EquipmentRequest equipmentRequest);
}
