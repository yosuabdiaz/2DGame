package model.actions;

import model.Cure;

import java.util.HashMap;

public abstract class Action implements Cure {
    Action(){}

    /**
     * Context have ({"player",player},{"anothername",anotherStuff},...)
     * @param contex
     */
    public abstract void execute(HashMap<String,GameContex> contex);
    public abstract void render();
}
