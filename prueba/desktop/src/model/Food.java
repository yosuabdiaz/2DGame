package model;

import model.actions.GameContex;

import java.io.Serializable;

public class Food implements GameContex, Serializable {
    private String name;
    private int energy;
    private boolean isSolid;

    public Food(String name, int energy, boolean isSolid){
        this.name = name;
        this.energy = energy;
        this.isSolid = isSolid;
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

    public boolean isSolid() {
        return isSolid;
    }

    public void setSolid(boolean solid) {
        isSolid = solid;
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", energy=" + energy +
                ", isSolid=" + isSolid +
                '}';
    }
}
