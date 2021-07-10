package com.sram.buct_production_practice.dao;

import com.sram.buct_production_practice.entity.GraphHistorydata;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GraphHistorydataDao {
    int deleteByPrimaryKey(Integer id);

    int insert(GraphHistorydata record);

    int insertSelective(GraphHistorydata record);

    GraphHistorydata selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GraphHistorydata record);

    int updateByPrimaryKey(GraphHistorydata record);

    List<GraphHistorydata> selectByEquipAndTime(String equipmentUuid,String alarmStartTime);
}