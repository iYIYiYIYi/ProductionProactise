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
@ApiModel(value="获取节点信息")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NodeInfo implements Serializable {
    private String nodeid;

    private Integer linktype;

    private String nodehost;

    private Integer nodeport;

    private Boolean status;

    private Integer nodetype;

    private BigInteger synctime;

    private static final long serialVersionUID = 1L;
}