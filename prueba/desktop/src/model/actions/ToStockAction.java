package model.actions;

import Utils.Loger;
import View.GameScreen;
import View.mainView;
import com.badlogic.gdx.graphics.Texture;
import model.Player;

import java.util.HashMap;

public class ToStockAction extends Action{ //select food to eat
    public ToStockAction() {}

    @Override
    public void execute(HashMap<String, GameContex> contex) {
        Player player = (Player) contex.get("player");
        render();
        Loger.getInstance().log("Player in the kitchen");
    }

    @Override
    public void render() {
        mainView m = mainView.getInstance();
        GameScreen g = m.getMyGameScreen();
        g.makeAnimationA(new Texture("chest.png"),3);
    }

    @Override
    public String getName() {
        return "ToStockAction";
    }
}
