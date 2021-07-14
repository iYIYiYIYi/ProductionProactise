package com.sram.buct_production_practice.controller;

import com.sram.buct_production_practice.dao.*;
import com.sram.buct_production_practice.entity.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

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
        TrendRealTime trendRealTime = trendRealTimeDao.selectByEquAndPoint(equipmentUuid, pointIdString);
        TrendRealTime_ToReturn toReturn=new TrendRealTime_ToReturn();

        toReturn.setRev(trendRealTime.getRev());
        toReturn.setEndindex(trendRealTime.getEndindex());
        toReturn.setTrendtime(trendRealTime.getTrendtime());
        toReturn.setPointname(trendRealTime.getPointname());
        toReturn.setStartindex(trendRealTime.getStartindex());
        toReturn.setEquipmentname(trendRealTime.getEquipmentname());

        final TrendValue trendValue = trendValueDao.selectByEquAndPoint(equipmentUuid, pointIdString);
        toReturn.setTrendvalue(trendValue);

        final TrendWaveValue trendWaveValue = trendWaveValueDao.selectByEquAndPoint(equipmentUuid, pointIdString);
        toReturn.setTrendWavevalue(trendWaveValue);

        final TrendSpectrumValue trendSpectrumValue = trendSpectrumValueDao.selectByEquAndPoint(equipmentUuid, pointIdString);
        toReturn.setTrendSpectrumvalue(trendSpectrumValue);

        List<TrendRealTime_ToReturn> toReturns=new LinkedList<>();
        toReturns.add(toReturn);

        return toReturns;
    }

}
