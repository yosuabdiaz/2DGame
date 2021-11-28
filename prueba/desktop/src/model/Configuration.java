package model;

import Utils.ConfigurationReader;

public class Configuration {

    //rutas
    private String diseasePath = "./diseases/";
    private String foodPath = "./food/";
    private String medicinePath = "./medicine/";
    private String friendsPath = "./friends/";
    private String enemyPath = "./enemy/";
    private String logPath = "./logs/";
    private static Configuration instance;
    private int hourDuration = 5;
    private int hoursPerDay = 24;
    private int daysPerYear = 10;
    //20 minutos para que pase un año con los defaults.
    // ***ACTUALIZAR EL TOTAL SI SE CAMBIAN***
    private int energyDecrease = 1;
    private int foodInGarden = 20;
    private int cureProbability = 10;
    private int friendProbability = 10;
    private int enemyProbability = 10;

    public int getFriendProbability() {
        return friendProbability;
    }

    public void setFriendProbability(int friendProbability) {
        this.friendProbability = friendProbability;
    }

    public int getEnemyProbability() {
        return enemyProbability;
    }

    public void setEnemyProbability(int enemyProbability) {
        this.enemyProbability = enemyProbability;
    }

    public int getCureProbability() {
        return cureProbability;
    }

    public void setCureProbability(int cureProbability) {
        this.cureProbability = cureProbability;
    }

    public int getFoodInGarden() {
        return foodInGarden;
    }

    public void setFoodInGarden(int foodInGarden) {
        this.foodInGarden = foodInGarden;
    }

    public int getSavedDays() {
        return savedDays;
    }

    public void setSavedDays(int savedDays) {
        this.savedDays = savedDays;
    }

    private int savedDays = 3;

    public int getHoursPerDay() {
        return hoursPerDay;
    }

    public void setHoursPerDay(int hoursPerDay) {
        this.hoursPerDay = hoursPerDay;
    }

    public int getDaysPerYear() {
        return daysPerYear;
    }

    public void setDaysPerYear(int daysPerYear) {
        this.daysPerYear = daysPerYear;
    }

    public int getEnergyDecrease() {
        return energyDecrease;
    }

    public void setEnergyDecrease(int energyDecrease) {
        this.energyDecrease = energyDecrease;
    }

    public String getDiseasePath() {
        return diseasePath;
    }

    public void setDiseasePath(String diseasePath) {
        this.diseasePath = diseasePath;
    }

    public String getFoodPath() {
        return foodPath;
    }

    public void setFoodPath(String foodPath) {
        this.foodPath = foodPath;
    }

    public String getMedicinePath() {
        return medicinePath;
    }

    public void setMedicinePath(String medicinePath) {
        this.medicinePath = medicinePath;
    }

    public String getFriendsPath() {
        return friendsPath;
    }

    public void setFriendsPath(String friendsPath) {
        this.friendsPath = friendsPath;
    }

    public String getEnemyPath() {
        return enemyPath;
    }

    public void setEnemyPath(String enemyPath) {
        this.enemyPath = enemyPath;
    }

    private Configuration(){
    }

    public static Configuration getInstance(){
        ConfigurationReader reader = new ConfigurationReader();
        instance = reader.read("./"); //RUTA DEL ARCHIVO DE CONFIGURACION
        if(instance == null){
            instance = new Configuration();
            reader.write(instance,"./");
            return instance;
        }
        else return instance;
    }

    public int getHourDuration() {
        return hourDuration;
    }

    public void setHourDuration(int hourDuration) {
        this.hourDuration = hourDuration;
    }
}
