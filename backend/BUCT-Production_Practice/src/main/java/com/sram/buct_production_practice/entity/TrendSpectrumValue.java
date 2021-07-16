package com.sram.buct_production_practice.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * trend_spectrum_value
 * @author 
 */
@ApiModel(value="频谱图数据")
@Data
public class TrendSpectrumValue implements Serializable {
    private Integer id;
    @ApiModelProperty("频谱图y")
    private String spectrumy;
    @ApiModelProperty("频谱图x")
    private String spectrumx;
    @ApiModelProperty("x轴")
    private String x;
    @ApiModelProperty("y轴")
    private String y;
    @ApiModelProperty("设备唯一标识")
    private String equipmentuuid;
    @ApiModelProperty("测点ID")
    private String pointidstring;
    @ApiModelProperty("趋势时间")
    private Long trendtime;

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
        TrendSpectrumValue other = (TrendSpectrumValue) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSpectrumy() == null ? other.getSpectrumy() == null : this.getSpectrumy().equals(other.getSpectrumy()))
            && (this.getSpectrumx() == null ? other.getSpectrumx() == null : this.getSpectrumx().equals(other.getSpectrumx()))
            && (this.getX() == null ? other.getX() == null : this.getX().equals(other.getX()))
            && (this.getY() == null ? other.getY() == null : this.getY().equals(other.getY()))
            && (this.getEquipmentuuid() == null ? other.getEquipmentuuid() == null : this.getEquipmentuuid().equals(other.getEquipmentuuid()))
            && (this.getPointidstring() == null ? other.getPointidstring() == null : this.getPointidstring().equals(other.getPointidstring()))
            && (this.getTrendtime() == null ? other.getTrendtime() == null : this.getTrendtime().equals(other.getTrendtime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSpectrumy() == null) ? 0 : getSpectrumy().hashCode());
        result = prime * result + ((getSpectrumx() == null) ? 0 : getSpectrumx().hashCode());
        result = prime * result + ((getX() == null) ? 0 : getX().hashCode());
        result = prime * result + ((getY() == null) ? 0 : getY().hashCode());
        result = prime * result + ((getEquipmentuuid() == null) ? 0 : getEquipmentuuid().hashCode());
        result = prime * result + ((getPointidstring() == null) ? 0 : getPointidstring().hashCode());
        result = prime * result + ((getTrendtime() == null) ? 0 : getTrendtime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", spectrumy=").append(spectrumy);
        sb.append(", spectrumx=").append(spectrumx);
        sb.append(", x=").append(x);
        sb.append(", y=").append(y);
        sb.append(", equipmentuuid=").append(equipmentuuid);
        sb.append(", pointidstring=").append(pointidstring);
        sb.append(", trendtime=").append(trendtime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}