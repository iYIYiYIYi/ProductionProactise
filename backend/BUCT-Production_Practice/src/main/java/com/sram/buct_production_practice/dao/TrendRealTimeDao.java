package com.sram.buct_production_practice.dao;

import com.sram.buct_production_practice.entity.TrendRealTime;

public interface TrendRealTimeDao {
    int deleteByPrimaryKey(String equipmentuuid);

    int insert(TrendRealTime record);

    int insertSelective(TrendRealTime record);

    TrendRealTime selectByPrimaryKey(String equipmentuuid);

    int updateByPrimaryKeySelective(TrendRealTime record);

    int updateByPrimaryKey(TrendRealTime record);
}