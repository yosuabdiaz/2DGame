package model;

import model.actions.GameContex;

public class FriendPlayer implements GameContex {
    private String name;
    private String sprite;

    public FriendPlayer(String name, String sprite){
        this.name = name;
        this.sprite = sprite;
    }

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
}
