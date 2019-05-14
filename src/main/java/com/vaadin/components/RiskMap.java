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

public class RiskMap extends HorizontalLayout {

    private Chart chart;
    private Slider slider;
    private Panel panel;
    private Grid<Risk> grid;
    private ListDataProvider<Risk> dataProvider;

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
        slider = new Slider(1, 100);
        slider.setOrientation(SliderOrientation.VERTICAL);
        slider.setHeight("100%");

        layout.addComponent(slider);
        layout.setExpandRatio(slider, 1);
        slider.setValue(50d);
        slider.setDescription("Изменить границу зоны критических рисков");

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

        grid.addColumn("id").setCaption("№");
        grid.addColumn("name")
                .setCaption("Название")
                .setExpandRatio(1);
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
        xAxis.setMax(10);
        xAxis.setAllowDecimals(false);
        Labels xlabels = xAxis.getLabels();
        xlabels.setStep(1);
        xAxis.setLabels(xlabels);
        conf.addxAxis(xAxis);

        YAxis yAxis = new YAxis();
        yAxis.setTitle("Воздействие");
        yAxis.setMin(1);
        yAxis.setMax(10);
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

        for(Risk risk: DataProviderHelper.getListOfRisk()){
            DataSeriesItem point = new DataSeriesItem(risk.getProbability(), risk.getImpact());
            Marker marker = new Marker();
            marker.setRadius(10);
            point.setMarker(marker);
            point.setName(String.valueOf(risk.getId()));
            series.add(point);
        }


        DataSeries polygon = new DataSeries();
        PlotOptionsPolygon plotOptionsPolygon = new PlotOptionsPolygon();
        plotOptionsPolygon.setEnableMouseTracking(false);
        plotOptionsPolygon.setColor(new SolidColor("#ff7062"));
        polygon.setPlotOptions(plotOptionsPolygon);
        polygon.setName("Зона критических рисков");
        int sliderValue = slider.getValue().intValue();
        for(int i=1; i<=10; i++){
            int j = sliderValue/i;
            if(i * j < sliderValue) j++;
            if(j <= 10) {
                if(i == 1)
                    polygon.add(new DataSeriesItem(i, 10));
                polygon.add(new DataSeriesItem(i, j));

            }
            else {
                int jj = sliderValue/(i+1);
                if((i+1) * jj < sliderValue) jj++;
                if(jj < 10){
                    polygon.add(new DataSeriesItem(i+1, 10));
                }
            }
        }
        if(sliderValue > 90)
        {
            polygon.add(new DataSeriesItem(9.5, 10));
            polygon.add(new DataSeriesItem(10, 9.5));
        }
        polygon.add(new DataSeriesItem(10,10));
        conf.addSeries(polygon);

        conf.addSeries(series);

        chart.drawChart(conf);
    }
}
