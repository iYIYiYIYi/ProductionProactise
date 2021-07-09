package com.sram.buct_production_practice.dao;

import com.sram.buct_production_practice.entity.TrendSpectrumValue;
import org.springframework.stereotype.Repository;

@Repository
public interface TrendSpectrumValueDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TrendSpectrumValue record);

    int insertSelective(TrendSpectrumValue record);

    TrendSpectrumValue selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TrendSpectrumValue record);

    int updateByPrimaryKey(TrendSpectrumValue record);
}