package model.actions;

import model.Player;

import java.util.ArrayList;

public class GoBathroomAction extends Action{
    public GoBathroomAction(Player player) {
        super(player);
    }

    @Override
    public void execute(ArrayList<GameContex> contex) {
        render();
        piss();
        poop();
    }

    @Override
    public void render() {

    }

    private void piss(){
        if(player.getRetainedLiquids() > 100){
            int newRetainedLiquids = player.getRetainedLiquids() - 100;
            player.setRetainedLiquids(newRetainedLiquids);
        }
    }
    private void poop(){
        if(player.getEatenFood() > 100){
            int newEatenFood = player.getEatenFood() - 100;
            player.setEatenFood(newEatenFood);
        }
    }
}
