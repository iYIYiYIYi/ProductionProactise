package com.sram.buct_production_practice.dao;

import com.sram.buct_production_practice.entity.PointDetail;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PointDetailDao {


    int deleteByPrimaryKey(String pointuuid);

    int insert(PointDetail record);

    int insertSelective(PointDetail record);

    PointDetail selectByPrimaryKey(String pointuuid);

    int updateByPrimaryKeySelective(PointDetail record);

    int updateByPrimaryKey(PointDetail record);

    List<PointDetail> selectByEquipmentUuid(String EquipmentUuid);
}