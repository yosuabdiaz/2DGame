package model.actions;

import View.GameScreen;
import View.mainView;
import com.badlogic.gdx.graphics.Texture;
import model.Player;

import java.util.ArrayList;
import java.util.HashMap;

public class GoBathroomAction extends Action{
    public GoBathroomAction() { }

    @Override
    public void execute(HashMap<String, GameContex> contex) {
        Player player = (Player) contex.get("player");
        render();
        piss(player);
        poop(player);
    }

    @Override
    public void render() {
        mainView myMainview = mainView.getInstance();
        GameScreen g = myMainview.getMyGameScreen();
        g.makeAnimationA(new Texture("pop.png"),6);

    }

    /**
     * Check if retained liquids is over 100%, bathroom actions just minus 100%
     * @param player
     */
    private void piss(Player player){
        if(player.getRetainedLiquids() > 100){
            int newRetainedLiquids = player.getRetainedLiquids() - 100;
            player.setRetainedLiquids(newRetainedLiquids);
        }
    }

    /**
     * Check if pood is over 100%, bathroom actions just minus 100%
     * @param player
     */
    private void poop(Player player){
        if(player.getEatenFood() > 100){
            int newEatenFood = player.getEatenFood() - 100;
            player.setEatenFood(newEatenFood);
        }
    }
}
