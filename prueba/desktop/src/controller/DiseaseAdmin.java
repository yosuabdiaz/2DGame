package controller;

import model.Disease;
import model.DiseaseInfo;
import model.Player;
import model.Stats;

import javax.swing.*;
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

    public void getRandomDisease(){

    }

    public static void evaluateHealth(Player player, Date now){

        for (Disease disease : diseaseList){
            if(checkDisease(disease.getTriggers(), player)){

            }
        }
    }

    public static void cure(){
        diseaseStarted = null;
    }

    public static void setDiseaseToPlayer(Disease disease, Player player) {
        player.setDisease(disease);
        Set<Stats> keys = disease.getEffects().keySet();
        for(Stats key: keys){
            DiseaseInfo info = disease.getEffects().get(key);
            int stat = player.getIntegerStats(key);
            if(info.isUp()){
               int statValue = player.getIntegerStats(key);
               player.setIntegerStats(key, statValue + info.getPoint());
            }
            else if(stat < info.getPoint()){
                int statValue = player.getIntegerStats(key);
                player.setIntegerStats(key, statValue - info.getPoint());
            }
        }
    }

    private static boolean checkDisease(HashMap<Stats, DiseaseInfo> triggers, Player player){
        Set<Stats> keys = triggers.keySet();
        for(Stats key: keys){
            DiseaseInfo info = triggers.get(key);
            int stat = player.getIntegerStats(key);
            if(info.isUp() && stat > info.getPoint()){
                return true;
            }
            else if(stat < info.getPoint()){
                return true;
            }
        }
        return false;
    }


}
