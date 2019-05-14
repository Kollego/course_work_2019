package com.vaadin.components.init;

import com.vaadin.backend.DataProviderHelper;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;

public class InitControl extends CustomComponent implements View {

    Button addButton;
    Button addFromDBButton;
    VerticalLayout layout;
    Navigator navigator;

    public InitControl(Navigator navigator){
        createElements();
        this.navigator = navigator;
    }

    void createElements(){
        layout = new VerticalLayout();



        TextField projectNameField = new TextField("Название проекта");
        projectNameField.addValueChangeListener(event -> {
           if(event.getValue() != "") DataProviderHelper.setProjectName(event.getValue());
           else DataProviderHelper.setProjectName("Проект");
        });

        layout.addComponent(projectNameField);

        addButton = new Button("Добавить риск");
        addFromDBButton = new Button("Предложить риски");
        layout.setSizeUndefined();
        addButton.setWidth("100%");
        addFromDBButton.setWidth("100%");

        layout.addComponent(addButton);
        layout.addComponent(addFromDBButton);
        setCompositionRoot(layout);


        addButton.addClickListener(event -> {navigator.navigateTo("AddForm");});

    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }
}
