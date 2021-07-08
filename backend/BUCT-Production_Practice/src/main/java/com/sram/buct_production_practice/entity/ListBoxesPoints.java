package com.sram.buct_production_practice.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * list_boxes_points
 * @author 
 */
@ApiModel(value="测点框的内容")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListBoxesPoints implements Serializable {
    @ApiModelProperty("自增ID")
    private Integer id;
    @ApiModelProperty("测点ID")
    private String pointid;
    @ApiModelProperty("测点唯一标识")
    private String pointuuid;
    @ApiModelProperty("测点值")
    private String value;
    @ApiModelProperty("状态")
    private String status;
    @ApiModelProperty("测点哈希值")
    private String pointhash;
    @ApiModelProperty("设备唯一标识")
    private String equipmentuuid;

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
        ListBoxesPoints other = (ListBoxesPoints) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPointid() == null ? other.getPointid() == null : this.getPointid().equals(other.getPointid()))
            && (this.getPointuuid() == null ? other.getPointuuid() == null : this.getPointuuid().equals(other.getPointuuid()))
            && (this.getValue() == null ? other.getValue() == null : this.getValue().equals(other.getValue()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getPointhash() == null ? other.getPointhash() == null : this.getPointhash().equals(other.getPointhash()))
            && (this.getEquipmentuuid() == null ? other.getEquipmentuuid() == null : this.getEquipmentuuid().equals(other.getEquipmentuuid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPointid() == null) ? 0 : getPointid().hashCode());
        result = prime * result + ((getPointuuid() == null) ? 0 : getPointuuid().hashCode());
        result = prime * result + ((getValue() == null) ? 0 : getValue().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getPointhash() == null) ? 0 : getPointhash().hashCode());
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
        sb.append(", pointid=").append(pointid);
        sb.append(", pointuuid=").append(pointuuid);
        sb.append(", value=").append(value);
        sb.append(", status=").append(status);
        sb.append(", pointhash=").append(pointhash);
        sb.append(", equipmentuuid=").append(equipmentuuid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}