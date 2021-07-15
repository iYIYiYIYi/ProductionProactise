package com.sram.buct_production_practice.dao;

import com.sram.buct_production_practice.entity.TrendInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface TrendInfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TrendInfo record);

    int insertSelective(TrendInfo record);

    TrendInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TrendInfo record);

    int updateByPrimaryKey(TrendInfo record);

    TrendInfo selectByEquipmentAndPoint(String equipmentUuid, String pointIdString);
}