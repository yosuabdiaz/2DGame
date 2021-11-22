package model;

import java.util.ArrayList;
import java.util.HashMap;

public class Disease {
        private String name;
        private String sprite;
        private ArrayList<Cure> cures;
        private HashMap<Stats, Integer> effects;
        private HashMap<Stats, Integer> triggers;

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

    public HashMap<Stats, Integer> getEffects() {
        return effects;
    }

    public void setEffects(HashMap<Stats, Integer> effects) {
        this.effects = effects;
    }

    public HashMap<Stats, Integer> getTriggers() {
        return triggers;
    }

    public void setTriggers(HashMap<Stats, Integer> triggers) {
        this.triggers = triggers;
    }
}
