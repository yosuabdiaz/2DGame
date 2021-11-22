package model;

public class Injury {
    String name;
    int recuperationTime;
    int speedReduction;

    public Injury(String name, int recuperationTime, int speedReduction) {
        this.name = name;
        this.recuperationTime = recuperationTime;
        this.speedReduction = speedReduction;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRecuperationTime() {
        return recuperationTime;
    }

    public void setRecuperationTime(int recuperationTime) {
        this.recuperationTime = recuperationTime;
    }

    public int getSpeedReduction() {
        return speedReduction;
    }

    public void setSpeedReduction(int speedReduction) {
        this.speedReduction = speedReduction;
    }
}
