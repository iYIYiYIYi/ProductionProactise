package com.sram.buct_production_practice.controller;

import com.alibaba.fastjson.JSON;

import com.alibaba.fastjson.JSONObject;
import com.sram.buct_production_practice.dao.PointDetailDao;

import com.sram.buct_production_practice.entity.PointDetail;
import com.sram.buct_production_practice.util.StandardJSonResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "测点信息")
@CrossOrigin
@RestController
public class PointDetailController {
    PointDetailDao pointDetailDao;

    public PointDetailController(@Autowired PointDetailDao pointDetailDao) {
        this.pointDetailDao = pointDetailDao;
    }

    @GetMapping("/point/{equipmentUuid}/detail")
    @ApiOperation(value = "基于设备UUID获取测点详细信息", notes = "基于设备UUID获取测点详细信息")
    public List<PointDetail> getPoint(@ApiParam(value = "String", required = true) @PathVariable String equipmentUuid) {
        return pointDetailDao.selectByEquipmentUuid(equipmentUuid);
    }
}
