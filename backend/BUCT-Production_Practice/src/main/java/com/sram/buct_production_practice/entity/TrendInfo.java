package com.sram.buct_production_practice.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * trend_info
 * @author 
 */
@ApiModel(value="com.sram.buct_production_practice.entity.TrendInfo")
@Data
public class TrendInfo implements Serializable {
    private String equipmentuuid;

    private Integer endtime;

    private String pointidstring;

    private Integer starttime;

    private String equipmentname;

    private String pointname;

    private String pointuuid;

    private String trendinfo;

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
        return (this.getEquipmentuuid() == null ? other.getEquipmentuuid() == null : this.getEquipmentuuid().equals(other.getEquipmentuuid()))
            && (this.getEndtime() == null ? other.getEndtime() == null : this.getEndtime().equals(other.getEndtime()))
            && (this.getPointidstring() == null ? other.getPointidstring() == null : this.getPointidstring().equals(other.getPointidstring()))
            && (this.getStarttime() == null ? other.getStarttime() == null : this.getStarttime().equals(other.getStarttime()))
            && (this.getEquipmentname() == null ? other.getEquipmentname() == null : this.getEquipmentname().equals(other.getEquipmentname()))
            && (this.getPointname() == null ? other.getPointname() == null : this.getPointname().equals(other.getPointname()))
            && (this.getPointuuid() == null ? other.getPointuuid() == null : this.getPointuuid().equals(other.getPointuuid()))
            && (this.getTrendinfo() == null ? other.getTrendinfo() == null : this.getTrendinfo().equals(other.getTrendinfo()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getEquipmentuuid() == null) ? 0 : getEquipmentuuid().hashCode());
        result = prime * result + ((getEndtime() == null) ? 0 : getEndtime().hashCode());
        result = prime * result + ((getPointidstring() == null) ? 0 : getPointidstring().hashCode());
        result = prime * result + ((getStarttime() == null) ? 0 : getStarttime().hashCode());
        result = prime * result + ((getEquipmentname() == null) ? 0 : getEquipmentname().hashCode());
        result = prime * result + ((getPointname() == null) ? 0 : getPointname().hashCode());
        result = prime * result + ((getPointuuid() == null) ? 0 : getPointuuid().hashCode());
        result = prime * result + ((getTrendinfo() == null) ? 0 : getTrendinfo().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", equipmentuuid=").append(equipmentuuid);
        sb.append(", endtime=").append(endtime);
        sb.append(", pointidstring=").append(pointidstring);
        sb.append(", starttime=").append(starttime);
        sb.append(", equipmentname=").append(equipmentname);
        sb.append(", pointname=").append(pointname);
        sb.append(", pointuuid=").append(pointuuid);
        sb.append(", trendinfo=").append(trendinfo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}