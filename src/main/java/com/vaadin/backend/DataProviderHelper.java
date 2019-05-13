package com.vaadin.backend;

import com.vaadin.data.provider.DataProvider;
import com.vaadin.data.provider.ListDataProvider;

import java.util.ArrayList;
import java.util.List;

public class DataProviderHelper {


    private static List<Risk> listOfRisk;
    private static ListDataProvider<Risk>  RiskDataProvider;
    public static void InitProvider(){
        listOfRisk = new ArrayList<>();

        listOfRisk.add(new Risk(1, "a", "a", 1, 1));
        RiskDataProvider = DataProvider.ofCollection(listOfRisk);
    }
    public static ListDataProvider<Risk> getDataProvider(){
        return RiskDataProvider;
    }

    public static void addRisk(String name) {

        listOfRisk.add(new Risk(name));
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

    public static void changeProb(Risk risk, int prob){
        risk.setProbability(prob);
        RiskDataProvider.refreshAll();
    }

    public static void changeImp(Risk risk, int imp){
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
}
