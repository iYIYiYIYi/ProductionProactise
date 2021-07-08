package com.sram.buct_production_practice.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * graph_data_listboxes
 * @author 
 */
@ApiModel(value="测点框的位置,大小,分组号")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GraphDataListboxes implements Serializable {
    @ApiModelProperty("设备唯一标识")
    private String equipmentuuid;
    @ApiModelProperty("显示Y坐标")
    private String ypos;
    @ApiModelProperty("显示宽度")
    private String width;
    @ApiModelProperty("显示X坐标")
    private String xpos;
    @ApiModelProperty("显示高度")
    private String height;

    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        GraphDataListboxes other = (GraphDataListboxes) that;
        return (this.getEquipmentuuid() == null ? other.getEquipmentuuid() == null : this.getEquipmentuuid().equals(other.getEquipmentuuid()))
            && (this.getYpos() == null ? other.getYpos() == null : this.getYpos().equals(other.getYpos()))
            && (this.getWidth() == null ? other.getWidth() == null : this.getWidth().equals(other.getWidth()))
            && (this.getXpos() == null ? other.getXpos() == null : this.getXpos().equals(other.getXpos()))
            && (this.getHeight() == null ? other.getHeight() == null : this.getHeight().equals(other.getHeight()));
    }

    public String  hashCodeSB() {
        String result = "";
        result = result + ((getYpos() == null) ? "" : getYpos());
        result = result + ((getWidth() == null) ? "" : getWidth());
        result = result + ((getXpos() == null) ? "" : getXpos());
        result = result + ((getHeight() == null) ? "" : getHeight());
        return result;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", equipmentuuid=").append(equipmentuuid);
        sb.append(", ypos=").append(ypos);
        sb.append(", width=").append(width);
        sb.append(", xpos=").append(xpos);
        sb.append(", height=").append(height);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}