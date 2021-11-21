package model.actions;

import model.Player;

public class DoNothingAction extends Action{
    DoNothingAction(Player player) {
        super(player);
    }

    @Override
    public void execute() {

    }

    @Override
    public void render() {

    }
}
