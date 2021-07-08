package com.sram.buct_production_practice.controller;

import com.sram.buct_production_practice.dao.GraphInfoDao;

import com.sram.buct_production_practice.entity.GraphInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "设备概貌图信息")
@CrossOrigin
@RestController
public class GraphInfoController {
    GraphInfoDao graphInfoDao;

    public GraphInfoController(@Autowired GraphInfoDao graphInfoDao) {
        this.graphInfoDao = graphInfoDao;
    }

    @GetMapping("/graph/{equipmentUuid}/info")
    @ApiOperation(value = "获取指定概貌图底图信息", notes = "获取指定概貌图底图信息")
    public List<GraphInfo> getNode(@ApiParam(value = "String", required = true) @PathVariable String equipmentUuid) {
        return graphInfoDao.selectByEquipmentUuid(equipmentUuid);
    }
}
