package com.sram.buct_production_practice.controller;

import com.alibaba.fastjson.JSONObject;
import com.sram.buct_production_practice.dao.GraphDataDao;
import com.sram.buct_production_practice.dao.NodeInfoDao;
import com.sram.buct_production_practice.entity.EquipmentInfo;
import com.sram.buct_production_practice.entity.GraphData;
import com.sram.buct_production_practice.entity.NodeInfo;
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

@Api(value = "graph_data")
@CrossOrigin
@RestController
public class GraphDataController {
    GraphDataDao graphDataDao;

    public GraphDataController(@Autowired GraphDataDao graphDataDao) {
        this.graphDataDao = graphDataDao;
    }

    @GetMapping("/graph/{equipmentUuid}/data")
    @ApiOperation(value = "Get graph Information", notes = "")
    public JSONObject getGraph(@ApiParam(value = "String", required = true) @PathVariable String equipmentUuid) {
        final GraphData graphData = graphDataDao.selectByPrimaryKey(equipmentUuid);
        return StandardJSonResponse.Correct(graphData, "graphData info");
    }
}
