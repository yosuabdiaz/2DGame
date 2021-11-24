package controller;

import model.*;

import java.util.Date;
import java.util.Random;

public class ExecutionAdmin extends Thread{
    private Date startTime = new Date(System.currentTimeMillis());
    private int dayOfYear = 0;
    private int hours = 0;
    private Configuration config = Configuration.getInstance();
    private Player player;
    private Date injuryStarted;
    private MementoAdmin mementoAdmin;
    private Storage storage;
    private Garden garden;

    public ExecutionAdmin(Player player){
        this.player = player;
    }

    @Override
    public void run(){
        Random rand = new Random();
        while (true){
            if(isNextHour()){
                hours++;
                player.setEnergy(player.getEnergy() - config.getEnergyDecrease());
                if(hours == config.getHoursPerDay()){
                    dayOfYear++;
                    hours = 0;
                    garden.growGarden();
                    mementoAdmin.addMemento(new Memento(player, storage));
                    NPCAdmin.setAttacksToDay(0);
                    NPCAdmin.setVisited(false);
                    }
                if(dayOfYear == config.getDaysPerYear()){player.setAge(player.getAge()+1); dayOfYear = 0;}
                int npcProbability = rand.nextInt();
                if(npcProbability > 2) {

                }

                }
                //NPCAdmin
                //DiseaseAdmin



            if(player.getInjury() != null){
                injuryStarted = new Date(System.currentTimeMillis());
            }
            if(injuryStarted != null) {
                Date currTime = new Date(System.currentTimeMillis());
                int difference = (int) (currTime.getTime() - injuryStarted.getTime() / 1000);
                if (difference >= player.getInjury().getRecuperationTime()){
                    injuryStarted = null;
                    player.setSpeed(player.getSpeed() + player.getInjury().getRecuperationTime());
                    player.setInjury(null);
                }
            }
        }
    }

    private boolean isNextHour(){
        Date currTime = new Date(System.currentTimeMillis());
        int difference = (int) (currTime.getTime()- startTime.getTime() / 1000);
        return (difference >= config.getHourDuration())? true:false;
    }

}
