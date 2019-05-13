package com.vaadin.components.init;

import com.vaadin.backend.DataProviderHelper;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.VerticalLayout;

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
        addButton = new Button("Добавить риск");
        addFromDBButton = new Button("Предложить риски");
        layout.setSizeUndefined();
        addButton.setWidth("80%");
        addFromDBButton.setWidth("80%");

        layout.addComponent(addButton);
        layout.addComponent(addFromDBButton);
        setCompositionRoot(layout);

        addButton.addClickListener(event -> {navigator.navigateTo("AddForm");});

    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }
}
