package com.sram.buct_production_practice.dao;

import com.sram.buct_production_practice.entity.TrendWaveValue;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface TrendWaveValueDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TrendWaveValue record);

    int insertSelective(TrendWaveValue record);

    TrendWaveValue selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TrendWaveValue record);

    int updateByPrimaryKey(TrendWaveValue record);

    TrendWaveValue selectByEquAndPoint(String equipmentUuid, String pointIdString);

    TrendWaveValue selectByEquAndPointAndTime(String equipmentUuid, String pointIdString, BigInteger trendTime);
}