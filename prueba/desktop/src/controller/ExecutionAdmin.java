package controller;

import Utils.Loger;
import model.*;

import java.util.Date;
import java.util.Random;

public class ExecutionAdmin extends Thread{
    private Date startTime = new Date(System.currentTimeMillis());
    private int dayOfYear = 0;
    private int minutes = 0;
    private int hours = 0;
    private Configuration config = Configuration.getInstance();
    private Player player;
    private Date injuryStarted;
    private MementoAdmin mementoAdmin = new MementoAdmin();
    private Storage storage;
    private Garden garden;

    public ExecutionAdmin(Player player, Garden garden, Storage storage){
        this.player = player;
        this.storage = storage;
        this.garden = garden;
    }

    @Override
    public void run() {
        Random rand = new Random();
        while (true) {
            try {
                Thread.sleep((config.getHourDuration() * 1000)/4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            minutes++;
            if(minutes > 3){
                minutes = 0;
                hours++;
                if(player.getEnergy() > 1) {
                    player.setEnergy(player.getEnergy() - config.getEnergyDecrease());
                    player.setSleep(player.getSleep() + 1);
                    player.setHunger(player.getHunger() + 1);
                }
                if (hours == config.getHoursPerDay()) {
                    dayOfYear++;
                    hours = 0;
                    garden.growGarden();
                    mementoAdmin.addMemento(new Memento(player.clone(), storage.clone()));
                    NPCAdmin.setAttacksToDay(0);
                    NPCAdmin.setVisited(false);
                    player.setMeditation(0);
                }
                if (dayOfYear == config.getDaysPerYear()) {
                    //Loger.getInstance().log("Day: " + dayOfYear);
                    player.setAge(player.getAge() + 1);
                    dayOfYear = 0;
                }
                int npcProbability = rand.nextInt(100);
                if (npcProbability < 2) {
                    NPCAdmin.generateNPC(player);
                }
            }


            if (player.getInjury() != null) {
                injuryStarted = new Date(System.currentTimeMillis());
            }
            if (injuryStarted != null) {
                Date currTime = new Date(System.currentTimeMillis());
                int difference = (int) (currTime.getTime() - injuryStarted.getTime() / 1000);
                if (difference >= player.getInjury().getRecuperationTime()) {
                    injuryStarted = null;
                    player.setSpeed(player.getSpeed() + player.getInjury().getRecuperationTime());
                    player.setInjury(null);
                }
            }


        }
    }

    public int getDayOfYear() {
        return dayOfYear;
    }

    public void setDayOfYear(int dayOfYear) {
        this.dayOfYear = dayOfYear;
    }

    public int getMinutes() {
        return minutes * 15;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public void setConfig(Configuration config) {
        this.config = config;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setInjuryStarted(Date injuryStarted) {
        this.injuryStarted = injuryStarted;
    }

    public void setMementoAdmin(MementoAdmin mementoAdmin) {
        this.mementoAdmin = mementoAdmin;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public void setGarden(Garden garden) {
        this.garden = garden;
    }

    public Garden getGarden(){
        return this.garden;
    }
}
