package model.actions;

import View.GameScreen;
import View.mainView;
import com.badlogic.gdx.graphics.Texture;
import model.Player;

import java.util.ArrayList;

public class GoFightAction extends Action  {
    public GoFightAction(Player player) {
        super(player);
    }

    @Override
    public void execute(ArrayList<GameContex> contex) {
        render();
    }

    @Override
    public void render() {
        mainView m = mainView.getInstance();
        GameScreen g = m.getMyGameScreen();
        g.makeAnimationA(new Texture("attack.png"),5);
    }
}
