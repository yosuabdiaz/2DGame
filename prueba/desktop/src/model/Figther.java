package model;

import java.util.ArrayList;

public abstract class Figther {
    private int energy;
    private String name;
    private ArrayList<Attack> attackSkills = new ArrayList<>();
    public abstract void attack(Figther figther);
    public void addAttack(Attack attack) {
        attackSkills.add(attack);
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Attack> getAttackSkills() {
        return attackSkills;
    }

    public void setAttackSkills(ArrayList<Attack> attackSkills) {
        this.attackSkills = attackSkills;
    }
}
