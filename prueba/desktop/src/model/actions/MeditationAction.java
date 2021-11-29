package model.actions;

import Utils.Loger;
import View.GameScreen;
import View.mainView;
import com.badlogic.gdx.graphics.Texture;
import model.Player;

import java.util.HashMap;

public class MeditationAction extends Action{
    public MeditationAction() {}

    @Override
    public void execute(HashMap<String, GameContex> contex) {
        Player player = (Player) contex.get("player");
        relax(player);
        render();
        Loger.getInstance().log("Player meditating");
    }

    private void relax(Player player) {
        if(player.getMeditation() < 3 && player.getMentalHealth() < 100){
            int newMentalHealth = player.getMentalHealth() < 80 ? player.getMentalHealth() + 20 : 100;
            player.setMentalHealth(newMentalHealth);
            player.setMeditation(player.getMeditation() + 1);
        }
    }

    @Override
    public void render() {
        mainView m = mainView.getInstance();
        GameScreen g = m.getMyGameScreen();
        g.makeAnimationA(new Texture("sleep.png"),3);
    }

    @Override
    public String getName() {
        return "MeditationAction";
    }
}
