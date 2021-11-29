package model.actions;

import View.GameScreen;
import View.mainView;
import com.badlogic.gdx.graphics.Texture;
import controller.DiseaseAdmin;
import model.Cure;
import model.Food;
import model.Medicine;
import model.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class EatAction extends Action{
    public EatAction() {}

    @Override
    public void execute(HashMap<String,GameContex> contex) {
        render();
        Player player = (Player) contex.get("player");
        if(isFood(contex.keySet())){
            Food selectedFood = (Food) contex.get("food");
            eat(player,selectedFood);
            fatCalc(player,selectedFood);
        } else {
            Medicine selectedMedicine = (Medicine) contex.get("medicine");
            if(DiseaseAdmin.getDiseaseStarted() != null){
                DiseaseAdmin.cure(player, (Cure) selectedMedicine);
            }
            updateStats(player,selectedMedicine);
        }
    }

    private void updateStats(Player player, Medicine selectedMedicine) {
        
    }

    private boolean isFood(Set<String> keySet) {
        ArrayList<String> list = new ArrayList<String>(keySet);
        for(String key:list){
            if(key.equals("food")){
                return true;
            }
        }
        return false;
    }

    @Override
    public void render() {
        mainView m = mainView.getInstance();
        GameScreen g = m.getMyGameScreen();
        g.makeAnimationA(new Texture("sleep.png"),3);
    }

    @Override
    public String getName() {
        return "EatAction";
    }

    /**
     * Decide what stat of food fill in player, piss or shit
     * @param food just eated
     */
    private void eat(Player player, Food food) {
        if(food.isSolid()){
            player.setEatenFood(player.getEatenFood() + food.getEnergy());
        } else {
            player.setRetainedLiquids(player.getRetainedLiquids() + food.getEnergy());
        }
        player.setEnergy(player.getEnergy() + food.getEnergy());
    }

    /**
     * Calc if player get fat or just get unhungry
     * @param food just eated
     */
    private void fatCalc(Player player, Food food) {
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
