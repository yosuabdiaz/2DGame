package model;

import java.util.ArrayList;
import  java.util.HashMap;

public class Player extends Fighter {
    protected int age = 0;
    protected  int sleep = 0;
    protected HashMap<Integer,String> sprites = new HashMap<>();
    protected int hunger = 0;
    protected Disease disease = null;
    protected int trainingCharge = 0;
    protected int retainedLiquids = 0; //piss
    protected int eatenFood = 0; //poop
    protected int happiness = 0;
    protected int muscles = 0;
    protected int speed = 0;
    protected int strength = 0;
    protected int fatness = 0;
    protected int mentalHealth = 0;
    protected ArrayList<FriendPlayer> friends= new ArrayList();
    protected int physicalHealth = 0;
    protected Injury injury = null;
    protected int meditation = 0; //number of meditations in a day, top is 3
    protected int x = 0;
    protected int y = 0;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSleep() {
        return sleep;
    }

    public void setSleep(int sleep) {
        this.sleep = sleep;
    }

    public HashMap<Integer, String> getSprites() {
        return sprites;
    }

    public void setSprites(HashMap<Integer, String> sprites) {
        this.sprites = sprites;
    }

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public Disease getDisease() {
        return disease;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }

    public int getTrainingCharge() {
        return trainingCharge;
    }

    public void setTrainingCharge(int trainingCharge) {
        this.trainingCharge = trainingCharge;
    }

    public int getRetainedLiquids() {
        return retainedLiquids;
    }

    public void setRetainedLiquids(int retainedLiquids) {
        this.retainedLiquids = retainedLiquids;
    }

    public int getEatenFood() {
        return eatenFood;
    }

    public void setEatenFood(int eatenFood) {
        this.eatenFood = eatenFood;
    }

    public int getHappiness() {
        return happiness;
    }

    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }

    public int getMuscles() {
        return muscles;
    }

    public void setMuscles(int muscles) {
        this.muscles = muscles;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getFatness() {
        return fatness;
    }

    public void setFatness(int fatness) {
        this.fatness = fatness;
    }

    public int getMentalHealth() {
        return mentalHealth;
    }

    public void setMentalHealth(int mentalHealth) {
        this.mentalHealth = mentalHealth;
    }

    public ArrayList<FriendPlayer> getFriends() {
        return friends;
    }

    public void setFriends(ArrayList<FriendPlayer> friends) {
        this.friends = friends;
    }

    public int getPhysicalHealth() {
        return physicalHealth;
    }

    public void setPhysicalHealth(int physicalHealth) {
        this.physicalHealth = physicalHealth;
    }

    public Injury getInjury() {
        return injury;
    }

    public void setInjury(Injury injury) {
        this.injury = injury;
    }

    public int getMeditation() {
        return meditation;
    }

    public void setMeditation(int meditation) {
        this.meditation = meditation;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void learnAttacks(Fighter fighter){
        ArrayList<Attack> opponentSkills= fighter.getAttackSkills();
        for(Attack skill : opponentSkills){
            if(!super.getAttackSkills().contains(skill)){
                super.getAttackSkills().add(skill);
            }
        }
    }

    @Override
    public void attack(Fighter fighter) {
        //TO-DO
    }
}
