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

    /**
     * Check if can add more mental healt value or have less of 3 meditation times
     */
    private void updateMentalHealth(){
        if(player.getMentalHealth() < 100 && player.getMeditation() < 3){
            int mentalHealt = player.getMentalHealth() > 80 ? 100 : player.getMentalHealth() + 20;
            player.setMentalHealth(mentalHealt);
            player.setMeditation(player.getMeditation() + 1);
        }
    }
}
