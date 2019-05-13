package com.vaadin;

import com.vaadin.backend.DataProviderHelper;
import com.vaadin.components.*;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;

public class MainView extends VerticalLayout implements View {

	private static final long serialVersionUID = 1L;

	public MainView() {
		DataProviderHelper.InitProvider();

		Header header = new Header();
		addComponent(header);
		setComponentAlignment(header, Alignment.TOP_CENTER);

		TabSheet tabs =  new TabSheet();
		addComponent(tabs);
		tabs.setWidth("85%");
		setComponentAlignment(tabs, Alignment.TOP_CENTER);

		RiskInit riskInit = new RiskInit();
		tabs.addTab(riskInit, "Идентификация");

		RiskAssess riskAssess = new RiskAssess();
		tabs.addTab(riskAssess, "Оценка");

		RiskMap riskMap = new RiskMap();
		tabs.addTab(riskMap, "Карта рисков");

		RiskReport riskReport = new RiskReport();
		tabs.addTab(riskReport, "Отчет");

	}



	@Override
	public void enter(ViewChangeEvent event) {
		// Navigator method, no need to do anything here.
	}

}
