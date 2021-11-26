package model;

public class Attack {
    private String name;
    private int damage;
    private String sprite;

    public Attack(String name, int damage, String sprite) {
        this.name = name;
        this.damage = damage;
        this.sprite = sprite;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return this.damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getSprite() {
        return this.sprite;
    }

    public void setSprite(String sprite) {
        this.sprite = sprite;
    }

    public String toString() {
        return "Attack{name='" + this.name + "', damage=" + this.damage + ", sprite='" + this.sprite + "'}";
    }
}

