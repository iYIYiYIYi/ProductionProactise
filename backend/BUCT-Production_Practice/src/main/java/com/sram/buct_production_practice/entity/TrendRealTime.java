package com.sram.buct_production_practice.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * trend_real_time
 * @author 
 */
@ApiModel(value="com.sram.buct_production_practice.entity.TrendRealTime")
@Data
public class TrendRealTime implements Serializable {
    private String equipmentuuid;

    private String pointidstring;

    private Integer endindex;

    private String equipmentname;

    private String pointname;

    private Integer rev;

    private String spectrumvalue;

    private Integer startindex;

    private Integer trendtime;

    private String trendvalue;

    private String wavevalue;

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
        TrendRealTime other = (TrendRealTime) that;
        return (this.getEquipmentuuid() == null ? other.getEquipmentuuid() == null : this.getEquipmentuuid().equals(other.getEquipmentuuid()))
            && (this.getPointidstring() == null ? other.getPointidstring() == null : this.getPointidstring().equals(other.getPointidstring()))
            && (this.getEndindex() == null ? other.getEndindex() == null : this.getEndindex().equals(other.getEndindex()))
            && (this.getEquipmentname() == null ? other.getEquipmentname() == null : this.getEquipmentname().equals(other.getEquipmentname()))
            && (this.getPointname() == null ? other.getPointname() == null : this.getPointname().equals(other.getPointname()))
            && (this.getRev() == null ? other.getRev() == null : this.getRev().equals(other.getRev()))
            && (this.getSpectrumvalue() == null ? other.getSpectrumvalue() == null : this.getSpectrumvalue().equals(other.getSpectrumvalue()))
            && (this.getStartindex() == null ? other.getStartindex() == null : this.getStartindex().equals(other.getStartindex()))
            && (this.getTrendtime() == null ? other.getTrendtime() == null : this.getTrendtime().equals(other.getTrendtime()))
            && (this.getTrendvalue() == null ? other.getTrendvalue() == null : this.getTrendvalue().equals(other.getTrendvalue()))
            && (this.getWavevalue() == null ? other.getWavevalue() == null : this.getWavevalue().equals(other.getWavevalue()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getEquipmentuuid() == null) ? 0 : getEquipmentuuid().hashCode());
        result = prime * result + ((getPointidstring() == null) ? 0 : getPointidstring().hashCode());
        result = prime * result + ((getEndindex() == null) ? 0 : getEndindex().hashCode());
        result = prime * result + ((getEquipmentname() == null) ? 0 : getEquipmentname().hashCode());
        result = prime * result + ((getPointname() == null) ? 0 : getPointname().hashCode());
        result = prime * result + ((getRev() == null) ? 0 : getRev().hashCode());
        result = prime * result + ((getSpectrumvalue() == null) ? 0 : getSpectrumvalue().hashCode());
        result = prime * result + ((getStartindex() == null) ? 0 : getStartindex().hashCode());
        result = prime * result + ((getTrendtime() == null) ? 0 : getTrendtime().hashCode());
        result = prime * result + ((getTrendvalue() == null) ? 0 : getTrendvalue().hashCode());
        result = prime * result + ((getWavevalue() == null) ? 0 : getWavevalue().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", equipmentuuid=").append(equipmentuuid);
        sb.append(", pointidstring=").append(pointidstring);
        sb.append(", endindex=").append(endindex);
        sb.append(", equipmentname=").append(equipmentname);
        sb.append(", pointname=").append(pointname);
        sb.append(", rev=").append(rev);
        sb.append(", spectrumvalue=").append(spectrumvalue);
        sb.append(", startindex=").append(startindex);
        sb.append(", trendtime=").append(trendtime);
        sb.append(", trendvalue=").append(trendvalue);
        sb.append(", wavevalue=").append(wavevalue);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}