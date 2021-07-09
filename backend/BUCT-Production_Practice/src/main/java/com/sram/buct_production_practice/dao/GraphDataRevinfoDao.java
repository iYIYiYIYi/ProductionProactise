package com.sram.buct_production_practice.dao;

import com.sram.buct_production_practice.entity.GraphDataRevinfo;
import org.springframework.stereotype.Repository;

@Repository
public interface GraphDataRevinfoDao {
    int deleteByPrimaryKey(String equipmentuuid);

    int insert(GraphDataRevinfo record);

    int insertSelective(GraphDataRevinfo record);

    GraphDataRevinfo selectByPrimaryKey(String equipmentuuid);

    int updateByPrimaryKeySelective(GraphDataRevinfo record);

    int updateByPrimaryKey(GraphDataRevinfo record);
}