package com.vaadin.components;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.themes.ValoTheme;

import javax.swing.*;

public class Header extends HorizontalLayout {
    Label label;

    public Header(){
        Label icon = new Label();
        icon.setContentMode(ContentMode.HTML);
        icon.setValue(VaadinIcons.LIGHTBULB.getHtml());
        icon.setStyleName(ValoTheme.LABEL_H2);
        addComponent(icon);
        label = new Label("Программа идентификации и оценки рисков");
        label.setStyleName(ValoTheme.LABEL_H2);
        addComponent(label);
        setComponentAlignment(label, Alignment.TOP_LEFT);
        setWidth("85%");
        setExpandRatio(label, 1);
    }
}
