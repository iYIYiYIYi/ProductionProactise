package com.sram.buct_production_practice.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * trend_info_trendinfo
 * @author 
 */
@ApiModel(value="部分历史趋势数据")
@Data
public class TrendInfoTrendinfo implements Serializable {
    private Integer id;


    private Long smpfreq;

    private Long smpnum;

    private Long rev;
    @ApiModelProperty("趋势时间")
    private Long trendtime;
    @ApiModelProperty("单位")
    private String unit;
    @ApiModelProperty("测点ID")
    private String pointidstring;
    @ApiModelProperty("设备唯一标识")
    private String equipmentuuid;

    private TrendValue trendValues;

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
        TrendInfoTrendinfo other = (TrendInfoTrendinfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSmpfreq() == null ? other.getSmpfreq() == null : this.getSmpfreq().equals(other.getSmpfreq()))
            && (this.getSmpnum() == null ? other.getSmpnum() == null : this.getSmpnum().equals(other.getSmpnum()))
            && (this.getRev() == null ? other.getRev() == null : this.getRev().equals(other.getRev()))
            && (this.getTrendtime() == null ? other.getTrendtime() == null : this.getTrendtime().equals(other.getTrendtime()))
            && (this.getUnit() == null ? other.getUnit() == null : this.getUnit().equals(other.getUnit()))
            && (this.getPointidstring() == null ? other.getPointidstring() == null : this.getPointidstring().equals(other.getPointidstring()))
            && (this.getEquipmentuuid() == null ? other.getEquipmentuuid() == null : this.getEquipmentuuid().equals(other.getEquipmentuuid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSmpfreq() == null) ? 0 : getSmpfreq().hashCode());
        result = prime * result + ((getSmpnum() == null) ? 0 : getSmpnum().hashCode());
        result = prime * result + ((getRev() == null) ? 0 : getRev().hashCode());
        result = prime * result + ((getTrendtime() == null) ? 0 : getTrendtime().hashCode());
        result = prime * result + ((getUnit() == null) ? 0 : getUnit().hashCode());
        result = prime * result + ((getPointidstring() == null) ? 0 : getPointidstring().hashCode());
        result = prime * result + ((getEquipmentuuid() == null) ? 0 : getEquipmentuuid().hashCode());
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
        sb.append(", trendtime=").append(trendtime);
        sb.append(", unit=").append(unit);
        sb.append(", pointidstring=").append(pointidstring);
        sb.append(", equipmentuuid=").append(equipmentuuid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}