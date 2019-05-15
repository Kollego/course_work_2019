package com.vaadin.components.init;

import com.vaadin.backend.DataProviderHelper;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

public class InitControl extends VerticalLayout implements View {

    Button addButton;
    Button addFromDBButton;
    Navigator navigator;

    public InitControl(Navigator navigator){
        setWidth("100%");
        createElements();
        this.navigator = navigator;
    }

    void createElements(){
        

      /*  TextField projectNameField = new TextField("Название проекта");
        projectNameField.addValueChangeListener(event -> {
           if(event.getValue() != "") DataProviderHelper.setProjectName(event.getValue());
           else DataProviderHelper.setProjectName("Проект");
        });

        addComponent(projectNameField);
*/
        addButton = new Button("Добавить риск");
        addButton.setIcon(VaadinIcons.FILE_ADD);
        addButton.setStyleName(ValoTheme.BUTTON_LARGE);
        addFromDBButton = new Button("Предложить риски");
        addFromDBButton.setIcon(VaadinIcons.FILE_SEARCH);
        addFromDBButton.setStyleName(ValoTheme.BUTTON_LARGE);
        setSizeUndefined();
        addButton.setWidth("100%");
        addFromDBButton.setWidth("100%");

        addComponent(addButton);
        addComponent(addFromDBButton);
        TextArea tA = new TextArea();
        tA.setValue("Для редактирования названия дважды нажмите на него");
        tA.setHeight("86px");
        tA.setWidth("100%");
        tA.setEnabled(false);
        addComponent(tA);

        addButton.addClickListener(event -> {navigator.navigateTo("AddForm");});
        addFromDBButton.addClickListener(event -> navigator.navigateTo("AddDB"));

    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }
}
