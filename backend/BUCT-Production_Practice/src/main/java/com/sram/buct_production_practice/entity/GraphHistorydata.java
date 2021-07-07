package com.sram.buct_production_practice.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * graph_historydata
 * @author 
 */
@ApiModel(value="com.sram.buct_production_practice.entity.GraphHistorydata")
@Data
public class GraphHistorydata implements Serializable {
    private Integer equipmentuuid;

    private Integer alarmstarttime;

    private Integer alarmstatus;

    private Integer channellist;

    private Integer channeltype;

    private String pointid;

    private String pointuuid;

    private Integer rev1;

    private Integer rev2;

    private Integer rev3;

    private Integer rev4;

    private Integer rev5;

    private String time;

    private String trend;

    private String unit;

    private Integer value;

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
        GraphHistorydata other = (GraphHistorydata) that;
        return (this.getEquipmentuuid() == null ? other.getEquipmentuuid() == null : this.getEquipmentuuid().equals(other.getEquipmentuuid()))
            && (this.getAlarmstarttime() == null ? other.getAlarmstarttime() == null : this.getAlarmstarttime().equals(other.getAlarmstarttime()))
            && (this.getAlarmstatus() == null ? other.getAlarmstatus() == null : this.getAlarmstatus().equals(other.getAlarmstatus()))
            && (this.getChannellist() == null ? other.getChannellist() == null : this.getChannellist().equals(other.getChannellist()))
            && (this.getChanneltype() == null ? other.getChanneltype() == null : this.getChanneltype().equals(other.getChanneltype()))
            && (this.getPointid() == null ? other.getPointid() == null : this.getPointid().equals(other.getPointid()))
            && (this.getPointuuid() == null ? other.getPointuuid() == null : this.getPointuuid().equals(other.getPointuuid()))
            && (this.getRev1() == null ? other.getRev1() == null : this.getRev1().equals(other.getRev1()))
            && (this.getRev2() == null ? other.getRev2() == null : this.getRev2().equals(other.getRev2()))
            && (this.getRev3() == null ? other.getRev3() == null : this.getRev3().equals(other.getRev3()))
            && (this.getRev4() == null ? other.getRev4() == null : this.getRev4().equals(other.getRev4()))
            && (this.getRev5() == null ? other.getRev5() == null : this.getRev5().equals(other.getRev5()))
            && (this.getTime() == null ? other.getTime() == null : this.getTime().equals(other.getTime()))
            && (this.getTrend() == null ? other.getTrend() == null : this.getTrend().equals(other.getTrend()))
            && (this.getUnit() == null ? other.getUnit() == null : this.getUnit().equals(other.getUnit()))
            && (this.getValue() == null ? other.getValue() == null : this.getValue().equals(other.getValue()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getEquipmentuuid() == null) ? 0 : getEquipmentuuid().hashCode());
        result = prime * result + ((getAlarmstarttime() == null) ? 0 : getAlarmstarttime().hashCode());
        result = prime * result + ((getAlarmstatus() == null) ? 0 : getAlarmstatus().hashCode());
        result = prime * result + ((getChannellist() == null) ? 0 : getChannellist().hashCode());
        result = prime * result + ((getChanneltype() == null) ? 0 : getChanneltype().hashCode());
        result = prime * result + ((getPointid() == null) ? 0 : getPointid().hashCode());
        result = prime * result + ((getPointuuid() == null) ? 0 : getPointuuid().hashCode());
        result = prime * result + ((getRev1() == null) ? 0 : getRev1().hashCode());
        result = prime * result + ((getRev2() == null) ? 0 : getRev2().hashCode());
        result = prime * result + ((getRev3() == null) ? 0 : getRev3().hashCode());
        result = prime * result + ((getRev4() == null) ? 0 : getRev4().hashCode());
        result = prime * result + ((getRev5() == null) ? 0 : getRev5().hashCode());
        result = prime * result + ((getTime() == null) ? 0 : getTime().hashCode());
        result = prime * result + ((getTrend() == null) ? 0 : getTrend().hashCode());
        result = prime * result + ((getUnit() == null) ? 0 : getUnit().hashCode());
        result = prime * result + ((getValue() == null) ? 0 : getValue().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", equipmentuuid=").append(equipmentuuid);
        sb.append(", alarmstarttime=").append(alarmstarttime);
        sb.append(", alarmstatus=").append(alarmstatus);
        sb.append(", channellist=").append(channellist);
        sb.append(", channeltype=").append(channeltype);
        sb.append(", pointid=").append(pointid);
        sb.append(", pointuuid=").append(pointuuid);
        sb.append(", rev1=").append(rev1);
        sb.append(", rev2=").append(rev2);
        sb.append(", rev3=").append(rev3);
        sb.append(", rev4=").append(rev4);
        sb.append(", rev5=").append(rev5);
        sb.append(", time=").append(time);
        sb.append(", trend=").append(trend);
        sb.append(", unit=").append(unit);
        sb.append(", value=").append(value);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}