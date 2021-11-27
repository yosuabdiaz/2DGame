package model.actions;

import View.GameScreen;
import View.mainView;
import com.badlogic.gdx.graphics.Texture;
import model.Attack;
import model.Injury;
import model.Player;
import model.Sport;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class WorkoutAction extends Action{
    public WorkoutAction() {}

    @Override
    public void execute(HashMap<String, GameContex> contex) {
        Player player = (Player) contex.get("player");
        Sport sport = (Sport) contex.get("sport");
        getAttack(sport,player);
        getInjury(sport,player);
        render();
    }

    private void getInjury(Sport sport, Player player) {
        Random random = new Random();
        float ticket = (float) random.nextInt(99) + 1; //1-100
        if(ticket > sport.getInjuryProb()){//get injury :(
            int daysInjury = random.nextInt(4) + 1;
            String nameInjury = "Injury of " + sport.getName() + "lv" + daysInjury;
            float speedReduction = random.nextFloat();
            player.setInjury(new Injury(nameInjury,daysInjury,speedReduction));
        }
    }

    private void getAttack(Sport sport, Player player) {
        ArrayList<Attack> currentList = player.getAttackSkills();
        for(int i = 0; i < sport.getLoot().size(); i++){
            if(!currentList.contains(sport.getLoot().get(i))){
                player.addAttack(sport.getLoot().get(i));
                break;
            }
        }
    }

    @Override
    public void render() {

    }
}
