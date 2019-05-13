package com.vaadin.components;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.themes.ValoTheme;

import javax.swing.*;

public class Header extends HorizontalLayout {
    Label label;

    public Header(){
        label = new Label("Анализ рисков");
        label.setStyleName(ValoTheme.LABEL_H2);
        addComponent(label);
        setComponentAlignment(label, Alignment.TOP_LEFT);
        setWidth("85%");
    }
}
