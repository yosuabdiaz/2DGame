package model.actions;

import model.Cure;
import model.Player;

public abstract class Action implements Cure {
    Player player;
    Action(Player player){
        this.player = player;
    }
    public abstract void execute();
    public abstract void render();
}
