package com.vaadin.components.init;

import com.vaadin.backend.DataProviderHelper;
import com.vaadin.backend.Risk;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

public class EditForm extends VerticalLayout implements View {

    TextArea name;
    TextArea description;
    Button save;
    Button cancel;
    TextField responsible;
    NativeSelect<String> category;

    static public Risk risk;
    
    Navigator navigator;

    public EditForm(Navigator navigator)
    {
        setWidth("100%");
        createElements();
        this.navigator = navigator;
    }

    void createElements()
    {
        setMargin(true);
        name = new TextArea("Название");

        addComponent(name);
        description = new TextArea("Описание");
        addComponent(description);
        name.setWidth("100%");
        name.setHeight("98px");
        description.setWidth("100%");
        description.setHeight("110px");
        responsible = new TextField("Ответсвенный за риск");
        addComponent(responsible);
        responsible.setWidth("100%");
        category = new NativeSelect<>("Категория риска");
        category.setItems("Внешний", "Технологический", "Организационный", "Проектный");
        category.setWidth("100%");
        addComponent(category);
        save = new Button("Изменить");
        save.setStyleName(ValoTheme.BUTTON_FRIENDLY);
        cancel = new Button("Назад");
        cancel.setStyleName(ValoTheme.BUTTON_DANGER);
        HorizontalLayout controls = new HorizontalLayout(save, cancel);
        addComponent(controls);
        controls.setWidth("100%");
        controls.setExpandRatio(cancel, 1);
        controls.setComponentAlignment(cancel, Alignment.TOP_RIGHT);


        configureElements();

        cancel.addClickListener(event -> navigator.navigateTo("Controls"));
    }

    private void configureElements()
    {
        save.addClickListener(event -> {
            if(!name.isEmpty() || !description.isEmpty())
            {

                risk.setName(name.getValue());
                risk.setDescription(description.getValue());
                risk.setResponsible(responsible.getValue());
                risk.setCategory(category.getValue());
                DataProviderHelper.getDataProvider().refreshAll();

                navigator.navigateTo("Controls");
            }
            else
            {
                Notification.show("Необходимо заполнить поля названия и описания!");
            }
        });
    }

    public static void setRisk(Risk risk1){
        risk = risk1;

    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

        name.setCursorPosition(0);
        name.setValue(risk.getName());
        description.setValue(risk.getName());
        responsible.setValue(risk.getResponsible());
        category.setValue(risk.getCategory());
    }
}

