package com.vaadin.components;


import com.vaadin.backend.DataProviderHelper;
import com.vaadin.backend.Risk;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.FileDownloader;
import com.vaadin.server.StreamResource;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.vaadin.haijian.Exporter;

public class RiskReport extends VerticalLayout {

    private Grid<Risk> grid;
    private Label labelName;
    private String projectName;
    private StreamResource excelStreamResource;
    private StreamResource csvStreamResource;

    public RiskReport(){
        HorizontalLayout layout = new HorizontalLayout();
        labelName = new Label("Отчет по проекту");

        labelName.setStyleName(ValoTheme.LABEL_H3);
        layout.addComponent(labelName);
        Button downloadAsExcel = new Button("Скачать Excel");
        downloadAsExcel.setIcon(VaadinIcons.DOWNLOAD);

        Button downloadAsCSV = new Button("Скачать CSV");
        downloadAsCSV.setIcon(VaadinIcons.DOWNLOAD);

        layout.addComponent(downloadAsExcel);
        layout.addComponent(downloadAsCSV);

        addComponent(layout);
        addGrid();

        excelStreamResource = new StreamResource((StreamResource.StreamSource) () -> Exporter.exportAsExcel(grid),
                 "risk_report.xlsx");
        FileDownloader excelFileDownloader = new FileDownloader(excelStreamResource);
        excelFileDownloader.extend(downloadAsExcel);

        csvStreamResource = new StreamResource((StreamResource.StreamSource) () -> Exporter.exportAsCSV(grid),
                "risk_report.csv");
        FileDownloader csvFileDownloader = new FileDownloader(csvStreamResource);
        csvFileDownloader.extend(downloadAsCSV);

        layout.setWidth("100%");
        layout.setExpandRatio(downloadAsExcel, 1);
        layout.setComponentAlignment(downloadAsExcel, Alignment.TOP_RIGHT);

    }



    private void addGrid() {
        grid = new Grid<>(Risk.class);
        grid.setRowHeight(80);
        addComponent(grid);
        grid.setWidth("100%");

        grid.setDataProvider(DataProviderHelper.getDataProvider());
        grid.removeAllColumns();
        grid.addColumn("id").setCaption("№").setExpandRatio(1);
        grid.addComponentColumn(risk -> {
            Label label = new Label();
            label.setValue(risk.getName());
            label.setWidth("280px");
            label.setStyleName(ValoTheme.LAYOUT_HORIZONTAL_WRAPPING);
            return label;
        })
                .setCaption("Название")
                .setWidth(290);
        grid.addComponentColumn(risk -> {
            Label label = new Label();
            label.setValue(risk.getDescription());
            label.setWidth("280px");
            label.setStyleName(ValoTheme.LAYOUT_HORIZONTAL_WRAPPING);
            return label;
        })
                .setCaption("Описание")
                .setWidth(290);
        grid.addColumn("probability").setCaption("Вероятность").setExpandRatio(2);
        grid.addColumn("impact").setCaption("Воздействие").setExpandRatio(2);
        grid.addColumn("level").setCaption("Уровень риска").setExpandRatio(1);
        grid.addColumn("isCritical").setCaption("Критический риск").setExpandRatio(2);

    }
}
