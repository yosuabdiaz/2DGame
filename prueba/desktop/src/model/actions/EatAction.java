package model.actions;

import model.Food;
import model.Player;

import java.util.ArrayList;

public class EatAction extends Action{
    public EatAction(Player player) {
        super(player);
    }

    @Override
    public void execute(ArrayList<GameContex> contex) {
        render();
        //eat(selectedFood);
    }

    @Override
    public void render() {

    }

    private void eat(Food food) {
        if(food.isSolid()){
            player.setEatenFood(player.getEatenFood() + food.getEnergy());
        } else {
            player.setRetainedLiquids(player.getRetainedLiquids() + food.getEnergy());
        }
        player.setHunger(player.getHunger() - food.getEnergy());
    }
}
