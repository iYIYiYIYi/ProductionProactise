package com.sram.buct_production_practice.controller;

import com.alibaba.fastjson.JSONObject;
import com.sram.buct_production_practice.dao.PointDetailDao;
import com.sram.buct_production_practice.dao.TrendRealTimeDao;
import com.sram.buct_production_practice.entity.PointDetail;
import com.sram.buct_production_practice.entity.TrendRealTime;
import com.sram.buct_production_practice.util.StandardJSonResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "trend_real_time")
@CrossOrigin
@RestController
public class TrendRealTimeController {
    TrendRealTimeDao trendRealTimeDao;

    public TrendRealTimeController(@Autowired TrendRealTimeDao trendRealTimeDao) {
        this.trendRealTimeDao = trendRealTimeDao;
    }

    @GetMapping("/trend/{equipmentUuid}/{pointIdString}/real_time")
    @ApiOperation(value = "Obtain real-time information of measuring points", notes = "获取测点实时趋势")
    public JSONObject getTrend(@ApiParam(value = "String", required = true) @PathVariable String equipmentUuid,@ApiParam(value = "String", required = true) @PathVariable String pointIdString) {
        List<TrendRealTime> trendRealTimes = trendRealTimeDao.selectByEquAndPoint(equipmentUuid,pointIdString);
        if(trendRealTimes.isEmpty())
            return StandardJSonResponse.Error("无法找到相关信息");
        return StandardJSonResponse.Correct(trendRealTimes, "trend real time");
    }

}
