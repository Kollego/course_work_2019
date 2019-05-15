package com.vaadin.components.init;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import org.apache.commons.compress.archivers.ar.ArArchiveEntry;

import java.util.ArrayList;

public class AddDB extends VerticalLayout implements View {

    private Button buisBut;
    private Button techBut;
    private Button orgBut;
    private  Button projBut;
    private ArrayList<Button> arBut;
    private Navigator navigator;

    public AddDB(Navigator navigator){
        this.navigator = navigator;
        Label l = new Label("Выберите тип рисков:");
        addComponent(l);
        l.setStyleName(ValoTheme.LABEL_H3);
        configBut();
    }

    private void configBut(){
        buisBut = new Button("Внешние");
        buisBut.setIcon(VaadinIcons.BRIEFCASE);
        buisBut.addClickListener(event -> navigator.navigateTo("br"));
        techBut = new Button("Технологические");
        techBut.setIcon(VaadinIcons.HAMMER);
        orgBut =  new Button("Организационные");
        orgBut.setIcon(VaadinIcons.USERS);
        projBut = new Button("Проектные");
        projBut.setIcon(VaadinIcons.TASKS);
        arBut = new ArrayList<>();
        arBut.add(buisBut);
        arBut.add(techBut);
        arBut.add(orgBut);
        arBut.add(projBut);
        for(Button b: arBut){
            addComponent(b);
            b.setWidth("100%");
        }
        Button back = new Button("Назад");
        addComponent(back);
        back.addClickListener(event -> navigator.navigateTo("Controls"));
        setComponentAlignment(back, Alignment.TOP_RIGHT);
        back.setStyleName(ValoTheme.BUTTON_DANGER);
    }


    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }
}
