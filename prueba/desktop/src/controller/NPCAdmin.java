package controller;

import model.Attack;
import model.EnemyPlayer;


import java.util.Random;
import java.util.ArrayList;

public class NPCAdmin {
    private static Boolean visited = false;
    private static int attacksToDay;
    private static ArrayList<Attack> skills = new ArrayList<>();



    private static void generateFriend(){

    }

    private static void generateEnemy(int playerSkills, int playerEnergy){
        Random rand = new Random();
        ArrayList<Attack> enemySkills = new ArrayList<Attack>();
        for(int i= 0; i< playerSkills; i++){
            int index = rand.nextInt(skills.size());
            enemySkills.add(skills.get(index));
        }
        EnemyPlayer enemy = new EnemyPlayer();
        enemy.setAttackSkills(enemySkills);
        enemy.setEnergy(rand.nextInt(playerEnergy));
        
    }

}
