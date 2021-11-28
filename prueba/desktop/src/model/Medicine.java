package model;

import model.actions.GameContex;

import java.util.HashMap;

public class Medicine implements Cure, GameContex {
    String name;
    int energy;
    HashMap<Stats, DiseaseInfo> effects;

    public Medicine(String name, int energy){
       this.name = name;
       this.energy = energy;
    }

    public Medicine(String name, int energy, HashMap<Stats, DiseaseInfo> effects){
        this.name = name;
        this.energy = energy;
        this.effects = effects;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public HashMap<Stats, DiseaseInfo> getEffects() {
        return effects;
    }

    public void setEffects(HashMap<Stats, DiseaseInfo> effects) {
        this.effects = effects;
    }
}
