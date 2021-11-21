package controller;

import model.Player;
import model.Sport;
import model.Storage;
import model.actions.*;

import java.util.ArrayList;

public class MainController {//I need a new name
    private Player player;
    private Storage storage;
    private ArrayList<Action> actions;
    private ArrayList<Sport> sports;

    public MainController() {
        //All init stuff
        player = new Player();
        storage = new Storage();
        actions = new ArrayList<Action>();
        addActions();
        sports = new ArrayList<Sport>();
        addSports();
    }

    public void executeAction(ArrayList<GameContex> context, int indexAction){
        actions.get(indexAction).execute(context);
    }
    private void addActions(){
        actions.add(new DoNothingAction(player));
        actions.add(new EatAction(player));
        actions.add(new GatherAction(player));
        actions.add(new GoBathroomAction(player));
        actions.add(new GoFightAction(player));
        actions.add(new MeditationAction(player));
        actions.add(new SleepAction(player));
        actions.add(new SocializeAction(player));
        actions.add(new ToStockAction(player));
        actions.add(new WorkoutAction(player));
    }
    private void addSports(){
        //
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public ArrayList<Action> getActions() {
        return actions;
    }

    public void setActions(ArrayList<Action> actions) {
        this.actions = actions;
    }

    public ArrayList<Sport> getSports() {
        return sports;
    }

    public void setSports(ArrayList<Sport> sports) {
        this.sports = sports;
    }
}
