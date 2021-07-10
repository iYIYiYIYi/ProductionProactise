package com.sram.buct_production_practice.controller;


import com.sram.buct_production_practice.dao.GraphHistorydataDao;
import com.sram.buct_production_practice.dao.GraphHistorydataTrendDao;
import com.sram.buct_production_practice.entity.GraphHistory;
import com.sram.buct_production_practice.entity.GraphHistorydata;
import com.sram.buct_production_practice.entity.GraphHistorydataTrend;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Api(tags = "设备概貌图信息")
@CrossOrigin
@RestController
public class GraphHistoryDataController {
    GraphHistorydataDao graphHistorydataDao;
    GraphHistorydataTrendDao graphHistorydataTrendDao;

    public GraphHistoryDataController(GraphHistorydataDao graphHistorydataDao,GraphHistorydataTrendDao graphHistorydataTrendDao){
        this.graphHistorydataDao = graphHistorydataDao;
        this.graphHistorydataTrendDao = graphHistorydataTrendDao;
    }
    @GetMapping("/graph/{equipmentUuid}/{alarmStartTime}/historyData")
    @ApiOperation(value = "获取指定设备概貌图历史数据", notes = "获取指定设备概貌图历史数据")
    public List<GraphHistory> getGraphHistoryData(@ApiParam(value = "String", required = true) @PathVariable String equipmentUuid,@ApiParam(value = "String", required = true) @PathVariable String alarmStartTime){
        List<GraphHistorydata> graphHistorydatas = graphHistorydataDao.selectByEquipAndTime(equipmentUuid,alarmStartTime);
        List<GraphHistory> graphHistories = new ArrayList<>();
        for (GraphHistorydata graphHistorydata : graphHistorydatas) {
            GraphHistory graphHistory = new GraphHistory();
            graphHistory.setData(graphHistorydata);
            GraphHistorydataTrend graphHistorydataTrend = graphHistorydataTrendDao.selectByThree(equipmentUuid,alarmStartTime,graphHistory.getPointuuid());
            graphHistory.setGraphHistorydataTrend(graphHistorydataTrend);
            graphHistories.add(graphHistory);
        }
        return graphHistories;
    }
}
