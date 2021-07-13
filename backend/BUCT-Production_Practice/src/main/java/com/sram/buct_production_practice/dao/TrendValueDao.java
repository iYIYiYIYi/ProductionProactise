package com.sram.buct_production_practice.dao;

import com.sram.buct_production_practice.entity.TrendValue;
import org.springframework.stereotype.Repository;

@Repository
public interface TrendValueDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TrendValue record);

    int insertSelective(TrendValue record);

    TrendValue selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TrendValue record);

    int updateByPrimaryKey(TrendValue record);

    TrendValue selectByEquAndPoint(String equipmentUuid, String pointIdString);
}