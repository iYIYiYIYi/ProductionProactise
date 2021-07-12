package com.sram.buct_production_practice.entity;

public class TrendRealTime_ToReturn {

    private String equipmentname;

    private TrendValue trendValue;

    private Integer rev;

    private String pointname;

    private Long trendtime;

    private TrendWaveValue trendWaveValue;

    private TrendSpectrumValue trendSpectrumValue;

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

    public TrendValue getTrendValue() {
        return trendValue;
    }

    public void setTrendValue(TrendValue trendValue) {
        this.trendValue = trendValue;
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

    public TrendWaveValue getTrendWaveValue() {
        return trendWaveValue;
    }

    public void setTrendWaveValue(TrendWaveValue trendWaveValue) {
        this.trendWaveValue = trendWaveValue;
    }

    public TrendSpectrumValue getTrendSpectrumValue() {
        return trendSpectrumValue;
    }

    public void setTrendSpectrumValue(TrendSpectrumValue trendSpectrumValue) {
        this.trendSpectrumValue = trendSpectrumValue;
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
