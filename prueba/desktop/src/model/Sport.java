package model;



import java.util.ArrayList;

public abstract class Sport {
    private String name;
    private ArrayList<Attack> loot;
    private String sprite;
    private float injuryProb;

    public Sport(String name, ArrayList<Attack> loot, String sprite, float injuryProb) {
        this.name = name;
        this.loot = loot;
        this.sprite = sprite;
        this.injuryProb = injuryProb;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Attack> getLoot() {
        return this.loot;
    }

    public void setLoot(ArrayList<Attack> loot) {
        this.loot = loot;
    }

    public String getSprite() {
        return this.sprite;
    }

    public void setSprite(String sprite) {
        this.sprite = sprite;
    }

    public float getInjuryProb() {
        return this.injuryProb;
    }

    public void setInjuryProb(float injuryProb) {
        this.injuryProb = injuryProb;
    }

    public String toString() {
        return "Sport{name='" + this.name + "', loot=" + this.loot + ", sprite='" + this.sprite + "', injuryProb=" + this.injuryProb + "}";
    }
}
