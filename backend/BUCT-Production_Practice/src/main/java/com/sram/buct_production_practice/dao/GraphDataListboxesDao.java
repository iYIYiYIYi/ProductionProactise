package com.sram.buct_production_practice.dao;

import com.sram.buct_production_practice.entity.GraphDataListboxes;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GraphDataListboxesDao {
    int deleteByPrimaryKey(String equipmentuuid);

    int insert(GraphDataListboxes record);

    int insertSelective(GraphDataListboxes record);

    GraphDataListboxes selectByPrimaryKey(String equipmentuuid);

    int updateByPrimaryKeySelective(GraphDataListboxes record);

    int updateByPrimaryKey(GraphDataListboxes record);

    List<GraphDataListboxes> selectByEquipmentUuid(String equipmentuuid);
}