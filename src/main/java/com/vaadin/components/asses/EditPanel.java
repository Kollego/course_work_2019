package com.vaadin.components.asses;


import com.vaadin.backend.DataProviderHelper;
import com.vaadin.backend.Risk;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

public class EditPanel extends Panel {

    VerticalLayout layout;
    Risk risk;
    TextArea name;

    public EditPanel(){
        layout = new VerticalLayout();
        setContent(layout);
        Label label = new Label("Для редактирования выберете риск из таблицы");
        label.setStyleName(ValoTheme.LABEL_H3);
        layout.addComponent(label);
        name = new TextArea();
        name.setEnabled(false);
        name.setWidth("100%");



        layout.addComponent(name);

        Slider slider1 = new Slider(1, 10);
        Slider slider2 = new Slider(1,10);
        TextArea descArea = new TextArea("Описание риска");

        name.addValueChangeListener(event -> {
            if(risk != null) {
                if(risk.getProbability() != null){
                    slider1.setValue(risk.getProbability().doubleValue());
                }
                else{
                    slider1.setValue(1d);
                }
                if(risk.getImpact() != null){
                    slider2.setValue(risk.getImpact().doubleValue());
                }
                else{
                    slider2.setValue(1d);
                }
                if(risk.getDescription() != null){
                    descArea.setValue(risk.getDescription());
                }
                else{
                    descArea.setValue("");
                }
            }
        });
        HorizontalLayout sliderLayout = new HorizontalLayout();
        VerticalLayout vl1 = new VerticalLayout(new Label("Вероятность (1..10)"), slider1);
        VerticalLayout vl2 = new VerticalLayout(new Label("Воздействие (1..10)"), slider2);
        vl1.setExpandRatio(slider1,1);
        vl2.setExpandRatio(slider2,1);
        sliderLayout.setWidth("100%");
        sliderLayout.setMargin(false);
        layout.setSpacing(false);
        vl1.setWidth("100%");
        vl2.setWidth("100%");
        slider1.setWidth("100%");
        slider2.setWidth("100%");
        sliderLayout.addComponents(vl1, vl2);
        layout.addComponent(sliderLayout);

        slider1.addValueChangeListener(event -> {
           if(risk != null) DataProviderHelper.changeProb(risk, event.getValue().intValue());
        });

        slider2.addValueChangeListener(event -> {
            if(risk != null) DataProviderHelper.changeImp(risk, event.getValue().intValue());
        });

        layout.addComponent(descArea);
        descArea.setWidth("100%");

        descArea.addValueChangeListener(event -> {
            if(risk != null) DataProviderHelper.changeDesc(risk, event.getValue());
        });
    }

    public void setRisk(Risk risk) {
        this.risk = risk;
        name.setValue(risk.getName());
    }
}
