package com.sram.buct_production_practice.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * graph_data
 * @author 
 */
@ApiModel(value="概貌图数据")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class GraphData implements Serializable {
    private String equipmentuuid;

    private GraphDataEquipmentname equipmentname;

    private List<ListBoxes> listboxes;

    private GraphDataRevinfo revinfo;

    private GraphDataTime time;

    private static final long serialVersionUID = 1L;

}