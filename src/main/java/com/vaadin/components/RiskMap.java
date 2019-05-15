package com.vaadin.components;

import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.model.*;
import com.vaadin.addon.charts.model.style.SolidColor;
import com.vaadin.backend.DataProviderHelper;
import com.vaadin.backend.Risk;
import com.vaadin.data.provider.DataProvider;
import com.vaadin.data.provider.GridSortOrder;
import com.vaadin.data.provider.ListDataProvider;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.shared.ui.slider.SliderOrientation;
import com.vaadin.ui.*;
import com.vaadin.ui.Label;
import com.vaadin.ui.themes.ValoTheme;

import java.util.ArrayList;


public class RiskMap extends HorizontalLayout {

    private Chart chart;
    private Slider slider;
    private Panel panel;
    private Grid<Risk> grid;
    private ListDataProvider<Risk> dataProvider;
    private String[][] dots;

    public RiskMap(){


        setWidth("100%");

        panel = new Panel();
        addComponent(panel);
        panel.setWidth("510px");
        panel.setHeight("510px");
        addChart();
        Button button = new Button("");
        button.setIcon(VaadinIcons.REFRESH);
        VerticalLayout layout = new VerticalLayout();
        button.setStyleName(ValoTheme.BUTTON_FRIENDLY);
        layout.addComponent(button);
        layout.setHeight("100%");
        button.setDescription("Обновить карту рисков и таблицу");
        button.addClickListener(event -> {
            addChart();
            refreshChart();
            refreshGrid();
            grid.setSortOrder(GridSortOrder.desc(grid.getColumn("level")));
        });
        slider = new Slider(0, 1, 2);
        slider.setOrientation(SliderOrientation.VERTICAL);
        slider.setHeight("100%");

        layout.addComponent(slider);
        layout.setExpandRatio(slider, 1);
        slider.setValue(0.5);
        slider.setDescription("Изменить границу зоны критических рисков");

        Label sliderV = new Label("0.5");
        slider.addValueChangeListener(event -> {sliderV.setValue(event.getValue().toString());});
        layout.addComponent(sliderV);

        addComponent(layout);
        setExpandRatio(layout, 1);
        setComponentAlignment(layout, Alignment.TOP_CENTER);

        grid = new Grid<>(Risk.class);


        grid.setWidth("98%");
        grid.setHeight("100%");

        for(Grid.Column c: grid.getColumns())
        {
            c.setResizable(false);
        }

        VerticalLayout layoutGrid = new VerticalLayout();
        Label l = new Label("Критические риски в порядке убывания уровня");
        l.setStyleName(ValoTheme.LABEL_H3);
        layoutGrid.addComponent(l);
        layoutGrid.addComponent(grid);
        layoutGrid.setMargin(false);
        addComponent(layoutGrid);
        setExpandRatio(layoutGrid, 6);



    }

    public void refreshGrid(){
        dataProvider = DataProvider.ofCollection(DataProviderHelper.getListOfRisk());
        grid.setDataProvider(dataProvider);

        grid.removeAllColumns();
        grid.setRowHeight(110);

        grid.addColumn("id").setCaption("№");
        grid.addComponentColumn(risk -> {
            Label label = new Label();
            label.setValue(risk.getName());
            label.setWidth("215px");
            label.setStyleName(ValoTheme.LAYOUT_HORIZONTAL_WRAPPING);
            return label;
        })
                .setCaption("Название")
                .setWidth(220);
        grid.addColumn("probability").setCaption("Вероятность");
        grid.addColumn("impact").setCaption("Воздействие");
        grid.addColumn("level").setCaption("Уровень риска");

        dataProvider.setFilter(risk -> filterRisk(risk));



    }

    private boolean filterRisk(Risk risk){
        if(risk.getLevel() >= slider.getValue()) {
            risk.setisCritical("Да");
            return true;
        }
        else{
            risk.setisCritical("Нет");
            return false;
        }
    }

    public void addChart(){
        chart = new Chart(ChartType.SCATTER);
        chart.setWidth("500px");
        chart.setHeight("500px");
        panel.setContent(chart);

        Configuration conf = chart.getConfiguration();
        conf.setTitle("Карта рисков");

        PlotOptionsScatter options = new PlotOptionsScatter();

        conf.setPlotOptions(options);

        Tooltip tooltip = new Tooltip();
        tooltip.setFormatter("'<b> Риск № '+ this.point.name +'</b>'");
        conf.setTooltip(tooltip);



        XAxis xAxis = new XAxis();
        xAxis.setTitle("Вероятность");
        xAxis.setMin(0);
        xAxis.setMax(1);
        xAxis.setTickInterval(0.1);
        xAxis.setAllowDecimals(false);
        Labels xlabels = xAxis.getLabels();
        xlabels.setStep(1);
        xAxis.setLabels(xlabels);
        conf.addxAxis(xAxis);

        YAxis yAxis = new YAxis();
        yAxis.setTitle("Воздействие");
        yAxis.setMin(0);
        yAxis.setMax(1);
        yAxis.setTickInterval(0.1);
        Labels ylabels = yAxis.getLabels();
        ylabels.setStep(1);
        yAxis.setLabels(ylabels);
        conf.addyAxis(yAxis);


        chart.drawChart(conf);


    }
    public void refreshChart(){
        Configuration conf = chart.getConfiguration();
        conf.disableCredits();
        DataSeries series = new DataSeries();
        series.setName("Риски");

        dots = new String[12][12];
        for(int i=0; i<= 10; i++){
            for(int j=0; j<= 10; j++){
                dots[i][j] = "";
            }
        }

        for(Risk risk: DataProviderHelper.getListOfRisk()){
            if(risk.getProbability() == null || risk.getImpact() == null)
                continue;
            if(dots[(int)(risk.getProbability()*10)][(int)(risk.getImpact()*10)] == "") {
                dots[(int)(risk.getProbability()*10)][(int)(risk.getImpact()*10)] = String.valueOf(risk.getId());
            }
            else{
                dots[(int)(risk.getProbability()*10)][(int)(risk.getImpact()*10)] += ", " + risk.getId();
            }
        }
        for(int i=0; i<= 10; i++){
            for(int j=0; j<= 10; j++){
               if(dots[i][j] != "")
               {
                   DataSeriesItem point = new DataSeriesItem((double)(i)/10d, (double)(j)/10d);
                   Marker marker = new Marker();
                   marker.setRadius(10);
                   point.setMarker(marker);
                   point.setName(dots[i][j]);
                   series.add(point);
               }

            }
        }


        DataSeries polygon = new DataSeries();
        PlotOptionsPolygon plotOptionsPolygon = new PlotOptionsPolygon();
        plotOptionsPolygon.setEnableMouseTracking(false);
        plotOptionsPolygon.setColor(new SolidColor("#ff7062"));
        polygon.setPlotOptions(plotOptionsPolygon);
        polygon.setName("Зона критических рисков");
        double sliderValue = slider.getValue();
        if(sliderValue != 0d) {
            for (double i = 0.01; i <= 1; i += 0.01) {

                double j = sliderValue / i;
                j *= 10000;
                j = Math.round(j);
                j /= 10000;
                if (j <= 1) {
                    polygon.add(new DataSeriesItem(i, j));
                }
            }
        }
        if(sliderValue > 0.9)
        {
            polygon.add(new DataSeriesItem(0.95, 1));
            polygon.add(new DataSeriesItem(1, 0.95));
        }
        polygon.add(new DataSeriesItem(1,1));
        conf.addSeries(polygon);

        conf.addSeries(series);

        chart.drawChart(conf);
    }
}
