package com.sram.buct_production_practice.controller;


import com.sram.buct_production_practice.dao.*;
import com.sram.buct_production_practice.entity.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Api(value = "graph_data")
@CrossOrigin
@RestController
public class GraphDataController {

    GraphDataListboxesDao graphDataListboxesDao;

    GraphDataEquipmentnameDao graphDataEquipmentnameDao;

    GraphDataRevinfoDao graphDataRevinfoDao;

    GraphDataTimeDao graphDataTimeDao;

    ListBoxesPointsDao listBoxesPointsDao;

    public GraphDataController(@Autowired GraphDataListboxesDao graphDataListboxesDao,@Autowired GraphDataEquipmentnameDao graphDataEquipmentnameDao,@Autowired GraphDataRevinfoDao graphDataRevinfoDao,@Autowired GraphDataTimeDao graphDataTimeDao,@Autowired ListBoxesPointsDao listBoxesPointsDao) {
        this.graphDataListboxesDao = graphDataListboxesDao;
        this.graphDataEquipmentnameDao = graphDataEquipmentnameDao;
        this.graphDataRevinfoDao = graphDataRevinfoDao;
        this.graphDataTimeDao = graphDataTimeDao;
        this.listBoxesPointsDao = listBoxesPointsDao;
    }

    @GetMapping("/graph/{equipmentUuid}/data")
    @ApiOperation(value = "Get graph Information", notes = "")
    public List<GraphData> getGraph(@ApiParam(value = "String", required = true) @PathVariable String equipmentUuid) {
        GraphDataEquipmentname graphDataEquipmentname = graphDataEquipmentnameDao.selectByPrimaryKey(equipmentUuid);
        GraphDataTime graphDataTime = graphDataTimeDao.selectByPrimaryKey(equipmentUuid);
        GraphDataRevinfo graphDataRevinfo = graphDataRevinfoDao.selectByPrimaryKey(equipmentUuid);
        List<GraphDataListboxes> graphDataListboxes = graphDataListboxesDao.selectByEquipmentUuid(equipmentUuid);
        List<ListBoxes> listBoxes = new ArrayList<>();
        for (GraphDataListboxes graphDataListbox : graphDataListboxes) {
            List<ListBoxesPoints> listBoxesPoints = listBoxesPointsDao.selectAll(graphDataListbox.hashCodeSB(), equipmentUuid);
            ListBoxes listBox = new ListBoxes();
            listBox.setPoints(listBoxesPoints);
            listBox.setList(graphDataListbox);
            listBoxes.add(listBox);
        }

        GraphData graphData = new GraphData(equipmentUuid,graphDataEquipmentname,listBoxes,graphDataRevinfo,graphDataTime);
        List<GraphData>  graphDataList = new ArrayList<>();
        graphDataList.add(graphData);
        return graphDataList;
    }
}
