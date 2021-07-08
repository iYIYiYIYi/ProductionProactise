package com.sram.buct_production_practice.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigInteger;

import lombok.Data;

/**
 * equipment_info
 * @author 
 */
@Data
@ApiModel(value ="设备信息")
public class EquipmentInfo implements Serializable {

    @ApiModelProperty("设备唯一标识")
    private String equipmentuuid;
    @ApiModelProperty("设备状态描述")
    private String alarmalias;
    @ApiModelProperty("报警ID")
    private Integer alarmid;
    @ApiModelProperty("报警级别")
    private Integer alarmlevel;
    @ApiModelProperty("设备状态编码")
    private Integer alarmstatus;
    @ApiModelProperty("公司ID")
    private String companyid;
    @ApiModelProperty("公司显示名称")
    private String companyname;
    @ApiModelProperty("公司位号")
    private String companyno;
    @ApiModelProperty("公司排序号")
    private Integer companysort;
    @ApiModelProperty("公司是否显示标识")
    private Integer companyvisible;
    @ApiModelProperty("开停车状态有效位")
    private Integer datatype;
    @ApiModelProperty("驱动机类型名称")
    private String drivename;
    @ApiModelProperty("驱动机类型编码")
    private Integer drivetype;
    @ApiModelProperty("设备ID")
    private String equipmentid;
    @ApiModelProperty("设备索引")
    private Integer equipmentindex;
    @ApiModelProperty("设备显示名称")
    private String equipmentname;
    @ApiModelProperty("设备位号")
    private String equipmentno;
    @ApiModelProperty("设备排序号")
    private Integer equipmentsort;
    @ApiModelProperty("设备类型编码")
    private Integer equipmenttype;
    @ApiModelProperty("设备类型名称")
    private String equipmenttypename;
    @ApiModelProperty("设备是否显示标识")
    private Integer equipmentvisible;
    @ApiModelProperty("设备资产编码")
    private String erpcode;
    @ApiModelProperty("分厂ID")
    private String factoryid;
    @ApiModelProperty("分厂显示名称")
    private String factoryname;
    @ApiModelProperty("分厂排序号")
    private Integer factorysort;
    @ApiModelProperty("分厂是否显示标识")
    private Integer factoryvisible;
    @ApiModelProperty("设备概貌图号")
    private Integer graphtype;
    @ApiModelProperty("集团ID")
    private String groupid;
    @ApiModelProperty("集团显示名称")
    private String groupname;
    @ApiModelProperty("集团排序号")
    private Integer groupsort;
    @ApiModelProperty("集团是否显示标识")
    private Integer groupvisible;
    @ApiModelProperty("制造商")
    private String manufacturer;
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
    @ApiModelProperty("转速")
    private Integer rev;
    @ApiModelProperty("采样频率")
    private Integer samplingfreq;
    @ApiModelProperty("采样点数")
    private Integer samplingnumber;
    @ApiModelProperty("装置ID")
    private String unitid;
    @ApiModelProperty("装置显示名称")
    private String unitname;
    @ApiModelProperty("装置排序号")
    private Integer unitsort;
    @ApiModelProperty("装置是否显示标识")
    private Integer unitvisible;
    @ApiModelProperty("数据更新时刻")
    private BigInteger updatetime;

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
        EquipmentInfo other = (EquipmentInfo) that;
        return (this.getEquipmentuuid() == null ? other.getEquipmentuuid() == null : this.getEquipmentuuid().equals(other.getEquipmentuuid()))
            && (this.getAlarmalias() == null ? other.getAlarmalias() == null : this.getAlarmalias().equals(other.getAlarmalias()))
            && (this.getAlarmid() == null ? other.getAlarmid() == null : this.getAlarmid().equals(other.getAlarmid()))
            && (this.getAlarmlevel() == null ? other.getAlarmlevel() == null : this.getAlarmlevel().equals(other.getAlarmlevel()))
            && (this.getAlarmstatus() == null ? other.getAlarmstatus() == null : this.getAlarmstatus().equals(other.getAlarmstatus()))
            && (this.getCompanyid() == null ? other.getCompanyid() == null : this.getCompanyid().equals(other.getCompanyid()))
            && (this.getCompanyname() == null ? other.getCompanyname() == null : this.getCompanyname().equals(other.getCompanyname()))
            && (this.getCompanyno() == null ? other.getCompanyno() == null : this.getCompanyno().equals(other.getCompanyno()))
            && (this.getCompanysort() == null ? other.getCompanysort() == null : this.getCompanysort().equals(other.getCompanysort()))
            && (this.getCompanyvisible() == null ? other.getCompanyvisible() == null : this.getCompanyvisible().equals(other.getCompanyvisible()))
            && (this.getDatatype() == null ? other.getDatatype() == null : this.getDatatype().equals(other.getDatatype()))
            && (this.getDrivename() == null ? other.getDrivename() == null : this.getDrivename().equals(other.getDrivename()))
            && (this.getDrivetype() == null ? other.getDrivetype() == null : this.getDrivetype().equals(other.getDrivetype()))
            && (this.getEquipmentid() == null ? other.getEquipmentid() == null : this.getEquipmentid().equals(other.getEquipmentid()))
            && (this.getEquipmentindex() == null ? other.getEquipmentindex() == null : this.getEquipmentindex().equals(other.getEquipmentindex()))
            && (this.getEquipmentname() == null ? other.getEquipmentname() == null : this.getEquipmentname().equals(other.getEquipmentname()))
            && (this.getEquipmentno() == null ? other.getEquipmentno() == null : this.getEquipmentno().equals(other.getEquipmentno()))
            && (this.getEquipmentsort() == null ? other.getEquipmentsort() == null : this.getEquipmentsort().equals(other.getEquipmentsort()))
            && (this.getEquipmenttype() == null ? other.getEquipmenttype() == null : this.getEquipmenttype().equals(other.getEquipmenttype()))
            && (this.getEquipmenttypename() == null ? other.getEquipmenttypename() == null : this.getEquipmenttypename().equals(other.getEquipmenttypename()))
            && (this.getEquipmentvisible() == null ? other.getEquipmentvisible() == null : this.getEquipmentvisible().equals(other.getEquipmentvisible()))
            && (this.getErpcode() == null ? other.getErpcode() == null : this.getErpcode().equals(other.getErpcode()))
            && (this.getFactoryid() == null ? other.getFactoryid() == null : this.getFactoryid().equals(other.getFactoryid()))
            && (this.getFactoryname() == null ? other.getFactoryname() == null : this.getFactoryname().equals(other.getFactoryname()))
            && (this.getFactorysort() == null ? other.getFactorysort() == null : this.getFactorysort().equals(other.getFactorysort()))
            && (this.getFactoryvisible() == null ? other.getFactoryvisible() == null : this.getFactoryvisible().equals(other.getFactoryvisible()))
            && (this.getGraphtype() == null ? other.getGraphtype() == null : this.getGraphtype().equals(other.getGraphtype()))
            && (this.getGroupid() == null ? other.getGroupid() == null : this.getGroupid().equals(other.getGroupid()))
            && (this.getGroupname() == null ? other.getGroupname() == null : this.getGroupname().equals(other.getGroupname()))
            && (this.getGroupsort() == null ? other.getGroupsort() == null : this.getGroupsort().equals(other.getGroupsort()))
            && (this.getGroupvisible() == null ? other.getGroupvisible() == null : this.getGroupvisible().equals(other.getGroupvisible()))
            && (this.getManufacturer() == null ? other.getManufacturer() == null : this.getManufacturer().equals(other.getManufacturer()))
            && (this.getMhost() == null ? other.getMhost() == null : this.getMhost().equals(other.getMhost()))
            && (this.getMport() == null ? other.getMport() == null : this.getMport().equals(other.getMport()))
            && (this.getNodehost() == null ? other.getNodehost() == null : this.getNodehost().equals(other.getNodehost()))
            && (this.getNodeid() == null ? other.getNodeid() == null : this.getNodeid().equals(other.getNodeid()))
            && (this.getNodeport() == null ? other.getNodeport() == null : this.getNodeport().equals(other.getNodeport()))
            && (this.getNodetype() == null ? other.getNodetype() == null : this.getNodetype().equals(other.getNodetype()))
            && (this.getRev() == null ? other.getRev() == null : this.getRev().equals(other.getRev()))
            && (this.getSamplingfreq() == null ? other.getSamplingfreq() == null : this.getSamplingfreq().equals(other.getSamplingfreq()))
            && (this.getSamplingnumber() == null ? other.getSamplingnumber() == null : this.getSamplingnumber().equals(other.getSamplingnumber()))
            && (this.getUnitid() == null ? other.getUnitid() == null : this.getUnitid().equals(other.getUnitid()))
            && (this.getUnitname() == null ? other.getUnitname() == null : this.getUnitname().equals(other.getUnitname()))
            && (this.getUnitsort() == null ? other.getUnitsort() == null : this.getUnitsort().equals(other.getUnitsort()))
            && (this.getUnitvisible() == null ? other.getUnitvisible() == null : this.getUnitvisible().equals(other.getUnitvisible()))
            && (this.getUpdatetime() == null ? other.getUpdatetime() == null : this.getUpdatetime().equals(other.getUpdatetime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getEquipmentuuid() == null) ? 0 : getEquipmentuuid().hashCode());
        result = prime * result + ((getAlarmalias() == null) ? 0 : getAlarmalias().hashCode());
        result = prime * result + ((getAlarmid() == null) ? 0 : getAlarmid().hashCode());
        result = prime * result + ((getAlarmlevel() == null) ? 0 : getAlarmlevel().hashCode());
        result = prime * result + ((getAlarmstatus() == null) ? 0 : getAlarmstatus().hashCode());
        result = prime * result + ((getCompanyid() == null) ? 0 : getCompanyid().hashCode());
        result = prime * result + ((getCompanyname() == null) ? 0 : getCompanyname().hashCode());
        result = prime * result + ((getCompanyno() == null) ? 0 : getCompanyno().hashCode());
        result = prime * result + ((getCompanysort() == null) ? 0 : getCompanysort().hashCode());
        result = prime * result + ((getCompanyvisible() == null) ? 0 : getCompanyvisible().hashCode());
        result = prime * result + ((getDatatype() == null) ? 0 : getDatatype().hashCode());
        result = prime * result + ((getDrivename() == null) ? 0 : getDrivename().hashCode());
        result = prime * result + ((getDrivetype() == null) ? 0 : getDrivetype().hashCode());
        result = prime * result + ((getEquipmentid() == null) ? 0 : getEquipmentid().hashCode());
        result = prime * result + ((getEquipmentindex() == null) ? 0 : getEquipmentindex().hashCode());
        result = prime * result + ((getEquipmentname() == null) ? 0 : getEquipmentname().hashCode());
        result = prime * result + ((getEquipmentno() == null) ? 0 : getEquipmentno().hashCode());
        result = prime * result + ((getEquipmentsort() == null) ? 0 : getEquipmentsort().hashCode());
        result = prime * result + ((getEquipmenttype() == null) ? 0 : getEquipmenttype().hashCode());
        result = prime * result + ((getEquipmenttypename() == null) ? 0 : getEquipmenttypename().hashCode());
        result = prime * result + ((getEquipmentvisible() == null) ? 0 : getEquipmentvisible().hashCode());
        result = prime * result + ((getErpcode() == null) ? 0 : getErpcode().hashCode());
        result = prime * result + ((getFactoryid() == null) ? 0 : getFactoryid().hashCode());
        result = prime * result + ((getFactoryname() == null) ? 0 : getFactoryname().hashCode());
        result = prime * result + ((getFactorysort() == null) ? 0 : getFactorysort().hashCode());
        result = prime * result + ((getFactoryvisible() == null) ? 0 : getFactoryvisible().hashCode());
        result = prime * result + ((getGraphtype() == null) ? 0 : getGraphtype().hashCode());
        result = prime * result + ((getGroupid() == null) ? 0 : getGroupid().hashCode());
        result = prime * result + ((getGroupname() == null) ? 0 : getGroupname().hashCode());
        result = prime * result + ((getGroupsort() == null) ? 0 : getGroupsort().hashCode());
        result = prime * result + ((getGroupvisible() == null) ? 0 : getGroupvisible().hashCode());
        result = prime * result + ((getManufacturer() == null) ? 0 : getManufacturer().hashCode());
        result = prime * result + ((getMhost() == null) ? 0 : getMhost().hashCode());
        result = prime * result + ((getMport() == null) ? 0 : getMport().hashCode());
        result = prime * result + ((getNodehost() == null) ? 0 : getNodehost().hashCode());
        result = prime * result + ((getNodeid() == null) ? 0 : getNodeid().hashCode());
        result = prime * result + ((getNodeport() == null) ? 0 : getNodeport().hashCode());
        result = prime * result + ((getNodetype() == null) ? 0 : getNodetype().hashCode());
        result = prime * result + ((getRev() == null) ? 0 : getRev().hashCode());
        result = prime * result + ((getSamplingfreq() == null) ? 0 : getSamplingfreq().hashCode());
        result = prime * result + ((getSamplingnumber() == null) ? 0 : getSamplingnumber().hashCode());
        result = prime * result + ((getUnitid() == null) ? 0 : getUnitid().hashCode());
        result = prime * result + ((getUnitname() == null) ? 0 : getUnitname().hashCode());
        result = prime * result + ((getUnitsort() == null) ? 0 : getUnitsort().hashCode());
        result = prime * result + ((getUnitvisible() == null) ? 0 : getUnitvisible().hashCode());
        result = prime * result + ((getUpdatetime() == null) ? 0 : getUpdatetime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", equipmentuuid=").append(equipmentuuid);
        sb.append(", alarmalias=").append(alarmalias);
        sb.append(", alarmid=").append(alarmid);
        sb.append(", alarmlevel=").append(alarmlevel);
        sb.append(", alarmstatus=").append(alarmstatus);
        sb.append(", companyid=").append(companyid);
        sb.append(", companyname=").append(companyname);
        sb.append(", companyno=").append(companyno);
        sb.append(", companysort=").append(companysort);
        sb.append(", companyvisible=").append(companyvisible);
        sb.append(", datatype=").append(datatype);
        sb.append(", drivename=").append(drivename);
        sb.append(", drivetype=").append(drivetype);
        sb.append(", equipmentid=").append(equipmentid);
        sb.append(", equipmentindex=").append(equipmentindex);
        sb.append(", equipmentname=").append(equipmentname);
        sb.append(", equipmentno=").append(equipmentno);
        sb.append(", equipmentsort=").append(equipmentsort);
        sb.append(", equipmenttype=").append(equipmenttype);
        sb.append(", equipmenttypename=").append(equipmenttypename);
        sb.append(", equipmentvisible=").append(equipmentvisible);
        sb.append(", erpcode=").append(erpcode);
        sb.append(", factoryid=").append(factoryid);
        sb.append(", factoryname=").append(factoryname);
        sb.append(", factorysort=").append(factorysort);
        sb.append(", factoryvisible=").append(factoryvisible);
        sb.append(", graphtype=").append(graphtype);
        sb.append(", groupid=").append(groupid);
        sb.append(", groupname=").append(groupname);
        sb.append(", groupsort=").append(groupsort);
        sb.append(", groupvisible=").append(groupvisible);
        sb.append(", manufacturer=").append(manufacturer);
        sb.append(", mhost=").append(mhost);
        sb.append(", mport=").append(mport);
        sb.append(", nodehost=").append(nodehost);
        sb.append(", nodeid=").append(nodeid);
        sb.append(", nodeport=").append(nodeport);
        sb.append(", nodetype=").append(nodetype);
        sb.append(", rev=").append(rev);
        sb.append(", samplingfreq=").append(samplingfreq);
        sb.append(", samplingnumber=").append(samplingnumber);
        sb.append(", unitid=").append(unitid);
        sb.append(", unitname=").append(unitname);
        sb.append(", unitsort=").append(unitsort);
        sb.append(", unitvisible=").append(unitvisible);
        sb.append(", updatetime=").append(updatetime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}