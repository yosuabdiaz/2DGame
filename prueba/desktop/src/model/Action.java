package model;

public abstract class Action implements Cure {
    Player player;
    Action(Player player){
        this.player = player;
    }
    public abstract void execute();
    //public abstract void render();
}
