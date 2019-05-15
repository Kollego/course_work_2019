package com.vaadin.components.asses;


import com.vaadin.backend.DataProviderHelper;
import com.vaadin.backend.Risk;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

public class EditPanel extends Panel {

    VerticalLayout layout;
    Risk risk;
    Label name;
    TextArea descArea;

    public EditPanel(){
        layout = new VerticalLayout();
        setContent(layout);
        Label label = new Label("Для редактирования выберете риск из таблицы");
        label.setStyleName(ValoTheme.LABEL_H3);
        layout.addComponent(label);
        name = new Label();
        name.setWidth("200px");
        name.setWidth("100%");
        name.setStyleName(ValoTheme.LAYOUT_HORIZONTAL_WRAPPING);



        layout.addComponent(name);

        Slider slider1 = new Slider(0, 1, 1);
        slider1.setEnabled(false);
        Slider slider2 = new Slider(0,1,1);
        slider2.setEnabled(false);
        descArea = new TextArea("Описание риска");

        descArea.addValueChangeListener(event -> {
            slider1.setEnabled(true);
            slider2.setEnabled(true);
            if(risk != null) {
                if(risk.getProbability() != null){
                    slider1.setValue(risk.getProbability());
                }
                else{
                    slider1.setValue(0d);
                }
                if(risk.getImpact() != null){
                    slider2.setValue(risk.getImpact());
                }
                else{
                    slider2.setValue(0d);
                }
                if(risk.getDescription() != null){
                    name.setValue(risk.getName());
                }
                else{
                    name.setValue("");
                }
            }
        });
        HorizontalLayout sliderLayout = new HorizontalLayout();
        VerticalLayout vl1 = new VerticalLayout(new Label("Вероятность (0..1)"), slider1);
        VerticalLayout vl2 = new VerticalLayout(new Label("Воздействие (0..1)"), slider2);
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
           if(risk != null) DataProviderHelper.changeProb(risk, event.getValue());
        });

        slider2.addValueChangeListener(event -> {
            if(risk != null) DataProviderHelper.changeImp(risk, event.getValue());
        });

        layout.addComponent(descArea);
        descArea.setWidth("100%");

        descArea.addValueChangeListener(event -> {
            if(risk != null) DataProviderHelper.changeDesc(risk, event.getValue());
        });
    }

    public void setRisk(Risk risk) {
        this.risk = risk;
        descArea.setValue(risk.getDescription());
    }
}
