package controller;

import model.*;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;

public class DiseaseAdmin {
    public static Date getDiseaseStarted() {
        return diseaseStarted;
    }

    public static void setDiseaseStarted(Date diseaseStarted) {
        DiseaseAdmin.diseaseStarted = diseaseStarted;
    }

    public static ArrayList<Disease> getDiseaseList() {
        return diseaseList;
    }

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
                setDiseaseToPlayer(disease, player);
                return;
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

    private ArrayList<Disease> chargeData(){
        File folder = new File(Configuration.getInstance().getDiseasePath());
        return null;
    }

}
