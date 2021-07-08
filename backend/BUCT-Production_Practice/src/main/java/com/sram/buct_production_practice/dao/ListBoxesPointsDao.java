package com.sram.buct_production_practice.dao;

import com.sram.buct_production_practice.entity.ListBoxesPoints;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListBoxesPointsDao {
    int deleteByPrimaryKey(Integer id);

    int insert(ListBoxesPoints record);

    int insertSelective(ListBoxesPoints record);

    ListBoxesPoints selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ListBoxesPoints record);

    int updateByPrimaryKey(ListBoxesPoints record);

    List<ListBoxesPoints> selectAll(String pointHash,String equipmentUuid);
}