package model.actions;

import View.GameScreen;
import View.mainView;
import com.badlogic.gdx.graphics.Texture;
import model.Player;
import model.Sport;

import java.util.HashMap;

public class WorkoutAction extends Action{
    public WorkoutAction() {}

    @Override
    public void execute(HashMap<String, GameContex> contex) {
        Player player = (Player) contex.get("player");
        Sport sport = (Sport) contex.get("sport");
        render();
    }

    @Override
    public void render() {

    }
}
