package model.actions;

import model.Player;

import java.util.ArrayList;

public class DoNothingAction extends Action{
    public DoNothingAction(Player player) {
        super(player);
    }

    @Override
    public void execute(ArrayList<GameContex> contex) {

    }

    @Override
    public void render() {

    }
}
