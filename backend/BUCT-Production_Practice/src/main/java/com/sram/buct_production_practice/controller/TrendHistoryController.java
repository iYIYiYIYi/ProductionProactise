package com.sram.buct_production_practice.controller;

import com.sram.buct_production_practice.dao.TrendRealTimeDao;
import com.sram.buct_production_practice.dao.TrendSpectrumValueDao;
import com.sram.buct_production_practice.dao.TrendValueDao;
import com.sram.buct_production_practice.dao.TrendWaveValueDao;
import com.sram.buct_production_practice.entity.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

@Api(tags = "趋势波形图")
@CrossOrigin
@RestController
public class TrendHistoryController {
    TrendRealTimeDao trendRealTimeDao;
    TrendValueDao trendValueDao;
    TrendWaveValueDao trendWaveValueDao;
    TrendSpectrumValueDao trendSpectrumValueDao;

    public TrendHistoryController(@Autowired TrendRealTimeDao trendRealTimeDao, @Autowired TrendValueDao trendValueDao, @Autowired TrendWaveValueDao trendWaveValueDao, @Autowired TrendSpectrumValueDao trendSpectrumValueDao) {
        this.trendRealTimeDao = trendRealTimeDao;
        this.trendValueDao=trendValueDao;
        this.trendWaveValueDao=trendWaveValueDao;
        this.trendSpectrumValueDao=trendSpectrumValueDao;
    }


    @GetMapping("/wave-spectrum/{equipmentUuid}/{pointIdString}/{trendTime}/{waveNumber}/{analysisLines}/info")
    @ApiOperation(value = "测点的历史波形和频谱数据", notes = "获取指定测点和时间点的历史波形和频谱数据")
    public List<TrendRealTime_ToReturn> getTrend(
            @ApiParam(value = "String", required = true) @PathVariable String equipmentUuid,
            @ApiParam(value = "String", required = true) @PathVariable String pointIdString,
            @ApiParam(value = "BigInteger", required = true) @PathVariable BigInteger trendTime,
            @ApiParam(value = "BigInteger", required = true) @PathVariable BigInteger waveNumber,
            @ApiParam(value = "BigInteger", required = true) @PathVariable BigInteger analysisLines
            ) {
        //历史数据和实时数据共用一个类
        TrendRealTime trendRealTime = trendRealTimeDao.selectByEquAndPointAndTime(equipmentUuid, pointIdString,trendTime);
        TrendRealTime_ToReturn toReturn=new TrendRealTime_ToReturn();

        toReturn.setRev(trendRealTime.getRev());
        toReturn.setEndindex(trendRealTime.getEndindex());
        toReturn.setTrendtime(trendRealTime.getTrendtime());
        toReturn.setPointname(trendRealTime.getPointname());
        toReturn.setStartindex(trendRealTime.getStartindex());
        toReturn.setEquipmentname(trendRealTime.getEquipmentname());

        final TrendValue trendValue = trendValueDao.selectByEquAndPointAndTime(equipmentUuid, pointIdString,trendTime);
        toReturn.setTrendvalue(trendValue);

        final TrendWaveValue trendWaveValue = trendWaveValueDao.selectByEquAndPointAndTime(equipmentUuid, pointIdString,trendTime);
        toReturn.setTrendWavevalue(trendWaveValue);

        final TrendSpectrumValue trendSpectrumValue = trendSpectrumValueDao.selectByEquAndPointAndTime(equipmentUuid, pointIdString,trendTime);
        toReturn.setTrendSpectrumvalue(trendSpectrumValue);

        List<TrendRealTime_ToReturn> toReturns=new LinkedList<>();
        toReturns.add(toReturn);

        return toReturns;
    }
}
