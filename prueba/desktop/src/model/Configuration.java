package model;

public class Configuration {

    private static Configuration instance;
    private int hourDuration = 5;  //5
    private int hoursPerDay = 2;//24
    private int daysPerYear = 1; //10
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

    private Configuration(){

    }

    public static Configuration getInstance(){
        return (instance == null)? new Configuration(): instance;
    }

    public int getHourDuration() {
        return hourDuration;
    }

    public void setHourDuration(int hourDuration) {
        this.hourDuration = hourDuration;
    }
}
