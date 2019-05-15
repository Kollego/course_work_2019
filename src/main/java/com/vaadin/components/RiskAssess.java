package com.vaadin.components;

import com.vaadin.backend.DataProviderHelper;
import com.vaadin.backend.Risk;
import com.vaadin.components.asses.EditPanel;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

import java.util.Optional;

public class RiskAssess extends HorizontalLayout {


    EditPanel editPanel;

    public RiskAssess(){

        Grid<Risk> grid = new Grid<>(Risk.class);
        grid.setDataProvider(DataProviderHelper.getDataProvider());



        editPanel = new EditPanel();
        addComponent(editPanel);
        addComponent(grid);

        editPanel.setHeight("100%");
        grid.setHeight("100%");
        setWidth("100%");
        setWidth("100%");
        setExpandRatio(grid,3);
        grid.setWidth("100%");
        setExpandRatio(editPanel, 2);

        setHeight("500px");
        editPanel.setHeight("100%");
        grid.setHeight("100%");



        grid.addSelectionListener(event -> {
            Optional<Risk> selected = event.getFirstSelectedItem();
            if(selected.isPresent()) editPanel.setRisk(selected.get());
        });

        grid.removeAllColumns();
        grid.addColumn("id").setCaption("№");
        grid.addColumn("name")
                .setCaption("Название")
                .setWidth(360);
        grid.addColumn("probability").setCaption("Вероятность");
        grid.addColumn("impact").setCaption("Воздействие");
        grid.addColumn("level").setCaption("Уровень риска");

        for(Grid.Column c: grid.getColumns())
        {
            c.setResizable(false);
        }
        
    }

}
