package model.actions;

import View.GameScreen;
import View.mainView;
import com.badlogic.gdx.graphics.Texture;
import model.Player;

import java.util.HashMap;

public class GoFightAction extends Action  {
    public GoFightAction() {}

    @Override
    public void execute(HashMap<String, GameContex> contex) {
        Player player = (Player) contex.get("player");
        render();
    }

    @Override
    public void render() {
        mainView m = mainView.getInstance();
        GameScreen g = m.getMyGameScreen();
        g.makeAnimationA(new Texture("attack.png"),5);
    }
}
