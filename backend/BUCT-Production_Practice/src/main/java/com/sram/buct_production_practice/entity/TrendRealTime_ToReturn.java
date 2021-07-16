package com.sram.buct_production_practice.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="趋势图信息")
public class TrendRealTime_ToReturn {
    @ApiModelProperty("设备名称")
    private String equipmentname;

    private TrendValue trendvalue;

    private Integer rev;
    @ApiModelProperty("测点名称")
    private String pointname;
    @ApiModelProperty("趋势时间")
    private Long trendtime;

    private TrendWaveValue trendWavevalue;

    private TrendSpectrumValue trendSpectrumvalue;

    private Integer startindex;

    private Integer endindex;

    public TrendRealTime_ToReturn() {
    }

    public String getEquipmentname() {
        return equipmentname;
    }

    public void setEquipmentname(String equipmentname) {
        this.equipmentname = equipmentname;
    }

    public TrendValue getTrendvalue() {
        return trendvalue;
    }

    public void setTrendvalue(TrendValue trendvalue) {
        this.trendvalue = trendvalue;
    }

    public Integer getRev() {
        return rev;
    }

    public void setRev(Integer rev) {
        this.rev = rev;
    }

    public String getPointname() {
        return pointname;
    }

    public void setPointname(String pointname) {
        this.pointname = pointname;
    }

    public Long getTrendtime() {
        return trendtime;
    }

    public void setTrendtime(Long trendtime) {
        this.trendtime = trendtime;
    }

    public TrendWaveValue getTrendWavevalue() {
        return trendWavevalue;
    }

    public void setTrendWavevalue(TrendWaveValue trendWavevalue) {
        this.trendWavevalue = trendWavevalue;
    }

    public TrendSpectrumValue getTrendSpectrumvalue() {
        return trendSpectrumvalue;
    }

    public void setTrendSpectrumvalue(TrendSpectrumValue trendSpectrumvalue) {
        this.trendSpectrumvalue = trendSpectrumvalue;
    }

    public Integer getStartindex() {
        return startindex;
    }

    public void setStartindex(Integer startindex) {
        this.startindex = startindex;
    }

    public Integer getEndindex() {
        return endindex;
    }

    public void setEndindex(Integer endindex) {
        this.endindex = endindex;
    }
}
