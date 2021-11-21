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
        Food selectedFood = (Food) contex.get(0);
        eat(selectedFood);
        fatCalc(selectedFood);
    }

    @Override
    public void render() {

    }

    /**
     * Decide what stat of food fill in player, piss or shit
     * @param food just eated
     */
    private void eat(Food food) {
        if(food.isSolid()){
            player.setEatenFood(player.getEatenFood() + food.getEnergy());
        } else {
            player.setRetainedLiquids(player.getRetainedLiquids() + food.getEnergy());
        }
    }

    /**
     * Calc if player get fat or just get unhungry
     * @param food just eated
     */
    private void fatCalc(Food food) {
        if(player.getHunger() < food.getEnergy()){ //get fat
            int fatEarned = food.getEnergy() - player.getHunger();
            player.setFatness(player.getFatness() + fatEarned);
            player.setHunger(0);
        } else {
            int newHunger = player.getHunger() - food.getEnergy();
            player.setHunger(newHunger);
        }

    }
}
