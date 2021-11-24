package model.actions;

import model.Player;

import java.util.ArrayList;

public class MeditationAction extends Action{
    public MeditationAction(Player player) {
        super(player);
    }

    @Override
    public void execute(ArrayList<GameContex> contex) {
        render();
        updateMentalHealth();
    }

    @Override
    public void render() {

    }

    private void updateMentalHealth(){
        if(player.getMentalHealth() < 100 && player.getMeditation() < 3){
            player.setMentalHealth(player.getMentalHealth() + 20);
            player.setMeditation(player.getMeditation() + 1);
        }
    }
}
