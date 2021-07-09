package com.sram.buct_production_practice.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * graph_data_revinfo
 * @author 
 */
@ApiModel(value="com.sram.buct_production_practice.entity.GraphDataRevinfo")
@Data
public class GraphDataRevinfo implements Serializable {
    private String equipmentuuid;

    private String ypos;

    private String width;

    private String xpos;

    private String revname;

    private String revvalue;

    private String height;

    private String property;

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
        GraphDataRevinfo other = (GraphDataRevinfo) that;
        return (this.getEquipmentuuid() == null ? other.getEquipmentuuid() == null : this.getEquipmentuuid().equals(other.getEquipmentuuid()))
            && (this.getYpos() == null ? other.getYpos() == null : this.getYpos().equals(other.getYpos()))
            && (this.getWidth() == null ? other.getWidth() == null : this.getWidth().equals(other.getWidth()))
            && (this.getXpos() == null ? other.getXpos() == null : this.getXpos().equals(other.getXpos()))
            && (this.getRevname() == null ? other.getRevname() == null : this.getRevname().equals(other.getRevname()))
            && (this.getRevvalue() == null ? other.getRevvalue() == null : this.getRevvalue().equals(other.getRevvalue()))
            && (this.getHeight() == null ? other.getHeight() == null : this.getHeight().equals(other.getHeight()))
            && (this.getProperty() == null ? other.getProperty() == null : this.getProperty().equals(other.getProperty()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getEquipmentuuid() == null) ? 0 : getEquipmentuuid().hashCode());
        result = prime * result + ((getYpos() == null) ? 0 : getYpos().hashCode());
        result = prime * result + ((getWidth() == null) ? 0 : getWidth().hashCode());
        result = prime * result + ((getXpos() == null) ? 0 : getXpos().hashCode());
        result = prime * result + ((getRevname() == null) ? 0 : getRevname().hashCode());
        result = prime * result + ((getRevvalue() == null) ? 0 : getRevvalue().hashCode());
        result = prime * result + ((getHeight() == null) ? 0 : getHeight().hashCode());
        result = prime * result + ((getProperty() == null) ? 0 : getProperty().hashCode());
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
        sb.append(", revname=").append(revname);
        sb.append(", revvalue=").append(revvalue);
        sb.append(", height=").append(height);
        sb.append(", property=").append(property);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}