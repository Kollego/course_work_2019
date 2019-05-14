package com.vaadin.components;


import com.vaadin.backend.Risk;
import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;

public class RiskReport extends VerticalLayout {

    Grid<Risk> grid;

    public RiskReport(){
        grid = new Grid<>();
    }


}
