package com.sram.buct_production_practice.dao;

import com.sram.buct_production_practice.entity.TrendRealTime;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrendRealTimeDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TrendRealTime record);

    int insertSelective(TrendRealTime record);

    TrendRealTime selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TrendRealTime record);

    int updateByPrimaryKey(TrendRealTime record);

    TrendRealTime selectByEquAndPoint(String equipmentUuid, String pointIdString);
}