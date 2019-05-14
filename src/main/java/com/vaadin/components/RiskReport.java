package com.vaadin.components;


import com.vaadin.backend.DataProviderHelper;
import com.vaadin.backend.Risk;
import com.vaadin.data.Binder;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;

public class RiskReport extends VerticalLayout {

    Grid<Risk> grid;

    public RiskReport(){
        HorizontalLayout layout = new HorizontalLayout();

        addGrid();
    }

    private void addGrid() {
        grid = new Grid<>(Risk.class);
        addComponent(grid);
        grid.setWidth("100%");

        grid.setDataProvider(DataProviderHelper.getDataProvider());
        grid.removeAllColumns();
        grid.addColumn("id").setCaption("№");
        grid.addColumn("name").setCaption("Название").setExpandRatio(1);
        grid.addColumn("description").setCaption("Описание").setExpandRatio(1);
        grid.addColumn("probability").setCaption("Вероятность");
        grid.addColumn("impact").setCaption("Воздействие");
        grid.addColumn("level").setCaption("Уровень риска");
        grid.addColumn("isCritical").setCaption("Критический риск");


        for(Grid.Column c: grid.getColumns())
        {
            c.setResizable(false);
        }
    }
}
