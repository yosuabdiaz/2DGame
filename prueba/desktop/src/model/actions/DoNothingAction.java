package model.actions;

import View.GameScreen;
import View.mainView;
import com.badlogic.gdx.graphics.Texture;
import model.Player;

import java.util.HashMap;

public class DoNothingAction extends Action{
    public DoNothingAction() {}

    @Override
    public void execute(HashMap<String, GameContex> contex) {
        Player player = (Player) contex.get("player");
    }

    @Override
    public void render() {
        mainView m = mainView.getInstance();
        GameScreen g = m.getMyGameScreen();
        g.makeAnimationA(new Texture("sleep.png"),3);
    }

    @Override
    public String getName() {
        return "DoNothingAction";
    }
}
