package com.vaadin.components.init;

import com.vaadin.backend.DataProviderHelper;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;


public class AddForm extends CustomComponent implements View {

    VerticalLayout layout;
    TextArea name;
    Button save;
    Button cancel;
    Navigator navigator;

    public AddForm(Navigator navigator)
    {
        createElements();
        this.navigator = navigator;
    }

    void createElements()
    {
        layout = new VerticalLayout();
        layout.setMargin(true);
        name = new TextArea("Название");
        layout.addComponent(name);
        name.setWidth("100%");
        save = new Button("Сохранить");
        save.setStyleName(ValoTheme.BUTTON_FRIENDLY);
        cancel = new Button("Отмена");
        cancel.setStyleName(ValoTheme.BUTTON_DANGER);
        HorizontalLayout controls = new HorizontalLayout(save, cancel);
        layout.addComponent(controls);
        controls.setWidth("100%");
        controls.setExpandRatio(cancel, 1);
        controls.setComponentAlignment(cancel, Alignment.TOP_RIGHT);
        setCompositionRoot(layout);

        configureElements();

        cancel.addClickListener(event -> navigator.navigateTo("Controls"));
    }

    private void configureElements()
    {
        save.addClickListener(event -> {
            if(!name.isEmpty())
            {
                DataProviderHelper.addRisk(name.getValue());
                name.setValue("");
                navigator.navigateTo("Controls");
            }
            else
            {
                Notification.show("Необходимо название!");
            }
        });
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        name.setCursorPosition(0);
    }
}
