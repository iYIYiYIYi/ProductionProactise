package com.sram.buct_production_practice.dao;

import com.sram.buct_production_practice.entity.GraphDataEquipmentname;
import org.springframework.stereotype.Repository;

@Repository
public interface GraphDataEquipmentnameDao {
    int deleteByPrimaryKey(String equipmentuuid);

    int insert(GraphDataEquipmentname record);

    int insertSelective(GraphDataEquipmentname record);

    GraphDataEquipmentname selectByPrimaryKey(String equipmentuuid);

    int updateByPrimaryKeySelective(GraphDataEquipmentname record);

    int updateByPrimaryKey(GraphDataEquipmentname record);
}