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
    private MementoAdmin mementoAdmin = new MementoAdmin();
    private Storage storage = new Storage();
    private Garden garden = new Garden();

    public ExecutionAdmin(Player player){
        this.player = player;
    }

    @Override
    public void run() {
        System.out.println(player);
        Random rand = new Random();
        while (true) {
            try {
                Thread.sleep(config.getHourDuration() * 1000);
                System.out.println("esperado");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            hours++;
            if(player.getEnergy() > 1) {
                player.setEnergy(player.getEnergy() - config.getEnergyDecrease());
            }
            if (hours == config.getHoursPerDay()) {
                dayOfYear++;
                hours = 0;
                garden.growGarden();
                mementoAdmin.addMemento(new Memento(player, storage));
                NPCAdmin.setAttacksToDay(0);
                NPCAdmin.setVisited(false);
                player.setMeditation(0);
            }
            if (dayOfYear == config.getDaysPerYear()) {
                player.setAge(player.getAge() + 1);
                dayOfYear = 0;
            }
            int npcProbability = rand.nextInt();
            if (npcProbability > 2) {
                NPCAdmin.generateNPC(player);
            }


            //NPCAdmin
            //DiseaseAdmin


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


}
