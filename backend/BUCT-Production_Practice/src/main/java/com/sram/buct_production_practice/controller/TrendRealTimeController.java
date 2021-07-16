package com.sram.buct_production_practice.controller;

import com.sram.buct_production_practice.dao.*;
import com.sram.buct_production_practice.entity.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@Api(tags = "趋势波形图")
@CrossOrigin
@RestController
public class TrendRealTimeController {
    TrendRealTimeDao trendRealTimeDao;
    TrendValueDao trendValueDao;
    TrendWaveValueDao trendWaveValueDao;
    TrendSpectrumValueDao trendSpectrumValueDao;

    public TrendRealTimeController(@Autowired TrendRealTimeDao trendRealTimeDao, @Autowired TrendValueDao trendValueDao, @Autowired TrendWaveValueDao trendWaveValueDao, @Autowired TrendSpectrumValueDao trendSpectrumValueDao) {
        this.trendRealTimeDao = trendRealTimeDao;
        this.trendValueDao=trendValueDao;
        this.trendWaveValueDao=trendWaveValueDao;
        this.trendSpectrumValueDao=trendSpectrumValueDao;
    }


    @GetMapping("/trend/{equipmentUuid}/{pointIdString}/real_time")
    @ApiOperation(value = "测点实时趋势波形频谱", notes = "获取指定测点的实时趋势、波形和频谱数据")
    public List<TrendRealTime_ToReturn> getTrend(@ApiParam(value = "String", required = true) @PathVariable String equipmentUuid,@ApiParam(value = "String", required = true) @PathVariable String pointIdString) {

        List<BigInteger> trendTimes = trendRealTimeDao.selectRecent(equipmentUuid,pointIdString);

        Random r = new Random();
        BigInteger trendTime = trendTimes.get(r.nextInt(trendTimes.size()));

        TrendRealTime trendRealTime = trendRealTimeDao.selectByEquAndPointAndTime(equipmentUuid, pointIdString,trendTime);
        TrendRealTime_ToReturn toReturn=new TrendRealTime_ToReturn();

        toReturn.setRev(trendRealTime.getRev());
        toReturn.setTrendtime(System.currentTimeMillis());
        toReturn.setEndindex(trendRealTime.getEndindex());
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
