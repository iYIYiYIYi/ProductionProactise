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

import java.util.ArrayList;
import java.util.List;

@Api(value = "equipment_info")
@CrossOrigin
@RestController
public class EquipmentInfoController {
    EquipmentInfoDao equipmentInfoDao;

    public EquipmentInfoController(@Autowired EquipmentInfoDao equipmentInfoDao) {
        this.equipmentInfoDao = equipmentInfoDao;
    }

    @GetMapping("/equipment/node/{nodeid}/info")
    @ApiOperation(value = "Get Equipment Information", notes = "")
    public JSONObject getGraph(@ApiParam(value = "String", required = true) @PathVariable String nodeid) {
        List<EquipmentInfo> equipmentInfos = equipmentInfoDao.selectByNodeID(nodeid);
        return StandardJSonResponse.Correct(equipmentInfos, "equipment info");
    }
}






