package com.sram.buct_production_practice.dao;

import com.sram.buct_production_practice.entity.TrendSpectrumValue;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface TrendSpectrumValueDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TrendSpectrumValue record);

    int insertSelective(TrendSpectrumValue record);

    TrendSpectrumValue selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TrendSpectrumValue record);

    int updateByPrimaryKey(TrendSpectrumValue record);

    TrendSpectrumValue selectByEquAndPoint(String equipmentUuid, String pointIdString);

    TrendSpectrumValue selectByEquAndPointAndTime(String equipmentUuid, String pointIdString, BigInteger trendTime);
}