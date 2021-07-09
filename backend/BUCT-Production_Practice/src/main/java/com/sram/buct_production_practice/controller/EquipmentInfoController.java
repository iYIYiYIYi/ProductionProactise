package com.sram.buct_production_practice.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sram.buct_production_practice.dao.EquipmentInfoDao;

import com.sram.buct_production_practice.entity.EquipmentInfo;

import com.sram.buct_production_practice.util.StandardJSonResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import java.math.BigInteger;
import java.util.List;

@Api(tags = "设备信息")
@CrossOrigin
@RestController
public class EquipmentInfoController {
    EquipmentInfoDao equipmentInfoDao;

    public EquipmentInfoController(@Autowired EquipmentInfoDao equipmentInfoDao) {
        this.equipmentInfoDao = equipmentInfoDao;
    }

    @GetMapping("/equipment/node/{nodeid}/info")
    @ApiOperation(value = "获取某个节点上所有设备最新状态", notes = "获取某个节点上所有设备最新状态")
    public List<EquipmentInfo> getGraph(@ApiParam(value = "String", required = true) @PathVariable String nodeid) {
        List<EquipmentInfo> equipmentInfos = equipmentInfoDao.selectByNodeID(nodeid);
        for (EquipmentInfo equipmentInfo : equipmentInfos) {
            equipmentInfo.setUpdatetime(BigInteger.valueOf(System.currentTimeMillis()));
        }
        return equipmentInfos;
    }
}






