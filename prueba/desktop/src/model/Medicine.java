package model;

import model.actions.GameContex;

import java.util.HashMap;

public class Medicine implements Cure, GameContex {
    String name;
    int energy;
    HashMap<Stats, Integer> effects;

    public Medicine(String name, int energy){
       this.name = name;
       this.energy = energy;
    }

    public Medicine(String name, int energy, HashMap<Stats, Integer> effects){
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

    public HashMap<Stats, Integer> getEffects() {
        return effects;
    }

    public void setEffects(HashMap<Stats, Integer> effects) {
        this.effects = effects;
    }
}
