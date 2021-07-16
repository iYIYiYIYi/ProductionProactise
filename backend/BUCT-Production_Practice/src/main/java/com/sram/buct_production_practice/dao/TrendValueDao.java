package com.sram.buct_production_practice.dao;

import com.sram.buct_production_practice.entity.TrendValue;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface TrendValueDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TrendValue record);

    int insertSelective(TrendValue record);

    TrendValue selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TrendValue record);

    int updateByPrimaryKey(TrendValue record);

    TrendValue selectByEquAndPoint(String equipmentUuid, String pointIdString);

    TrendValue selectByEquAndPointAndTime(String equipmentUuid, String pointIdString, BigInteger trendTime);

    List<TrendValue> selectBySection(String equipmentUuid, String pointIdString, BigInteger startTime,BigInteger endTime );

}