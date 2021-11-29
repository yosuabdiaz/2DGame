package model.actions;

import Utils.Loger;
import View.GameScreen;
import View.mainView;
import com.badlogic.gdx.graphics.Texture;
import model.Attack;
import model.EnemyPlayer;
import model.Player;

import java.util.HashMap;
import java.util.Random;

public class GoFightAction extends Action  {
    public GoFightAction() {}

    @Override
    public void execute(HashMap<String, GameContex> contex) {
        Player player = (Player) contex.get("player");
        EnemyPlayer enemy = (EnemyPlayer) contex.get("enemy");
        selectAttacks(enemy,player);
        if(player.getSelectedAttacks().size() > 0){
            figth(player,enemy);
            Loger.getInstance().log("Player Fighting");
        }
        player.clearSelectedAttacks();
        render();

    }

    private void selectAttacks(EnemyPlayer enemy, Player player) {
        int numberAttacksEnemy = enemy.getAttackSkills().size();
        int numberAttacksPlayer = player.getAttackSkills().size();
        Random random = new Random();
        for(int i = 0; i < numberAttacksEnemy; i++){
            player.addSelectedAttacks(player.getAttackSkills().get(random.nextInt(numberAttacksPlayer)));
        }
    }

    private void figth(Player player, EnemyPlayer enemy) {
        int playerPoints = 0;
        int enemyPoints = player.getEnergy() < 100 ? 100 - player.getEnergy() : 0;
        int maxIndexAttacks = player.getSelectedAttacks().size() - 1;
        int count = 0;
        boolean anyWinner = false;
        while(!anyWinner){
            playerPoints += player.getSelectedAttacks().get(count).getDamage();
            enemyPoints += enemy.getAttackSkills().get(count).getDamage();
            if(count == maxIndexAttacks){
                count = 0;
            } else {
                count += 1;
            }
            String playerAttack = "Jugador usó " +
                    player.getSelectedAttacks().get(count).getName() + " (" + playerPoints + "/100)";
            String enemyAttack = "Enemigo usó " +
                    enemy.getAttackSkills().get(count).getName() + " (" + enemyPoints + "/100)";
            mainView.getInstance().getMyGameScreen().resume(playerAttack);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainView.getInstance().getMyGameScreen().resume(enemyAttack);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(playerPoints > 100 || enemyPoints > 100){
                anyWinner = true;
            }
        }
        if(playerPoints > enemyPoints){
            winPlayer(player, enemy, enemyPoints);
        } else {
            losePlayer(player);
        }
    }

    private void winPlayer(Player player, EnemyPlayer enemy, int enemyPoints) {
        if(enemyPoints >= player.getEnergy()){
            player.setEnergy(1);
        } else {
            int newEnergy = player.getEnergy() - enemyPoints;
            player.setEnergy(newEnergy);
        }
        getLoot(player,enemy);
    }

    private void getLoot(Player player, EnemyPlayer enemy) {
        Random rand = new Random();
        int indexLoot = rand.nextInt(enemy.getAttackSkills().size());
        Attack loot = enemy.getAttackSkills().get(indexLoot);
        String lootMessage = "";
        if(isRepeated(player, loot)){
            lootMessage = "Te ha tocado " + loot.getName() + " pero ya tienes este ataque";
        } else {
            lootMessage = "Te ha tocado " + loot.getName() + ", felicidades";
            player.addAttack(loot);
            mainView.getInstance().getMyGameScreen().resume(lootMessage);
        }
    }

    private boolean isRepeated(Player player, Attack loot) {
        for(Attack attack: player.getAttackSkills()){
            if(attack.getName().equals(loot.getName())){
                return true;
            }
        }
        return false;
    }

    private void losePlayer(Player player) {
        player.setEnergy(1);
        mainView.getInstance().getMyGameScreen().resume("Perdiste la pelea");
    }

    @Override
    public void render() {
        //mainView m = mainView.getInstance();
        //GameScreen g = m.getMyGameScreen();
        //g.makeAnimationA(new Texture("attack.png"),5);
    }

    @Override
    public String getName() {
        return "GoFightAction";
    }
}
