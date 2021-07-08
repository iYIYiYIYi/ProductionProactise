package com.sram.buct_production_practice.dao;

import com.sram.buct_production_practice.entity.GraphInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface GraphInfoDao {
    int deleteByPrimaryKey(String equipmentuuid);

    int insert(GraphInfo record);

    int insertSelective(GraphInfo record);

    GraphInfo selectByPrimaryKey(String equipmentuuid);

    int updateByPrimaryKeySelective(GraphInfo record);

    int updateByPrimaryKey(GraphInfo record);
}