package com.vaadin.backend;

import java.util.ArrayList;

public class DBHandler {

    public static int addRisks(ArrayList<Integer> conf){
        int count = 0;
        ArrayList<PossibleRisk> risks = DBRisk.getRisks();
        for(PossibleRisk risk: risks){
            if(risk.getType() == conf.get(0) && !risk.isUsed()){
                for(Integer k: risk.criteria){
                    if(conf.contains(k)){
                        DataProviderHelper.addRisk(risk.getName(), risk.getDescription());
                        risk.setUsed(true);
                        count++;
                        break;
                    }
                }
            }
        }
        return count;
    }
}
