package com.sram.buct_production_practice.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * graph_historydata_trend
 * @author 
 */
@ApiModel(value="com.sram.buct_production_practice.entity.GraphHistorydataTrend")
@Data
public class GraphHistorydataTrend implements Serializable {
    private Integer id;

    private String smpfreq;

    private String smpnum;

    private String rev;

    private String trendvalue;

    private Long trendtime;

    private String unit;

    private String equipmentuuid;

    private String pointuuid;

    private Long alarmstarttime;

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
        GraphHistorydataTrend other = (GraphHistorydataTrend) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSmpfreq() == null ? other.getSmpfreq() == null : this.getSmpfreq().equals(other.getSmpfreq()))
            && (this.getSmpnum() == null ? other.getSmpnum() == null : this.getSmpnum().equals(other.getSmpnum()))
            && (this.getRev() == null ? other.getRev() == null : this.getRev().equals(other.getRev()))
            && (this.getTrendvalue() == null ? other.getTrendvalue() == null : this.getTrendvalue().equals(other.getTrendvalue()))
            && (this.getTrendtime() == null ? other.getTrendtime() == null : this.getTrendtime().equals(other.getTrendtime()))
            && (this.getUnit() == null ? other.getUnit() == null : this.getUnit().equals(other.getUnit()))
            && (this.getEquipmentuuid() == null ? other.getEquipmentuuid() == null : this.getEquipmentuuid().equals(other.getEquipmentuuid()))
            && (this.getPointuuid() == null ? other.getPointuuid() == null : this.getPointuuid().equals(other.getPointuuid()))
            && (this.getAlarmstarttime() == null ? other.getAlarmstarttime() == null : this.getAlarmstarttime().equals(other.getAlarmstarttime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSmpfreq() == null) ? 0 : getSmpfreq().hashCode());
        result = prime * result + ((getSmpnum() == null) ? 0 : getSmpnum().hashCode());
        result = prime * result + ((getRev() == null) ? 0 : getRev().hashCode());
        result = prime * result + ((getTrendvalue() == null) ? 0 : getTrendvalue().hashCode());
        result = prime * result + ((getTrendtime() == null) ? 0 : getTrendtime().hashCode());
        result = prime * result + ((getUnit() == null) ? 0 : getUnit().hashCode());
        result = prime * result + ((getEquipmentuuid() == null) ? 0 : getEquipmentuuid().hashCode());
        result = prime * result + ((getPointuuid() == null) ? 0 : getPointuuid().hashCode());
        result = prime * result + ((getAlarmstarttime() == null) ? 0 : getAlarmstarttime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", smpfreq=").append(smpfreq);
        sb.append(", smpnum=").append(smpnum);
        sb.append(", rev=").append(rev);
        sb.append(", trendvalue=").append(trendvalue);
        sb.append(", trendtime=").append(trendtime);
        sb.append(", unit=").append(unit);
        sb.append(", equipmentuuid=").append(equipmentuuid);
        sb.append(", pointuuid=").append(pointuuid);
        sb.append(", alarmstarttime=").append(alarmstarttime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}