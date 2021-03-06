package model.actions;

import Utils.Loger;
import View.GameScreen;
import View.mainView;
import com.badlogic.gdx.graphics.Texture;
import model.Player;

import java.util.HashMap;

public class GoBathroomAction extends Action{
    public GoBathroomAction() { }

    @Override
    public void execute(HashMap<String, GameContex> contex) {
        Player player = (Player) contex.get("player");
        render();
        piss(player);
        poop(player);
        Loger.getInstance().log("Player in the bathroom");
    }

    @Override
    public void render() {
        mainView myMainview = mainView.getInstance();
        GameScreen g = myMainview.getMyGameScreen();
        g.makeAnimationA(new Texture("pop.png"),6);

    }

    @Override
    public String getName() {
        return "GoBathroomAction";
    }

    /**
     * Check if retained liquids is over 100%, bathroom actions just minus 100%
     * @param player
     */
    private void piss(Player player){
        if(player.getRetainedLiquids() > 50){
            int newRetainedLiquids = player.getRetainedLiquids() - 50;
            player.setRetainedLiquids(newRetainedLiquids);
        }
    }

    /**
     * Check if pood is over 100%, bathroom actions just minus 100%
     * @param player
     */
    private void poop(Player player){
        if(player.getEatenFood() > 50){
            int newEatenFood = player.getEatenFood() - 50;
            player.setEatenFood(newEatenFood);
        }
    }
}
