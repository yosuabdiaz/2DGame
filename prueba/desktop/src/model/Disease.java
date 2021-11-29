package model;

import model.actions.GameContex;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Disease implements GameContex, Serializable {
        private String name;
        private String sprite;
        private ArrayList<Cure> cures;
        private HashMap<Stats, DiseaseInfo> effects;
        private HashMap<Stats, DiseaseInfo> triggers;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSprite() {
        return sprite;
    }

    public void setSprite(String sprite) {
        this.sprite = sprite;
    }

    public ArrayList<Cure> getCures() {
        return cures;
    }

    public void setCures(ArrayList<Cure> cures) {
        this.cures = cures;
    }

    public HashMap<Stats, DiseaseInfo> getEffects() {
        return effects;
    }

    public void setEffects(HashMap<Stats, DiseaseInfo> effects) {
        this.effects = effects;
    }

    public HashMap<Stats, DiseaseInfo> getTriggers() {
        return triggers;
    }

    public void setTriggers(HashMap<Stats, DiseaseInfo> triggers) {
        this.triggers = triggers;
    }
}
