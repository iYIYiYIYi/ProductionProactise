package com.sram.buct_production_practice.dao;

import com.sram.buct_production_practice.entity.TrendValue;
import com.sram.buct_production_practice.entity.TrendWaveValue;
import org.springframework.stereotype.Repository;

@Repository
public interface TrendWaveValueDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TrendWaveValue record);

    int insertSelective(TrendWaveValue record);

    TrendWaveValue selectByPrimaryKey(Integer id);

    TrendWaveValue selectByEquAndPoint(String equipmentUuid, String pointIdString);

    int updateByPrimaryKeySelective(TrendWaveValue record);

    int updateByPrimaryKey(TrendWaveValue record);
}