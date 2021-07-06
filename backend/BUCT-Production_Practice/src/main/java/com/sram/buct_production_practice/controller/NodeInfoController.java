package com.sram.buct_production_practice.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

@Api(value = "node_info")
@CrossOrigin
@RestController
public class NodeInfoController {
    @GetMapping("/node/info")
    @ApiOperation(value = "Get Node Information", notes = "")
    public String getNode( ){
        return "{\n" +
                "\"code\": 200,\n" +
                "\"message\": \"获取配置的中间件信息\",\n" +
                "\"data\": [\n" +
                "{\n" +
                "\"nodeId\": \"12700117001\",\n" +
                "\"nodeHost\": \"127.0.0.1\",\n" +
                "\"nodePort\": 17001,\n" +
                "\"nodeType\": 1,\n" +
                "\"linkType\": 0,\n" +
                "\"status\": true,\n" +
                "\"syncTime\": 1625539043406\n" +
                "}\n" +
                "]\n" +
                "}";
    }
}
