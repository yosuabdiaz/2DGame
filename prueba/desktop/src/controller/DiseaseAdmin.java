package controller;

import Utils.DiseaseReader;
import model.*;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;
import model.actions.Action;
import model.actions.MeditationAction;
import org.lwjgl.Sys;
import View.mainView;

public class DiseaseAdmin {

    private static Date diseaseStarted;
    private static ArrayList<Disease> diseaseList = new ArrayList<>();

    public static Date getDiseaseStarted() {
        return diseaseStarted;
    }

    public static void setDiseaseStarted(Date diseaseStarted) {
        DiseaseAdmin.diseaseStarted = diseaseStarted;
    }

    public static ArrayList<Disease> getDiseaseList() {
        return diseaseList;
    }

    private static void setDiseaseList(ArrayList<Disease> list){
        diseaseList = list;
    }

    public void getRandomDisease(){

    }

    public static void evaluateHealth(Player player, Date now){

        for (Disease disease : diseaseList){
            if(checkDisease(disease.getTriggers(), player)){
                if(mainView.getInstance().getMyGameScreen().AcceptDisease()) {
                    diseaseStarted = now;
                    setDiseaseToPlayer(disease, player);


                }
                return;
            }
        }
    }

    public static void cure(Player player, Cure cure){
        if(player.getDisease() == null){
            return;
        }
        ArrayList<Cure> cures = player.getDisease().getCures();
        for(Cure bombastic:cures){
            if(bombastic.getName().equals(cure.getName())){
                cleanStatusPlayer(player);
            }
        }
    }

    private static void cleanStatusPlayer(Player player) {
        ArrayList<Stats> toUpperStats = new ArrayList<Stats>(player.getDisease().getEffects().keySet());
        for(Stats stat:toUpperStats){
            updateState(player,stat);
        }
        player.setDisease(null);
        diseaseStarted = null;
    }

    private static void updateState(Player player, Stats stats){
        switch (stats){
            case SLEEP:
                player.setSleep(0);
                break;
            case HUNGER:
                player.setHunger(0);
                break;
            case RETAINED_LIQUIDS:
                player.setRetainedLiquids(0);
                break;
            case EATEN_FOOD:
                player.setEatenFood(0);
                break;
            case HAPPINESS:
                player.setMentalHealth(50);
                break;
            case MUSCLES:
                player.setMuscles(0);
                break;
            case SPEED:
                player.setSpeed(1f);
                break;
            case STRENGTH:
                player.setStrength(0);
                break;
            case FATNESS:
                player.setFatness(0);
                break;
            case MENTAL_HEALTH:
                player.setMentalHealth(50);
                break;
            case PHYSICAL_HEALTH:
                player.setPhysicalHealth(50);
                break;
            case MEDITATION:
                break;
        }
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

    public static void chargeData(){
        /*File folder = new File(Configuration.getInstance().getDiseasePath());
        File[] files = folder.listFiles();
        DiseaseReader r = new DiseaseReader();
        if(files != null){
            for(File f : files) {
                System.out.println(f);
                Disease disease = r.read(f.getPath());
                if (disease != null) {
                    diseaseList.add(disease);
                }
            }
        }*/
        addDummyDisease();
    }

    private static void addDummyDisease() {
        Disease disease = new Disease();
        disease.setName("Demencia");
        disease.setSprite("demencia.png");
        ArrayList<Cure> cures = new ArrayList<>();
        cures.add(new MeditationAction());
        disease.setCures(cures);
        HashMap<Stats, DiseaseInfo> effects = new HashMap<>();
        effects.put(Stats.MENTAL_HEALTH, new DiseaseInfo(300,false));
        effects.put(Stats.FATNESS, new DiseaseInfo(80,true));
        disease.setEffects(effects);
        HashMap<Stats, DiseaseInfo> triggers = new HashMap<>();
        triggers.put(Stats.FATNESS,new DiseaseInfo(30,true));
        disease.setTriggers(triggers);
        diseaseList.add(disease);
        Disease disease2 = new Disease();
        disease2.setName("Vertigo");
        disease2.setSprite("vertigo.png");
        ArrayList<Cure> cures2 = new ArrayList<>();
        cures2.add(new Medicine("Acetaminofen",2));
        disease2.setCures(cures2);
        HashMap<Stats, DiseaseInfo> effects2 = new HashMap<>();
        effects2.put(Stats.MENTAL_HEALTH, new DiseaseInfo(300,false));
        disease2.setEffects(effects2);
        HashMap<Stats, DiseaseInfo> triggers2 = new HashMap<>();
        triggers2.put(Stats.FATNESS,new DiseaseInfo(15,true));
        disease2.setTriggers(triggers2);
        diseaseList.add(disease2);
    }

}
