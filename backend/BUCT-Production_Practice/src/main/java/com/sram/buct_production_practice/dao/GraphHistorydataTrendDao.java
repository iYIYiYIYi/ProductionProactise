package com.sram.buct_production_practice.dao;

import com.sram.buct_production_practice.entity.GraphHistorydataTrend;
import org.springframework.stereotype.Repository;

@Repository
public interface GraphHistorydataTrendDao {
    int deleteByPrimaryKey(Integer id);

    int insert(GraphHistorydataTrend record);

    int insertSelective(GraphHistorydataTrend record);

    GraphHistorydataTrend selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GraphHistorydataTrend record);

    int updateByPrimaryKey(GraphHistorydataTrend record);

    GraphHistorydataTrend selectByThree(String equipmentUuid,String alarmStartTime,String pointUuid);
}