package com.sram.buct_production_practice.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sram.buct_production_practice.dao.NodeInfoDao;
import com.sram.buct_production_practice.entity.NodeInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "node_info")
@CrossOrigin
@RestController
public class NodeInfoController {



    NodeInfoDao nodeInfoDao;

    public NodeInfoController(@Autowired NodeInfoDao nodeInfoDao) {
        this.nodeInfoDao = nodeInfoDao;
    }

    @GetMapping("/node/info")
    @ApiOperation(value = "Get Node Information", notes = "")
    public String getNode( ){
        List<NodeInfo> nodeInfos = nodeInfoDao.selectAll();
        return JSON.toJSONString(nodeInfos);
    }
}
