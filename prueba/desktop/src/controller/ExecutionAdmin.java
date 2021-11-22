package controller;

import model.Configuration;
import model.Memento;
import model.Player;
import model.Storage;

import java.util.Date;

public class ExecutionAdmin {
    private Date startTime = new Date(System.currentTimeMillis());
    private int dayOfYear = 0;
    private int hours = 0;
    private Configuration config = Configuration.getInstance();
    private Player player;
    private Date injuryStarted;
    private MementoAdmin mementoAdmin;
    private Storage storage;

    ExecutionAdmin(Player player){
        this.player = player;
    }

    private void run(){
        while (true){
            Date currTime = new Date(System.currentTimeMillis());
            if(isNextHour()){
                hours++;
                player.setEnergy(player.getEnergy() - config.getEnergyDecrease());
                if(hours == config.getHoursPerDay()){
                    dayOfYear++;
                    hours = 0;
                    mementoAdmin.addMemento(new Memento(player, storage));
                    }
                if(dayOfYear == config.getDaysPerYear()){player.setAge(player.getAge()+1); dayOfYear = 0;}
                //NPCAdmin
                //DiseaseAdmin

            }

            if(player.getInjury() != null){
                injuryStarted = new Date(System.currentTimeMillis());
            }
            else if(player.getInjury() == null && injuryStarted != null){
                injuryStarted = null;
            }
        }
    }

    private boolean isNextHour(){
        Date currTime = new Date(System.currentTimeMillis());
        int difference = (int) (currTime.getTime()- startTime.getTime() / 1000);
        return (difference >= config.getHourDuration())? true:false;
    }

}
