package model;

import model.actions.GameContex;

import java.util.Random;

public class EnemyPlayer extends Fighter implements GameContex {

    @Override
    public void attack(Fighter fighter) {
        Random rand = new Random();
        int randomIndex = rand.nextInt(getAttackSkills().size());
        Attack attack = this.getAttackSkills().get(randomIndex);
        fighter.setEnergy(fighter.getEnergy() - attack.getDamage());
    }
}
