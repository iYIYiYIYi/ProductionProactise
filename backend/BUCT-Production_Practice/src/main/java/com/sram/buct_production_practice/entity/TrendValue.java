package com.sram.buct_production_practice.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * trend_value
 * @author 
 */
@ApiModel(value="趋势图数据")
@Data
public class TrendValue implements Serializable {
    private Integer id;
    @ApiModelProperty("通频")
    private Double all;
    @ApiModelProperty("1倍频辐值")
    private Double one;
    @ApiModelProperty("2倍频辐值")
    private Double two;
    @ApiModelProperty("3倍频辐值")
    private Double three;
    @ApiModelProperty("1/2倍频辐值")
    private Double half;
    @ApiModelProperty("残振")
    private Double res;
    @ApiModelProperty("直流量")
    private Double dc;
    @ApiModelProperty("间隙电压")
    private Double gap;
    @ApiModelProperty("1倍频相位")
    private Double phaseone;
    @ApiModelProperty("2倍频相位")
    private Double phasetwo;
    @ApiModelProperty("3倍频相位")
    private Double phasethree;
    @ApiModelProperty("1/2倍频相位")
    private Double phasehalf;
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
        TrendValue other = (TrendValue) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAll() == null ? other.getAll() == null : this.getAll().equals(other.getAll()))
            && (this.getOne() == null ? other.getOne() == null : this.getOne().equals(other.getOne()))
            && (this.getTwo() == null ? other.getTwo() == null : this.getTwo().equals(other.getTwo()))
            && (this.getThree() == null ? other.getThree() == null : this.getThree().equals(other.getThree()))
            && (this.getHalf() == null ? other.getHalf() == null : this.getHalf().equals(other.getHalf()))
            && (this.getRes() == null ? other.getRes() == null : this.getRes().equals(other.getRes()))
            && (this.getDc() == null ? other.getDc() == null : this.getDc().equals(other.getDc()))
            && (this.getGap() == null ? other.getGap() == null : this.getGap().equals(other.getGap()))
            && (this.getPhaseone() == null ? other.getPhaseone() == null : this.getPhaseone().equals(other.getPhaseone()))
            && (this.getPhasetwo() == null ? other.getPhasetwo() == null : this.getPhasetwo().equals(other.getPhasetwo()))
            && (this.getPhasethree() == null ? other.getPhasethree() == null : this.getPhasethree().equals(other.getPhasethree()))
            && (this.getPhasehalf() == null ? other.getPhasehalf() == null : this.getPhasehalf().equals(other.getPhasehalf()))
            && (this.getEquipmentuuid() == null ? other.getEquipmentuuid() == null : this.getEquipmentuuid().equals(other.getEquipmentuuid()))
            && (this.getPointidstring() == null ? other.getPointidstring() == null : this.getPointidstring().equals(other.getPointidstring()))
            && (this.getTrendtime() == null ? other.getTrendtime() == null : this.getTrendtime().equals(other.getTrendtime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAll() == null) ? 0 : getAll().hashCode());
        result = prime * result + ((getOne() == null) ? 0 : getOne().hashCode());
        result = prime * result + ((getTwo() == null) ? 0 : getTwo().hashCode());
        result = prime * result + ((getThree() == null) ? 0 : getThree().hashCode());
        result = prime * result + ((getHalf() == null) ? 0 : getHalf().hashCode());
        result = prime * result + ((getRes() == null) ? 0 : getRes().hashCode());
        result = prime * result + ((getDc() == null) ? 0 : getDc().hashCode());
        result = prime * result + ((getGap() == null) ? 0 : getGap().hashCode());
        result = prime * result + ((getPhaseone() == null) ? 0 : getPhaseone().hashCode());
        result = prime * result + ((getPhasetwo() == null) ? 0 : getPhasetwo().hashCode());
        result = prime * result + ((getPhasethree() == null) ? 0 : getPhasethree().hashCode());
        result = prime * result + ((getPhasehalf() == null) ? 0 : getPhasehalf().hashCode());
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
        sb.append(", all=").append(all);
        sb.append(", one=").append(one);
        sb.append(", two=").append(two);
        sb.append(", three=").append(three);
        sb.append(", half=").append(half);
        sb.append(", res=").append(res);
        sb.append(", dc=").append(dc);
        sb.append(", gap=").append(gap);
        sb.append(", phaseone=").append(phaseone);
        sb.append(", phasetwo=").append(phasetwo);
        sb.append(", phasethree=").append(phasethree);
        sb.append(", phasehalf=").append(phasehalf);
        sb.append(", equipmentuuid=").append(equipmentuuid);
        sb.append(", pointidstring=").append(pointidstring);
        sb.append(", trendtime=").append(trendtime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}