package model.actions;

import View.GameScreen;
import View.mainView;
import com.badlogic.gdx.graphics.Texture;
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
        mainView myMainview = mainView.getInstance();
        GameScreen g = myMainview.getMyGameScreen();
        g.makeAnimationA(new Texture("pop.png"),6);

    }

    /**
     * Check if retained liquids is over 100%, bathroom actions just minus 100%
     */
    private void piss(){
        if(player.getRetainedLiquids() > 100){
            int newRetainedLiquids = player.getRetainedLiquids() - 100;
            player.setRetainedLiquids(newRetainedLiquids);
        }
    }

    /**
     * Check if pood is over 100%, bathroom actions just minus 100%
     */
    private void poop(){
        if(player.getEatenFood() > 100){
            int newEatenFood = player.getEatenFood() - 100;
            player.setEatenFood(newEatenFood);
        }
    }
}
