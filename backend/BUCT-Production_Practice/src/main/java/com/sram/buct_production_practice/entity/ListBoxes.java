package com.sram.buct_production_practice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListBoxes implements Serializable {
    private String ypos;

    private String width;

    private String xpos;

    private String height;

    private List<ListBoxesPoints> points;

    private static final long serialVersionUID = 1L;

    public void setList(GraphDataListboxes graphDataListboxes){
        this.ypos=graphDataListboxes.getYpos();
        this.width=graphDataListboxes.getWidth();
        this.xpos=graphDataListboxes.getXpos();
        this.height=graphDataListboxes.getHeight();
    }


}
