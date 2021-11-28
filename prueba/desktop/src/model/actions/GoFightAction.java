package model.actions;

import View.GameScreen;
import View.mainView;
import com.badlogic.gdx.graphics.Texture;
import model.EnemyPlayer;
import model.Player;

import java.util.HashMap;

public class GoFightAction extends Action  {
    public GoFightAction() {}

    @Override
    public void execute(HashMap<String, GameContex> contex) {
        Player player = (Player) contex.get("player");
        EnemyPlayer enemy = (EnemyPlayer) contex.get("enemy");
        figth(player,enemy);
        //Dialogo para seleccionar
        mainView.getInstance().getMyGameScreen().selectAttack();
        //Automatizar
        render();
    }

    private void figth(Player player, EnemyPlayer enemy) {
        int playerPoints = 0;
        int enemyPoints = player.getEnergy() < 100 ? 100 - player.getEnergy() : 0;
        int maxIndexAttacks = player.getSelectedAttacks().size() - 1;
        int count = 0;
        while(playerPoints < 100 || enemyPoints < 100){
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
        }
        if(playerPoints > enemyPoints){
            winPlayer(player, enemy);
        } else {
            losePlayer(player);
        }
    }

    private void winPlayer(Player player, EnemyPlayer enemy) {
    }

    private void losePlayer(Player player) {
    }

    @Override
    public void render() {
        mainView m = mainView.getInstance();
        GameScreen g = m.getMyGameScreen();
        g.makeAnimationA(new Texture("attack.png"),5);
    }
}
