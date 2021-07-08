package com.sram.buct_production_practice.dao;

import com.sram.buct_production_practice.entity.GraphDataTime;
import org.springframework.stereotype.Repository;

@Repository
public interface GraphDataTimeDao {
    int deleteByPrimaryKey(String equipmentuuid);

    int insert(GraphDataTime record);

    int insertSelective(GraphDataTime record);

    GraphDataTime selectByPrimaryKey(String equipmentuuid);

    int updateByPrimaryKeySelective(GraphDataTime record);

    int updateByPrimaryKey(GraphDataTime record);
}