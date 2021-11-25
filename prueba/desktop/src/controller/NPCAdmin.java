package controller;

import View.mainView;
import model.Attack;
import model.EnemyPlayer;
import model.FriendPlayer;
import model.Player;

import java.util.Random;
import java.util.ArrayList;

public class NPCAdmin {
    private static Boolean visited = false;
    private static int attacksToDay;
    private static ArrayList<Attack> skills = new ArrayList<>();

    public static void generateNPC(Player player){
        Random rand = new Random();
        if(rand.nextInt(2) == 1 && !visited){
            NPCAdmin.generateFriend();
        }
        else if(attacksToDay < 3){
            generateEnemy(player.getAttackSkills().size(), player.getEnergy());
        }
    }

    private static void generateFriend(){
        boolean response  = mainView.getInstance().getMyGameScreen().getAcceptFriend();
        if(response) {
            FriendPlayer friend = new FriendPlayer("Player", "");
            //mainView.getInstance().getMyGameScreen()
        }
        visited = true;
    }

    private static void generateEnemy(int playerSkills, int playerEnergy){
        boolean response  = mainView.getInstance().getMyGameScreen().getAcceptFight();
        if(response) {
            Random rand = new Random();
            ArrayList<Attack> enemySkills = new ArrayList<>();
            for (int i = 0; i < playerSkills; i++) {
                int index = rand.nextInt(skills.size());
                enemySkills.add(skills.get(index));
            }
            EnemyPlayer enemy = new EnemyPlayer();
            enemy.setAttackSkills(enemySkills);
            enemy.setEnergy(rand.nextInt(playerEnergy));
            //enviar el enemy al mainView
        }
    }

    public static Boolean getVisited() {
        return visited;
    }

    public static void setVisited(Boolean visited) {
        NPCAdmin.visited = visited;
    }

    public static int getAttacksToDay() {
        return attacksToDay;
    }

    public static void setAttacksToDay(int attacksToDay) {
        NPCAdmin.attacksToDay = attacksToDay;
    }
}
