package com.sram.buct_production_practice.controller;

import com.sram.buct_production_practice.dao.TrendInfoDao;
import com.sram.buct_production_practice.dao.TrendInfoTrendinfoDao;
import com.sram.buct_production_practice.dao.TrendValueDao;
import com.sram.buct_production_practice.entity.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Api(tags = "趋势波形图")
@CrossOrigin
@RestController
public class TrendInfoController {
    TrendInfoTrendinfoDao trendInfoTrendinfoDao;
    TrendInfoDao trendInfoDao;
    TrendValueDao trendValueDao;

    public TrendInfoController(@Autowired TrendInfoTrendinfoDao trendInfoTrendinfoDao,@Autowired TrendInfoDao trendInfoDao,@Autowired TrendValueDao trendValueDao){
        this.trendInfoTrendinfoDao=trendInfoTrendinfoDao;
        this.trendInfoDao = trendInfoDao;
        this.trendValueDao = trendValueDao;
    }

    @GetMapping("/trend/{equipmentUuid}/{pointIdString}/{startTime}/{endTime}/info")
    @ApiOperation(value = "多测点历史趋势数据", notes = "根据开始时间+结束时间获取指定测点的一段历史趋势数据")
    public List<TrendInfo> getTrendInfo(@ApiParam(value = "String", required = true) @PathVariable String equipmentUuid, @ApiParam(value = "String", required = true) @PathVariable String pointIdString, @ApiParam(value = "BigInteger", required = true) @PathVariable BigInteger startTime, @ApiParam(value = "BigInteger", required = true) @PathVariable BigInteger endTime) {
        TrendInfo trendInfo = trendInfoDao.selectByEquipmentAndPoint(equipmentUuid,pointIdString);
        List<TrendValue> trendValues = trendValueDao.selectBySection(equipmentUuid,pointIdString,startTime,endTime);
        List<TrendInfoTrendinfo> trendInfoValues = new ArrayList<>();
        for (TrendValue trendValue : trendValues) {
            TrendInfoTrendinfo trendInfoTrendinfo = trendInfoTrendinfoDao.selectByEquAndPointAndTime(equipmentUuid,pointIdString,BigInteger.valueOf(trendValue.getTrendtime()));
            if(trendInfoTrendinfo!=null){
                trendInfoTrendinfo.setTrendValues(trendValue);
                trendInfoValues.add(trendInfoTrendinfo);
            }
        }
        trendInfo.setTrendInfos(trendInfoValues);
        List<TrendInfo> trendInfos = new ArrayList<>();
        trendInfos.add(trendInfo);
        return trendInfos;
    }

}
