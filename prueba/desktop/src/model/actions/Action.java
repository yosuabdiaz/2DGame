package model.actions;

import model.Cure;
import model.Player;

import java.util.ArrayList;

public abstract class Action implements Cure {
    Player player;
    Action(Player player){
        this.player = player;
    }
    public abstract void execute(ArrayList<GameContex> contex);
    public abstract void render();
}
