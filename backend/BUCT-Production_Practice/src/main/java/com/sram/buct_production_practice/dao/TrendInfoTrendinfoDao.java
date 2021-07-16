package com.sram.buct_production_practice.dao;

import com.sram.buct_production_practice.entity.TrendInfoTrendinfo;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface TrendInfoTrendinfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TrendInfoTrendinfo record);

    int insertSelective(TrendInfoTrendinfo record);

    TrendInfoTrendinfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TrendInfoTrendinfo record);

    int updateByPrimaryKey(TrendInfoTrendinfo record);

    TrendInfoTrendinfo selectByEquAndPointAndTime(String equipmentUuid, String pointIdString, BigInteger trendTime);

    List<TrendInfoTrendinfo> selectAll(String equipmentUuid, String pointIdString, BigInteger trendTime);
}