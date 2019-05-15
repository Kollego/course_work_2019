package com.vaadin.components.init;

import com.vaadin.backend.DBHandler;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import java.util.ArrayList;

public class OrgRisks extends VerticalLayout implements View {

    Navigator navigator;

    public OrgRisks(Navigator navigator) {
        this.navigator = navigator;
        Label l = new Label("Организационные риски");
        l.setStyleName(ValoTheme.LABEL_H3);
        addComponent(l);
        RadioButtonGroup<String> r1 = new RadioButtonGroup<>();
        r1.setItems("Да", "Нет");
        r1.setCaption("Сильно ли сжаты сроки разработки?");
        addComponent(r1);

        Slider s1 = new Slider(1,3);
        s1.setCaption("Сплоченность коллектива (1-3):");
        s1.setWidth("100%");
        s1.setValue(2d);
        addComponent(s1);

        Slider s2 = new Slider(1,3);
        s2.setCaption("Трудовой стаж менеджера (1-3):");
        s2.setWidth("100%");
        s2.setValue(2d);
        addComponent(s2);



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
            conf.add(3);
            if (r1.getValue() == "Да") conf.add(5);
            conf.add(5 + s1.getValue().intValue());
            conf.add(8 + s2.getValue().intValue());
            navigator.navigateTo("Controls");
            Notification.show("Добавлено рисков: " + DBHandler.addRisks(conf));
        });

    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }

}
