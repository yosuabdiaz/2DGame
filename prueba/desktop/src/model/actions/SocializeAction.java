package model.actions;

import View.GameScreen;
import View.mainView;
import com.badlogic.gdx.graphics.Texture;
import model.Player;

import java.util.HashMap;

public class SocializeAction extends Action{
    public SocializeAction() {}

    @Override
    public void execute(HashMap<String, GameContex> contex) {
        Player player = (Player) contex.get("player");
        updateStats(player);
        render();
    }

    private void updateStats(Player player) {
        int newMentalHealth = player.getMentalHealth() < 80 ? player.getMentalHealth() + 20 : 100;
        player.setMentalHealth(newMentalHealth);
        int newEnergy = player.getEnergy() > 5 ? player.getEnergy() - 5 : 1;
        player.setEnergy(newEnergy);
        int newSleep = player.getSleep() < 95 ? player.getSleep() + 5 : 99;
        player.setSleep(newSleep);
    }

    @Override
    public void render() {
        mainView m = mainView.getInstance();
        GameScreen g = m.getMyGameScreen();
        g.makeAnimationA(new Texture("sleep.png"),3);
    }
}
