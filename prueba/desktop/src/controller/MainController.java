package controller;

import model.*;
import model.actions.*;
import org.SportLib.Sport;

import java.util.ArrayList;
import java.util.HashMap;

public class MainController {//I need a new name
    private Player player;
    private Storage storage;
    private Garden garden;
    private HashMap<String ,Action> actions;
    private ArrayList<Sport> sports;

    public MainController() {
        //All init stuff
        player = new Player();
        storage = new Storage();
        garden = new Garden();
        actions = new HashMap<String, Action>();
        addActions();
        sports = new ArrayList<Sport>();
        addSports();
    }

    public void executeAction(String nameAction){
        HashMap<String,GameContex> context = makeContext(nameAction);
        actions.get(nameAction).execute(context);
    }

    public void executeAction(String nameAction, HashMap<String, GameContex> context){
        actions.get(nameAction).execute(context);
    }

    public void eatAction(Food selectedFood){
        HashMap<String, GameContex> context = new HashMap<String, GameContex>();
        context.put("player", (GameContex) player);
        context.put("food", (GameContex) selectedFood);
        executeAction("Eat", context);
    }

    private HashMap<String, GameContex> makeContext(String nameAction) {
        HashMap<String,GameContex> context = new HashMap<String,GameContex>();
        context.put("player", (GameContex) player);
        switch (nameAction){
            case "Gather":
                context.put("garden", (GameContex) garden);
                return context;
            default:
                return context;
        }
    }

    private void addActions(){
        actions.put("DoNothing", new DoNothingAction());
        actions.put("Eat", new EatAction());
        actions.put("Gather", new GatherAction());
        actions.put("GoBathroom", new GoBathroomAction());
        actions.put("GoFight", new GoFightAction());
        actions.put("Meditation", new MeditationAction());
        actions.put("Sleep", new SleepAction());
        actions.put("Socialize", new SocializeAction());
        actions.put("ToStock", new ToStockAction());
        actions.put("Workout", new WorkoutAction());
    }
    private void addSports(){
        sports.add(new Soccer());
        sports.add(new Swing());
    }

    public Player getPlayer() {
        return player;
    }

    public Storage getStorage() {
        return storage;
    }

    public Garden getGarden() {
        return garden;
    }

    public ArrayList<String> SportsNames(){
        ArrayList<String> names = new ArrayList<String>();
        for (Sport sport:sports) {
            names.add(sport.getName());
        }
        return names;
    }
}
