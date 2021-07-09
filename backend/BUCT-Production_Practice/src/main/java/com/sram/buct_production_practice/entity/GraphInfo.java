package com.sram.buct_production_practice.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * graph_info
 * @author 
 */
@ApiModel(value="概貌图信息")
@Data
public class GraphInfo implements Serializable {
    @ApiModelProperty("设备唯一标识")
    private String equipmentuuid;
    @ApiModelProperty("测点框字体大小")
    private Integer fontsize;
    @ApiModelProperty("概貌图ID")
    private Integer graphid;
    @ApiModelProperty("概貌图背景色")
    private String graphimagebackground;
    @ApiModelProperty("概貌图")
    private String graphimagebase64code;
    @ApiModelProperty("概貌图高度")
    private Integer graphimageheight;
    @ApiModelProperty("概貌图宽度")
    private Integer graphimagewidth;

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
        GraphInfo other = (GraphInfo) that;
        return (this.getEquipmentuuid() == null ? other.getEquipmentuuid() == null : this.getEquipmentuuid().equals(other.getEquipmentuuid()))
            && (this.getFontsize() == null ? other.getFontsize() == null : this.getFontsize().equals(other.getFontsize()))
            && (this.getGraphid() == null ? other.getGraphid() == null : this.getGraphid().equals(other.getGraphid()))
            && (this.getGraphimagebackground() == null ? other.getGraphimagebackground() == null : this.getGraphimagebackground().equals(other.getGraphimagebackground()))
            && (this.getGraphimagebase64code() == null ? other.getGraphimagebase64code() == null : this.getGraphimagebase64code().equals(other.getGraphimagebase64code()))
            && (this.getGraphimageheight() == null ? other.getGraphimageheight() == null : this.getGraphimageheight().equals(other.getGraphimageheight()))
            && (this.getGraphimagewidth() == null ? other.getGraphimagewidth() == null : this.getGraphimagewidth().equals(other.getGraphimagewidth()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getEquipmentuuid() == null) ? 0 : getEquipmentuuid().hashCode());
        result = prime * result + ((getFontsize() == null) ? 0 : getFontsize().hashCode());
        result = prime * result + ((getGraphid() == null) ? 0 : getGraphid().hashCode());
        result = prime * result + ((getGraphimagebackground() == null) ? 0 : getGraphimagebackground().hashCode());
        result = prime * result + ((getGraphimagebase64code() == null) ? 0 : getGraphimagebase64code().hashCode());
        result = prime * result + ((getGraphimageheight() == null) ? 0 : getGraphimageheight().hashCode());
        result = prime * result + ((getGraphimagewidth() == null) ? 0 : getGraphimagewidth().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", equipmentuuid=").append(equipmentuuid);
        sb.append(", fontsize=").append(fontsize);
        sb.append(", graphid=").append(graphid);
        sb.append(", graphimagebackground=").append(graphimagebackground);
        sb.append(", graphimagebase64code=").append(graphimagebase64code);
        sb.append(", graphimageheight=").append(graphimageheight);
        sb.append(", graphimagewidth=").append(graphimagewidth);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}