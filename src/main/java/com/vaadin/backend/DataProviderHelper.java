package com.vaadin.backend;

import com.vaadin.data.provider.DataProvider;
import com.vaadin.data.provider.ListDataProvider;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DataProviderHelper {

    private static String projectName = "my_project";
    private static List<Risk> listOfRisk;
    private static ListDataProvider<Risk>  RiskDataProvider;
    public static void InitProvider(){
        listOfRisk = new ArrayList<>();

        RiskDataProvider = DataProvider.ofCollection(listOfRisk);
    }
    public static ListDataProvider<Risk> getDataProvider(){
        return RiskDataProvider;
    }

    public static void addRisk(String name) {

        listOfRisk.add(new Risk(name));
        RiskDataProvider.refreshAll();
    }
    public static void addRisk(String name, String description) {

        listOfRisk.add(new Risk(name, description));
        RiskDataProvider.refreshAll();
    }
    public static void addRisk(String name, String description, String responsible, String category) {

        listOfRisk.add(new Risk(name, description, responsible, category));
        RiskDataProvider.refreshAll();
    }

    public static void removeRisk(Risk risk){
        listOfRisk.remove(risk);
        refreshID();
        RiskDataProvider.refreshAll();
    }
    public static void refreshID(){
        for (Risk r: listOfRisk) {
            r.setId(listOfRisk.indexOf(r) + 1);
        }
    }

    public static void changeProb(Risk risk, double prob){
        risk.setProbability(prob);
        RiskDataProvider.refreshAll();
    }

    public static void changeImp(Risk risk, double imp){
        risk.setImpact(imp);
        RiskDataProvider.refreshAll();
    }

    public static void changeDesc(Risk risk, String desc){
        risk.setDescription(desc);
        RiskDataProvider.refreshAll();
    }

    public static List<Risk> getListOfRisk() {
        return listOfRisk;
    }
    public static int getRiskCount(){
        return listOfRisk.size();
    }

    public static String getProjectName() {
        return projectName;
    }

    public static void setProjectName(String projectName) {
        DataProviderHelper.projectName = projectName;
    }
}
