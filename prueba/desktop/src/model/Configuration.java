package model;

public class Configuration {

    private static Configuration instance;
    private int hourDuration = 5;
    private int hoursPerDay = 24;
    private int daysPerYear = 10;
    //20 minutos para que pase un año con los defaults.
    // ***ACTUALIZAR EL TOTAL SI SE CAMBIAN***
    private int energyDecrease = 1;

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
