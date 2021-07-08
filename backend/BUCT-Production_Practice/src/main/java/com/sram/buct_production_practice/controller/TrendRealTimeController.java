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

@Api(tags = "趋势波形图")
@CrossOrigin
@RestController
public class TrendRealTimeController {
    TrendRealTimeDao trendRealTimeDao;

    public TrendRealTimeController(@Autowired TrendRealTimeDao trendRealTimeDao) {
        this.trendRealTimeDao = trendRealTimeDao;
    }

    @GetMapping("/trend/{equipmentUuid}/{pointIdString}/real_time")
    @ApiOperation(value = "测点实时趋势波形频谱", notes = "获取指定测点的实时趋势、波形和频谱数据")
    public List<TrendRealTime> getTrend(@ApiParam(value = "String", required = true) @PathVariable String equipmentUuid,@ApiParam(value = "String", required = true) @PathVariable String pointIdString) {
        return trendRealTimeDao.selectByEquAndPoint(equipmentUuid,pointIdString);
    }

}
