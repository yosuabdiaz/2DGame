package controller;

import Utils.DiseaseReader;
import model.*;
import model.actions.*;


import java.io.File;
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
        Configuration config = Configuration.getInstance();
        player = new Player();
        storage = new Storage();
        garden = new Garden();
        actions = new HashMap<String, Action>();
        addActions();
        sports = new HashMap<String, Sport>();
        addSports();
        Thread timingThread = new Thread(new ExecutionAdmin(player));
        timingThread.start();
        Disease d = new Disease();
        //Pruevas
        DiseaseInfo info1 = new DiseaseInfo(3,true);
        DiseaseInfo info2 = new DiseaseInfo(2,false);
        DiseaseInfo info3 = new DiseaseInfo(6,true);
        DiseaseInfo info4 = new DiseaseInfo(34,true);
        d.setName("Gripe");

        HashMap<Stats, DiseaseInfo> h1 = new HashMap();
        HashMap<Stats, DiseaseInfo> h2 = new HashMap();
        h1.put(Stats.FATNESS, info1);
        h1.put(Stats.STRENGTH, info2);
        h1.put(Stats.HUNGER, info3);
        h1.put(Stats.PHYSICAL_HEALTH, info4);

        d.setEffects(h1);
        d.setTriggers(h2);

        d.setSprite("Sprite.png");
        ArrayList<Cure> cures = new ArrayList<>();
        cures.add(new Medicine("Paracetamol", 2, null));
        d.setCures(cures);

        DiseaseReader r = new DiseaseReader();
        //r.write(d, config.getDiseasePath());
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

    private void readFromDisk(){

    }
}
