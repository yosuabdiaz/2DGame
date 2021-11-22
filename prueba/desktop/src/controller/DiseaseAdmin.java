package controller;

import model.Disease;
import model.Player;
import model.Stats;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;

public class DiseaseAdmin {

    private static Date diseaseStarted;
    private static ArrayList<Disease> diseaseList;

    private static void setDiseaseList(ArrayList<Disease> list){
        diseaseList = list;
    }

    public static void evaluateHealth(Player player, Date now){
        for (Disease disease : diseaseList){

        }
    }

    public static void cure(){
        diseaseStarted = null;
    }

    private boolean checkDisease(HashMap<Stats, Integer> triggers, Player player){
        Set<Stats> keys = triggers.keySet();
        for(Stats key: keys){

        }
        return false;
    }


}
