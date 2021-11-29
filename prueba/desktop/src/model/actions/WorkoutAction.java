package model.actions;

import Utils.Loger;
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
        if(player.getEnergy() > 10){
            getAttack(sport,player);
            getInjury(sport,player);
            updateStats(player);
            render();
            Loger.getInstance().log("Player exercising");
        }
    }

    private void updateStats(Player player) {
        int newPhysicalHealth = player.getPhysicalHealth() < 80 ? player.getPhysicalHealth() + 20 : 100;
        player.setPhysicalHealth(newPhysicalHealth);
        int newMentalHealth = player.getMentalHealth() < 90 ? player.getMentalHealth() + 10 : 100;
        player.setMentalHealth(newMentalHealth);
        int newFatness = player.getFatness() > 5 ? player.getFatness() - 5 : 0;
        player.setFatness(newFatness);
        int newStrength = player.getStrength() < 95 ? player.getStrength() + 5 : 100;
        player.setStrength(newStrength);
        float newSpeed = player.getSpeed() < 0.95f ? player.getSpeed() + 0.05f : 1f;
        player.setSpeed(newSpeed);
        int newEnergy = player.getEnergy() - 10;
        player.setEnergy(newEnergy);
        int newSleep = player.getSleep() < 80 ? player.getSleep() + 20 : 100;
        player.setSleep(newSleep);
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

    @Override
    public String getName() {
        return "WorkoutAction";
    }
}
