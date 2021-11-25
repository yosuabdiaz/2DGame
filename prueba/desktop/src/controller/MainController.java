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
        actions.add(new DoNothingAction(player)); //0
        actions.add(new EatAction(player));//1
        actions.add(new GatherAction(player));//2
        actions.add(new GoBathroomAction(player));//3
        actions.add(new GoFightAction(player));//4
        actions.add(new MeditationAction(player));//5
        actions.add(new SleepAction(player));//6
        actions.add(new SocializeAction(player));//7
        actions.add(new ToStockAction(player));//8 kitchen
        actions.add(new WorkoutAction(player));//9
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
