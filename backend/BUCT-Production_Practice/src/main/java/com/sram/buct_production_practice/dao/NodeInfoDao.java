package com.sram.buct_production_practice.dao;

import com.sram.buct_production_practice.entity.NodeInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NodeInfoDao {
    int deleteByPrimaryKey(String nodeid);

    int insert(NodeInfo record);

    int insertSelective(NodeInfo record);

    NodeInfo selectByPrimaryKey(String nodeid);

    int updateByPrimaryKeySelective(NodeInfo record);

    int updateByPrimaryKey(NodeInfo record);

    List<NodeInfo> selectAll();
}