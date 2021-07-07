package com.sram.buct_production_practice.dao;

import com.sram.buct_production_practice.entity.GraphData;

public interface GraphDataDao {
    int deleteByPrimaryKey(String equipmentuuid);

    int insert(GraphData record);

    int insertSelective(GraphData record);

    GraphData selectByPrimaryKey(String equipmentuuid);

    int updateByPrimaryKeySelective(GraphData record);

    int updateByPrimaryKey(GraphData record);
}