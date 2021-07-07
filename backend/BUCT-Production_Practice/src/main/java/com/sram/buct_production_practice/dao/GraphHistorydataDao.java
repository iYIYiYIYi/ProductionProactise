package com.sram.buct_production_practice.dao;

import com.sram.buct_production_practice.entity.GraphHistorydata;

public interface GraphHistorydataDao {
    int deleteByPrimaryKey(Integer equipmentuuid);

    int insert(GraphHistorydata record);

    int insertSelective(GraphHistorydata record);

    GraphHistorydata selectByPrimaryKey(Integer equipmentuuid);

    int updateByPrimaryKeySelective(GraphHistorydata record);

    int updateByPrimaryKey(GraphHistorydata record);
}