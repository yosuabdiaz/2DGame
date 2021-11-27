package model.actions;

import View.GameScreen;
import View.mainView;
import com.badlogic.gdx.graphics.Texture;
import model.*;

import java.util.ArrayList;
import java.util.HashMap;

public class GatherAction extends Action{
    public GatherAction() {}

    @Override
    public void execute(HashMap<String, GameContex> contex) {
        Player player = (Player) contex.get("player");
        Garden garden = (Garden) contex.get("garden");
        Storage storage = (Storage) contex.get("storage");
        collectFood(garden, storage);
        collectMedicine(garden, storage);
        render();
    }

    private void collectMedicine(Garden garden, Storage storage) {
        ArrayList<Cure> collectedMedicine = garden.harvestGardenCures();
        for(Cure medicine:collectedMedicine){
            storage.addMedicine((Medicine) medicine);
        }
    }

    private void collectFood(Garden garden, Storage storage) {
        ArrayList<Food> collectedFood = garden.harvestGardenFood();
        for(Food food:collectedFood){
            storage.addFood(food);
        }
    }


    @Override
    public void render() {
        mainView m = mainView.getInstance();
        GameScreen g = m.getMyGameScreen();
        g.makeAnimationA(new Texture("sleep.png"),3);
    }
}
