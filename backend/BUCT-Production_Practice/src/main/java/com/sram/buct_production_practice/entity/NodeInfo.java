package com.sram.buct_production_practice.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigInteger;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * node_info
 * @author 
 */
@ApiModel(value="节点信息")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NodeInfo implements Serializable {
    @ApiModelProperty("连接标识")
    private String nodeid;
    @ApiModelProperty("连接方式")
    private Integer linktype;
    @ApiModelProperty("主机地址")
    private String nodehost;
    @ApiModelProperty("端口号")
    private Integer nodeport;
    @ApiModelProperty("中间件类型")
    private Boolean status;
    @ApiModelProperty("存活状态")
    private Integer nodetype;
    @ApiModelProperty("同步时间")
    private BigInteger synctime;

    private static final long serialVersionUID = 1L;
}