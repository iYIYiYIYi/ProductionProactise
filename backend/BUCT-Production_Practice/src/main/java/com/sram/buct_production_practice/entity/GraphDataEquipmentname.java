package com.sram.buct_production_practice.entity;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * graph_data_equipmentname
 * @author 
 */
@ApiModel(value="com.sram.buct_production_practice.entity.GraphDataEquipmentname")
@Data
public class GraphDataEquipmentname implements Serializable {
    private String equipmentuuid;

    private String ypos;

    private String width;

    @JSONField(alternateNames = "equipmentName")
    private String name;

    private String xpos;

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
        GraphDataEquipmentname other = (GraphDataEquipmentname) that;
        return (this.getEquipmentuuid() == null ? other.getEquipmentuuid() == null : this.getEquipmentuuid().equals(other.getEquipmentuuid()))
            && (this.getYpos() == null ? other.getYpos() == null : this.getYpos().equals(other.getYpos()))
            && (this.getWidth() == null ? other.getWidth() == null : this.getWidth().equals(other.getWidth()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getXpos() == null ? other.getXpos() == null : this.getXpos().equals(other.getXpos()))
            && (this.getHeight() == null ? other.getHeight() == null : this.getHeight().equals(other.getHeight()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getEquipmentuuid() == null) ? 0 : getEquipmentuuid().hashCode());
        result = prime * result + ((getYpos() == null) ? 0 : getYpos().hashCode());
        result = prime * result + ((getWidth() == null) ? 0 : getWidth().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getXpos() == null) ? 0 : getXpos().hashCode());
        result = prime * result + ((getHeight() == null) ? 0 : getHeight().hashCode());
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
        sb.append(", name=").append(name);
        sb.append(", xpos=").append(xpos);
        sb.append(", height=").append(height);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}