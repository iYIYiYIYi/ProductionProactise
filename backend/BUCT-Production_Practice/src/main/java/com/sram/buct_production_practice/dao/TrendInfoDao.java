package com.sram.buct_production_practice.dao;

import com.sram.buct_production_practice.entity.TrendInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface TrendInfoDao {
    int deleteByPrimaryKey(String equipmentuuid);

    int insert(TrendInfo record);

    int insertSelective(TrendInfo record);

    TrendInfo selectByPrimaryKey(String equipmentuuid);

    int updateByPrimaryKeySelective(TrendInfo record);

    int updateByPrimaryKey(TrendInfo record);
}