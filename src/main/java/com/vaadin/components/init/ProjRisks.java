package com.vaadin.components.init;

import com.vaadin.backend.DBHandler;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import java.util.ArrayList;

public class ProjRisks extends VerticalLayout implements View {

    Navigator navigator;

    public ProjRisks(Navigator navigator) {
        this.navigator = navigator;
        Label l = new Label("Проектные риски");
        l.setStyleName(ValoTheme.LABEL_H3);
        addComponent(l);
        RadioButtonGroup<String> r1 = new RadioButtonGroup<>();
        r1.setItems("Да", "Нет");
        r1.setCaption("Тщательно ли составлена проектная документация?");
        addComponent(r1);

        RadioButtonGroup<String> r2 = new RadioButtonGroup<>();
        r2.setItems("Да", "Нет");
        r2.setCaption("Четко ли поставлены требования к проекту?");
        addComponent(r2);

        Button save = new Button("Добавить");
        save.setStyleName(ValoTheme.BUTTON_FRIENDLY);
        Button cancel = new Button("Назад");
        cancel.setStyleName(ValoTheme.BUTTON_DANGER);
        HorizontalLayout controls = new HorizontalLayout(save, cancel);
        addComponent(controls);
        controls.setWidth("100%");
        controls.setExpandRatio(cancel, 1);
        controls.setComponentAlignment(cancel, Alignment.TOP_RIGHT);

        cancel.addClickListener(event -> navigator.navigateTo("AddDB"));

        ArrayList<Integer> conf = new ArrayList<>();

        save.addClickListener(event -> {
            conf.clear();
            conf.add(4);
            if(r1.getValue() == "Нет") conf.add(5);
            if(r2.getValue() == "Нет") conf.add(6);
            conf.add(7);
            Notification.show("Добавлено рисков: " + DBHandler.addRisks(conf));
            navigator.navigateTo("Controls");
        });

    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }

}