package com.sram.buct_production_practice.entity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "测点框的位置,大小,分组号")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListBoxes implements Serializable {
    @ApiModelProperty("显示Y坐标")
    private String ypos;
    @ApiModelProperty("显示宽度")
    private String width;
    @ApiModelProperty("显示X坐标")
    private String xpos;
    @ApiModelProperty("显示高度")
    private String height;
    @ApiModelProperty("测点信息")
    private List<ListBoxesPoints> points;

    private static final long serialVersionUID = 1L;

    public void setList(GraphDataListboxes graphDataListboxes){
        this.ypos=graphDataListboxes.getYpos();
        this.width=graphDataListboxes.getWidth();
        this.xpos=graphDataListboxes.getXpos();
        this.height=graphDataListboxes.getHeight();
    }


}
