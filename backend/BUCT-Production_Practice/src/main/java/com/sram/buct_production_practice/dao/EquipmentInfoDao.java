package com.sram.buct_production_practice.dao;

import com.sram.buct_production_practice.entity.EquipmentInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipmentInfoDao {
    int deleteByPrimaryKey(String equipmentuuid);

    int insert(EquipmentInfo record);

    int insertSelective(EquipmentInfo record);

    EquipmentInfo selectByPrimaryKey(String equipmentuuid);

    int updateByPrimaryKeySelective(EquipmentInfo record);

    int updateByPrimaryKey(EquipmentInfo record);

    List<EquipmentInfo> selectByNodeID(String nodeId);

    List<EquipmentInfo> selectAll();
}