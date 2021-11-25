package controller;

import model.Player;
import model.Sport;
import model.Storage;
import model.actions.*;

import java.util.ArrayList;
import java.util.HashMap;

public class MainController {//I need a new name
    private Player player;
    private Storage storage;
    private HashMap<String ,Action> actions;
    private ArrayList<Sport> sports;

    public MainController() {
        //All init stuff
        player = new Player();
        storage = new Storage();
        actions = new HashMap<String, Action>();
        addActions();
        sports = new ArrayList<Sport>();
        addSports();
    }

    public void executeAction(HashMap<String,GameContex> context, String nameAction){
        context.put("player", (GameContex) player);
        actions.get(nameAction).execute(context);
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
        //
    }

    public Player getPlayer() {
        return player;
    }

    public Storage getStorage() {
        return storage;
    }

    public ArrayList<Sport> getSports() {
        return sports;
    }
}
