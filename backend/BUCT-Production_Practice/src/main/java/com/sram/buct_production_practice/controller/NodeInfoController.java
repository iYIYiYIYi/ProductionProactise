package com.sram.buct_production_practice.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sram.buct_production_practice.dao.NodeInfoDao;
import com.sram.buct_production_practice.entity.NodeInfo;
import com.sram.buct_production_practice.util.StandardJSonResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "节点信息")
@CrossOrigin
@RestController
public class NodeInfoController {

    NodeInfoDao nodeInfoDao;

    public NodeInfoController(@Autowired NodeInfoDao nodeInfoDao) {
        this.nodeInfoDao = nodeInfoDao;
    }

    @GetMapping("/node/info")
    @ApiOperation(value = "获取配置的中间件信息", notes = "获取配置的中间件信息")
    public List<NodeInfo> getNode() {
        return nodeInfoDao.selectAll();
    }
}
