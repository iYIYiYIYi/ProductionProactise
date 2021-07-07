package com.sram.buct_production_practice.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * graph_data
 * @author 
 */
@ApiModel(value="com.sram.buct_production_practice.entity.GraphData")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GraphData implements Serializable {
    private String equipmentuuid;

    private String equipmentname;

    private String listboxes;

    private String revinfo;

    private String time;

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
        GraphData other = (GraphData) that;
        return (this.getEquipmentuuid() == null ? other.getEquipmentuuid() == null : this.getEquipmentuuid().equals(other.getEquipmentuuid()))
            && (this.getEquipmentname() == null ? other.getEquipmentname() == null : this.getEquipmentname().equals(other.getEquipmentname()))
            && (this.getListboxes() == null ? other.getListboxes() == null : this.getListboxes().equals(other.getListboxes()))
            && (this.getRevinfo() == null ? other.getRevinfo() == null : this.getRevinfo().equals(other.getRevinfo()))
            && (this.getTime() == null ? other.getTime() == null : this.getTime().equals(other.getTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getEquipmentuuid() == null) ? 0 : getEquipmentuuid().hashCode());
        result = prime * result + ((getEquipmentname() == null) ? 0 : getEquipmentname().hashCode());
        result = prime * result + ((getListboxes() == null) ? 0 : getListboxes().hashCode());
        result = prime * result + ((getRevinfo() == null) ? 0 : getRevinfo().hashCode());
        result = prime * result + ((getTime() == null) ? 0 : getTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", equipmentuuid=").append(equipmentuuid);
        sb.append(", equipmentname=").append(equipmentname);
        sb.append(", listboxes=").append(listboxes);
        sb.append(", revinfo=").append(revinfo);
        sb.append(", time=").append(time);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}