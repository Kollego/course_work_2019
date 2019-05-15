package com.vaadin.components;

import com.vaadin.backend.DataProviderHelper;
import com.vaadin.backend.Risk;
import com.vaadin.components.init.*;
import com.vaadin.data.Binder;
import com.vaadin.data.Binder.Binding;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.Navigator;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

public class RiskInit extends HorizontalLayout {


    private Navigator navigator;
    private Panel panelForControl;


    public RiskInit(){
        setSizeFull();
        panelForControl = new Panel();
        addComponent(panelForControl);
        panelForControl.setWidth("100%");


        navigator = new Navigator(UI.getCurrent(), panelForControl);
        registerViews();

        Grid<Risk> grid = new Grid<>(Risk.class);

        grid.setDataProvider(DataProviderHelper.getDataProvider());
        addComponent(grid);
        grid.removeAllColumns();

        grid.addComponentColumn(risk -> {
            Button button = new Button("");
            button.addClickListener(click ->
                    DataProviderHelper.removeRisk(risk));
            button.setStyleName(ValoTheme.BUTTON_ICON_ONLY);
            button.setIcon(VaadinIcons.TRASH);
            button.setHeight("30px");
            return button;
        }).setExpandRatio(1);

        grid.addColumn("id").setCaption("№").setExpandRatio(1);
        //grid.addColumn("name").setCaption("Название").setExpandRatio(1);

        TextArea textArea = new TextArea();
        textArea.setWidth("80%");

        Binder<Risk> binder = grid.getEditor().getBinder();

        Binding<Risk, String> riskBinding = binder.bind(
                textArea, Risk::getName, Risk::setName);

        Grid.Column<Risk, String> column = grid.addColumn(
                risk -> risk.getName());
        column.setExpandRatio(24);
        column.setCaption("Название");
        column.setEditorBinding(riskBinding);


        grid.getEditor().setEnabled(true);
        grid.setSelectionMode(Grid.SelectionMode.SINGLE);


        for(Grid.Column c: grid.getColumns())
        {
            c.setResizable(false);
        }
        grid.setSizeFull();
        setExpandRatio(panelForControl, 1.2f);
        setExpandRatio(grid,3);
        setHeight("500px");
        panelForControl.setHeight("100%");
        grid.setHeight("100%");



        navigator.navigateTo("Controls");
    }

    private void registerViews(){
        navigator.addView("AddForm", new AddForm(navigator));
        navigator.addView("Controls", new InitControl(navigator));
        navigator.addView("AddDB", new AddDB(navigator));
        navigator.addView("br", new BuisnessRisks(navigator));
        navigator.addView("tr", new TechRisks(navigator));
        navigator.addView("or", new OrgRisks(navigator));
        navigator.addView("pr", new ProjRisks(navigator));
    }
}
