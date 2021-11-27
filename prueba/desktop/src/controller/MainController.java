package controller;

import model.*;
import model.actions.*;


import java.util.ArrayList;
import com.badlogic.gdx.utils.Array;
import java.util.HashMap;

public class MainController {//I need a new name
    private Player player;
    private Storage storage;
    private Garden garden;
    private HashMap<String, Action> actions;
    private HashMap<String, Sport> sports;


    public MainController() {
        //All init stuff
        player = new Player();
        storage = new Storage();
        garden = new Garden();
        actions = new HashMap<String, Action>();
        addActions();
        sports = new HashMap<String, Sport>();
        addSports();
        Thread timingThread = new Thread(new ExecutionAdmin(player));
        timingThread.start();
    }

    public void executeAction(String nameAction) {
        HashMap<String, GameContex> context = makeContext(nameAction);
        actions.get(nameAction).execute(context);
    }

    public void executeAction(String nameAction, HashMap<String, GameContex> context) {
        actions.get(nameAction).execute(context);
    }

    public void eatAction(String nameSelected){
        HashMap<String, GameContex> context = new HashMap<String, GameContex>();
        if(storage.isFood(nameSelected)){
           context.put("food", (GameContex) storage.getFood(nameSelected));
        }else{
            context.put("medicine", (GameContex) storage.getMedicine(nameSelected));
        }
        context.put("player", (GameContex) player);
        executeAction("Eat", context);
    }

    public void workoutAction(String nameSport) {
        HashMap<String, GameContex> context = new HashMap<String, GameContex>();
        context.put("player", (GameContex) player);
        context.put("sport", (GameContex) sports.get(nameSport));
        executeAction("Workout", context);
    }

    private HashMap<String, GameContex> makeContext(String nameAction) {
        HashMap<String, GameContex> context = new HashMap<String, GameContex>();
        context.put("player", (GameContex) player);
        switch (nameAction) {
            case "Gather":
                context.put("garden", (GameContex) garden);
                return context;
            default:
                return context;
        }
    }

    private void addActions() {
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

    private void addSports() {
        sports.put("Soccer", new Soccer());
        sports.put("Swing", new Swing());
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

    public void setGarden(Garden garden){
        this.garden = garden;
    }

    public Array<String> SportsNames(){
        Array<String> array = new Array<String>();
        ArrayList<String> keySet = new ArrayList<>(sports.keySet());
        for(String key:keySet){
            array.add(key);
        }
        return array;
    }

    public Array getStorageNames(){
        return storage.getAll();
    }

    public String getSportSprite(String name){
        return sports.get(name).getSprite();
    }
}
