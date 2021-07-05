package com.sram.buct_production_practice.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/*
 * @RestController <==> @Controller + @ResponseBody
 */
@Api(value = "hello")
@RestController
public class HelloWorldController {

    @RequestMapping("/expert/{companyId}")
    @ApiOperation(value = "Test", notes = "")
    public String hello(@ApiParam(value = "int" , required=true ) @PathVariable int companyId){
        return "Hello World!"+companyId;
    }
}
