package com.sram.buct_production_practice.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * point_detail
 * @author 
 */
@ApiModel(value="测点信息")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PointDetail implements Serializable {
    @ApiModelProperty("测点唯一标识")
    private String pointuuid;
    @ApiModelProperty("所属测点框序号")
    private Integer channellist;
    @ApiModelProperty("测点类型,1径向,2轴向")
    private Integer channeltype;
    @ApiModelProperty("测点类型描述")
    private String channeltypealias;
    @ApiModelProperty("公司ID")
    private String companyid;
    @ApiModelProperty("接触角")
    private Double contactangle;
    @ApiModelProperty("所属汽缸号")
    private Integer cylinderno;
    @ApiModelProperty("数据源")
    private Integer datasource;
    @ApiModelProperty("数据类型")
    private Integer datatype;
    @ApiModelProperty("设备ID")
    private String equipmentid;
    @ApiModelProperty("设备类型")
    private Integer equipmenttype;
    @ApiModelProperty("设备唯一标识")
    private String equipmentuuid;
    @ApiModelProperty("报警限类型")
    private Integer eventtype;
    @ApiModelProperty("分厂ID")
    private String factoryid;
    @ApiModelProperty("报警线高高限")
    private Double hh;
    @ApiModelProperty("报警线高限")
    private Double hl;
    @ApiModelProperty("报警线低限")
    private Double lh;
    @ApiModelProperty("报警线下下限")
    private Double ll;
    @ApiModelProperty("位置索引")
    private Integer locindex;
    @ApiModelProperty("位置名称")
    private String locname;
    @ApiModelProperty("制造商")
    private String manufacturer;
    @ApiModelProperty("测点方向,0:水平，1:垂直")
    private Integer measuredirection;
    @ApiModelProperty("")
    private String mhost;
    @ApiModelProperty("")
    private Integer mport;
    @ApiModelProperty("主机地址")
    private String nodehost;
    @ApiModelProperty("节点ID")
    private String nodeid;
    @ApiModelProperty("端口号")
    private Integer nodeport;
    @ApiModelProperty("节点类型")
    private Integer nodetype;
    @ApiModelProperty("节径")
    private Double pitchdiam;
    @ApiModelProperty("测点ID")
    private String pointid;
    @ApiModelProperty("测点索引(1000:振动,2000:过程量,3000:动态)")
    private Integer pointindex;
    @ApiModelProperty("测点名称")
    private String pointname;
    @ApiModelProperty("测点位号")
    private String pointno;
    @ApiModelProperty("测点排序号")
    private Integer pointorder;
    @ApiModelProperty("转速类型")
    private Integer revtype;
    @ApiModelProperty("滚珠直径")
    private Double rollingnum;
    @ApiModelProperty("滚珠数目")
    private Double rollingdiam;
    @ApiModelProperty("部位索引")
    private Integer sectionindex;
    @ApiModelProperty("部位名称")
    private String sectionname;
    @ApiModelProperty("传感器类型")
    private Integer sensortype;
    @ApiModelProperty("初始间隙电压")
    private Double trendgap;
    @ApiModelProperty("特征值类型")
    private Integer type;
    @ApiModelProperty("单位")
    private String unit;

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
        PointDetail other = (PointDetail) that;
        return (this.getPointuuid() == null ? other.getPointuuid() == null : this.getPointuuid().equals(other.getPointuuid()))
            && (this.getChannellist() == null ? other.getChannellist() == null : this.getChannellist().equals(other.getChannellist()))
            && (this.getChanneltype() == null ? other.getChanneltype() == null : this.getChanneltype().equals(other.getChanneltype()))
            && (this.getChanneltypealias() == null ? other.getChanneltypealias() == null : this.getChanneltypealias().equals(other.getChanneltypealias()))
            && (this.getCompanyid() == null ? other.getCompanyid() == null : this.getCompanyid().equals(other.getCompanyid()))
            && (this.getContactangle() == null ? other.getContactangle() == null : this.getContactangle().equals(other.getContactangle()))
            && (this.getCylinderno() == null ? other.getCylinderno() == null : this.getCylinderno().equals(other.getCylinderno()))
            && (this.getDatasource() == null ? other.getDatasource() == null : this.getDatasource().equals(other.getDatasource()))
            && (this.getDatatype() == null ? other.getDatatype() == null : this.getDatatype().equals(other.getDatatype()))
            && (this.getEquipmentid() == null ? other.getEquipmentid() == null : this.getEquipmentid().equals(other.getEquipmentid()))
            && (this.getEquipmenttype() == null ? other.getEquipmenttype() == null : this.getEquipmenttype().equals(other.getEquipmenttype()))
            && (this.getEquipmentuuid() == null ? other.getEquipmentuuid() == null : this.getEquipmentuuid().equals(other.getEquipmentuuid()))
            && (this.getEventtype() == null ? other.getEventtype() == null : this.getEventtype().equals(other.getEventtype()))
            && (this.getFactoryid() == null ? other.getFactoryid() == null : this.getFactoryid().equals(other.getFactoryid()))
            && (this.getHh() == null ? other.getHh() == null : this.getHh().equals(other.getHh()))
            && (this.getHl() == null ? other.getHl() == null : this.getHl().equals(other.getHl()))
            && (this.getLh() == null ? other.getLh() == null : this.getLh().equals(other.getLh()))
            && (this.getLl() == null ? other.getLl() == null : this.getLl().equals(other.getLl()))
            && (this.getLocindex() == null ? other.getLocindex() == null : this.getLocindex().equals(other.getLocindex()))
            && (this.getLocname() == null ? other.getLocname() == null : this.getLocname().equals(other.getLocname()))
            && (this.getManufacturer() == null ? other.getManufacturer() == null : this.getManufacturer().equals(other.getManufacturer()))
            && (this.getMeasuredirection() == null ? other.getMeasuredirection() == null : this.getMeasuredirection().equals(other.getMeasuredirection()))
            && (this.getMhost() == null ? other.getMhost() == null : this.getMhost().equals(other.getMhost()))
            && (this.getMport() == null ? other.getMport() == null : this.getMport().equals(other.getMport()))
            && (this.getNodehost() == null ? other.getNodehost() == null : this.getNodehost().equals(other.getNodehost()))
            && (this.getNodeid() == null ? other.getNodeid() == null : this.getNodeid().equals(other.getNodeid()))
            && (this.getNodeport() == null ? other.getNodeport() == null : this.getNodeport().equals(other.getNodeport()))
            && (this.getNodetype() == null ? other.getNodetype() == null : this.getNodetype().equals(other.getNodetype()))
            && (this.getPitchdiam() == null ? other.getPitchdiam() == null : this.getPitchdiam().equals(other.getPitchdiam()))
            && (this.getPointid() == null ? other.getPointid() == null : this.getPointid().equals(other.getPointid()))
            && (this.getPointindex() == null ? other.getPointindex() == null : this.getPointindex().equals(other.getPointindex()))
            && (this.getPointname() == null ? other.getPointname() == null : this.getPointname().equals(other.getPointname()))
            && (this.getPointno() == null ? other.getPointno() == null : this.getPointno().equals(other.getPointno()))
            && (this.getPointorder() == null ? other.getPointorder() == null : this.getPointorder().equals(other.getPointorder()))
            && (this.getRevtype() == null ? other.getRevtype() == null : this.getRevtype().equals(other.getRevtype()))
            && (this.getRollingnum() == null ? other.getRollingnum() == null : this.getRollingnum().equals(other.getRollingnum()))
            && (this.getRollingdiam() == null ? other.getRollingdiam() == null : this.getRollingdiam().equals(other.getRollingdiam()))
            && (this.getSectionindex() == null ? other.getSectionindex() == null : this.getSectionindex().equals(other.getSectionindex()))
            && (this.getSectionname() == null ? other.getSectionname() == null : this.getSectionname().equals(other.getSectionname()))
            && (this.getSensortype() == null ? other.getSensortype() == null : this.getSensortype().equals(other.getSensortype()))
            && (this.getTrendgap() == null ? other.getTrendgap() == null : this.getTrendgap().equals(other.getTrendgap()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getUnit() == null ? other.getUnit() == null : this.getUnit().equals(other.getUnit()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPointuuid() == null) ? 0 : getPointuuid().hashCode());
        result = prime * result + ((getChannellist() == null) ? 0 : getChannellist().hashCode());
        result = prime * result + ((getChanneltype() == null) ? 0 : getChanneltype().hashCode());
        result = prime * result + ((getChanneltypealias() == null) ? 0 : getChanneltypealias().hashCode());
        result = prime * result + ((getCompanyid() == null) ? 0 : getCompanyid().hashCode());
        result = prime * result + ((getContactangle() == null) ? 0 : getContactangle().hashCode());
        result = prime * result + ((getCylinderno() == null) ? 0 : getCylinderno().hashCode());
        result = prime * result + ((getDatasource() == null) ? 0 : getDatasource().hashCode());
        result = prime * result + ((getDatatype() == null) ? 0 : getDatatype().hashCode());
        result = prime * result + ((getEquipmentid() == null) ? 0 : getEquipmentid().hashCode());
        result = prime * result + ((getEquipmenttype() == null) ? 0 : getEquipmenttype().hashCode());
        result = prime * result + ((getEquipmentuuid() == null) ? 0 : getEquipmentuuid().hashCode());
        result = prime * result + ((getEventtype() == null) ? 0 : getEventtype().hashCode());
        result = prime * result + ((getFactoryid() == null) ? 0 : getFactoryid().hashCode());
        result = prime * result + ((getHh() == null) ? 0 : getHh().hashCode());
        result = prime * result + ((getHl() == null) ? 0 : getHl().hashCode());
        result = prime * result + ((getLh() == null) ? 0 : getLh().hashCode());
        result = prime * result + ((getLl() == null) ? 0 : getLl().hashCode());
        result = prime * result + ((getLocindex() == null) ? 0 : getLocindex().hashCode());
        result = prime * result + ((getLocname() == null) ? 0 : getLocname().hashCode());
        result = prime * result + ((getManufacturer() == null) ? 0 : getManufacturer().hashCode());
        result = prime * result + ((getMeasuredirection() == null) ? 0 : getMeasuredirection().hashCode());
        result = prime * result + ((getMhost() == null) ? 0 : getMhost().hashCode());
        result = prime * result + ((getMport() == null) ? 0 : getMport().hashCode());
        result = prime * result + ((getNodehost() == null) ? 0 : getNodehost().hashCode());
        result = prime * result + ((getNodeid() == null) ? 0 : getNodeid().hashCode());
        result = prime * result + ((getNodeport() == null) ? 0 : getNodeport().hashCode());
        result = prime * result + ((getNodetype() == null) ? 0 : getNodetype().hashCode());
        result = prime * result + ((getPitchdiam() == null) ? 0 : getPitchdiam().hashCode());
        result = prime * result + ((getPointid() == null) ? 0 : getPointid().hashCode());
        result = prime * result + ((getPointindex() == null) ? 0 : getPointindex().hashCode());
        result = prime * result + ((getPointname() == null) ? 0 : getPointname().hashCode());
        result = prime * result + ((getPointno() == null) ? 0 : getPointno().hashCode());
        result = prime * result + ((getPointorder() == null) ? 0 : getPointorder().hashCode());
        result = prime * result + ((getRevtype() == null) ? 0 : getRevtype().hashCode());
        result = prime * result + ((getRollingnum() == null) ? 0 : getRollingnum().hashCode());
        result = prime * result + ((getRollingdiam() == null) ? 0 : getRollingdiam().hashCode());
        result = prime * result + ((getSectionindex() == null) ? 0 : getSectionindex().hashCode());
        result = prime * result + ((getSectionname() == null) ? 0 : getSectionname().hashCode());
        result = prime * result + ((getSensortype() == null) ? 0 : getSensortype().hashCode());
        result = prime * result + ((getTrendgap() == null) ? 0 : getTrendgap().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getUnit() == null) ? 0 : getUnit().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pointuuid=").append(pointuuid);
        sb.append(", channellist=").append(channellist);
        sb.append(", channeltype=").append(channeltype);
        sb.append(", channeltypealias=").append(channeltypealias);
        sb.append(", companyid=").append(companyid);
        sb.append(", contactangle=").append(contactangle);
        sb.append(", cylinderno=").append(cylinderno);
        sb.append(", datasource=").append(datasource);
        sb.append(", datatype=").append(datatype);
        sb.append(", equipmentid=").append(equipmentid);
        sb.append(", equipmenttype=").append(equipmenttype);
        sb.append(", equipmentuuid=").append(equipmentuuid);
        sb.append(", eventtype=").append(eventtype);
        sb.append(", factoryid=").append(factoryid);
        sb.append(", hh=").append(hh);
        sb.append(", hl=").append(hl);
        sb.append(", lh=").append(lh);
        sb.append(", ll=").append(ll);
        sb.append(", locindex=").append(locindex);
        sb.append(", locname=").append(locname);
        sb.append(", manufacturer=").append(manufacturer);
        sb.append(", measuredirection=").append(measuredirection);
        sb.append(", mhost=").append(mhost);
        sb.append(", mport=").append(mport);
        sb.append(", nodehost=").append(nodehost);
        sb.append(", nodeid=").append(nodeid);
        sb.append(", nodeport=").append(nodeport);
        sb.append(", nodetype=").append(nodetype);
        sb.append(", pitchdiam=").append(pitchdiam);
        sb.append(", pointid=").append(pointid);
        sb.append(", pointindex=").append(pointindex);
        sb.append(", pointname=").append(pointname);
        sb.append(", pointno=").append(pointno);
        sb.append(", pointorder=").append(pointorder);
        sb.append(", revtype=").append(revtype);
        sb.append(", rollingnum=").append(rollingnum);
        sb.append(", rollingdiam=").append(rollingdiam);
        sb.append(", sectionindex=").append(sectionindex);
        sb.append(", sectionname=").append(sectionname);
        sb.append(", sensortype=").append(sensortype);
        sb.append(", trendgap=").append(trendgap);
        sb.append(", type=").append(type);
        sb.append(", unit=").append(unit);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}