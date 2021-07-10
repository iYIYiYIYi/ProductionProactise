package com.sram.buct_production_practice.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@ApiModel(value="概貌图历史数据")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GraphHistory {
    private Integer id;

    private Long alarmstarttime;

    private String equipmentuuid;

    private Integer alarmstatus;

    private Integer channellist;

    private Integer channeltype;

    private String pointid;

    private String pointuuid;

    private Double rev1;

    private Double rev2;

    private Double rev3;

    private Double rev4;

    private Double rev5;

    private String time;

    private String unit;

    private Double value;

    private GraphHistorydataTrend graphHistorydataTrend;
     public void setData(GraphHistorydata graphHistorydata){
         this.setAlarmstarttime(graphHistorydata.getAlarmstarttime());
         this.setEquipmentuuid(graphHistorydata.getEquipmentuuid());
         this.setAlarmstatus(graphHistorydata.getAlarmstatus());
         this.setChannellist(graphHistorydata.getChannellist());
         this.setChanneltype(graphHistorydata.getChanneltype());
         this.setPointid(graphHistorydata.getPointid());
         this.setPointuuid(graphHistorydata.getPointuuid());
         this.setRev1(graphHistorydata.getRev1());
         this.setRev2(graphHistorydata.getRev2());
         this.setRev3(graphHistorydata.getRev3());
         this.setRev4(graphHistorydata.getRev4());
         this.setRev5(graphHistorydata.getRev5());
         this.setTime(graphHistorydata.getTime());
         this.setUnit(graphHistorydata.getUnit());
         this.setValue(graphHistorydata.getValue());
     }
}
