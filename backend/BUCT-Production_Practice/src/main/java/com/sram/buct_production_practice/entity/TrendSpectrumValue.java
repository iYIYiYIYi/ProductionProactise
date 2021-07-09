package com.sram.buct_production_practice.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * trend_spectrum_value
 * @author 
 */
@ApiModel(value="com.sram.buct_production_practice.entity.TrendSpectrumValue")
@Data
public class TrendSpectrumValue implements Serializable {
    private Integer id;

    private String spectrumy;

    private String spectrumx;

    private String x;

    private String y;

    private String equipmentuuid;

    private String pointidstring;

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
            && (this.getPointidstring() == null ? other.getPointidstring() == null : this.getPointidstring().equals(other.getPointidstring()));
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
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}