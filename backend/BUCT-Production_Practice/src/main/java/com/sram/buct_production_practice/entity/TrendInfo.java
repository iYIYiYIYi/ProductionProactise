package com.sram.buct_production_practice.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * trend_info
 * @author 
 */
@ApiModel(value="历史趋势数据")
@Data
public class TrendInfo implements Serializable {
    private Integer id;
    @ApiModelProperty("设备唯一标识")
    private String equipmentuuid;
    @ApiModelProperty("测点ID")
    private String pointidstring;
    @ApiModelProperty("设备名称")
    private String equipmentname;
    @ApiModelProperty("测点名称")
    private String pointname;
    @ApiModelProperty("测点唯一标识")
    private String pointuuid;

    private List<TrendInfoTrendinfo> trendInfos;

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
        TrendInfo other = (TrendInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getEquipmentuuid() == null ? other.getEquipmentuuid() == null : this.getEquipmentuuid().equals(other.getEquipmentuuid()))
            && (this.getPointidstring() == null ? other.getPointidstring() == null : this.getPointidstring().equals(other.getPointidstring()))
            && (this.getEquipmentname() == null ? other.getEquipmentname() == null : this.getEquipmentname().equals(other.getEquipmentname()))
            && (this.getPointname() == null ? other.getPointname() == null : this.getPointname().equals(other.getPointname()))
            && (this.getPointuuid() == null ? other.getPointuuid() == null : this.getPointuuid().equals(other.getPointuuid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getEquipmentuuid() == null) ? 0 : getEquipmentuuid().hashCode());
        result = prime * result + ((getPointidstring() == null) ? 0 : getPointidstring().hashCode());
        result = prime * result + ((getEquipmentname() == null) ? 0 : getEquipmentname().hashCode());
        result = prime * result + ((getPointname() == null) ? 0 : getPointname().hashCode());
        result = prime * result + ((getPointuuid() == null) ? 0 : getPointuuid().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", equipmentuuid=").append(equipmentuuid);
        sb.append(", pointidstring=").append(pointidstring);
        sb.append(", equipmentname=").append(equipmentname);
        sb.append(", pointname=").append(pointname);
        sb.append(", pointuuid=").append(pointuuid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}