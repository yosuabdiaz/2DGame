package controller;

import Utils.AttackReader;
import View.mainView;
import model.*;
import model.actions.GameContex;
import model.actions.GoFightAction;
import model.actions.SocializeAction;

import java.io.File;
import java.util.HashMap;
import java.util.Random;
import java.util.ArrayList;

public class NPCAdmin {
    private static Boolean visited = false;
    private static int attacksToDay;
    private static ArrayList<Attack> skills = new ArrayList<>();

    public static void generateNPC(Player player){
        Random rand = new Random();
        if(rand.nextInt(100) < Configuration.getInstance().getFriendProbability() && !visited){
            NPCAdmin.generateFriend(player);
        }
        else if(rand.nextInt(100) < Configuration.getInstance().getEnemyProbability() && attacksToDay < 3){
            generateEnemy(player.getAttackSkills().size(), player.getEnergy(), player);
        }
    }

    private static void generateFriend(Player player){
        boolean response  = mainView.getInstance().getMyGameScreen().AcceptFriend();
        if(response) {
            FriendPlayer friend = new FriendPlayer("Player", "");
            //mainView.getInstance().getMyGameScreen()
            HashMap<String, GameContex> context = new HashMap<String, GameContex>();
            context.put("player", (GameContex) player);
            context.put("friend", (GameContex) friend);
            SocializeAction socializeAction = new SocializeAction();
            socializeAction.execute(context);
        }
        visited = true;
    }

    private static void generateEnemy(int playerSkills, int playerEnergy, Player player){
        boolean response  = mainView.getInstance().getMyGameScreen().AcceptFigth();
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
            HashMap<String, GameContex> context = new HashMap<String, GameContex>();
            context.put("player", (GameContex) player);
            context.put("enemy", (GameContex) enemy);
            GoFightAction goFightAction = new GoFightAction();
            goFightAction.execute(context);
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


    public static void loadData() {
        File folder = new File(Configuration.getInstance().getAttacksPath());
        File[] files = folder.listFiles();
        AttackReader r = new AttackReader();
        if (files != null) {
            for (File f : files) {
                System.out.println(f);
                Attack skill = r.read(f.getPath());
                if (skill != null) {
                    skills.add(skill);
                }
            }
        }
    }
}
