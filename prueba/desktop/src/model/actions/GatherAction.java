package model.actions;

import View.GameScreen;
import View.mainView;
import com.badlogic.gdx.graphics.Texture;
import model.Garden;
import model.Player;
import model.Storage;

import java.util.HashMap;

public class GatherAction extends Action{
    public GatherAction() {}

    @Override
    public void execute(HashMap<String, GameContex> contex) {
        Player player = (Player) contex.get("player");
        Garden garden = (Garden) contex.get("garden");
        Storage storage = (Storage) contex.get("storage");
        render();
    }


    @Override
    public void render() {
        mainView m = mainView.getInstance();
        GameScreen g = m.getMyGameScreen();
        g.makeAnimationA(new Texture("sleep.png"),3);
    }
}
