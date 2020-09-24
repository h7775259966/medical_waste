package com.module.dao.equipment;

import com.common.CrudDao.CrudDao;
import com.module.entity.equipment.Equipment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EquipmentDao extends CrudDao<Equipment> {


}
