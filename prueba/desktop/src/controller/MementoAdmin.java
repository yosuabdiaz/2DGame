package controller;

import model.Configuration;
import model.Memento;

import java.util.LinkedList;
import java.util.Queue;

public class MementoAdmin {
    private Queue<Memento> states = new LinkedList<>();
    private int maxSavedStates = 3;

    public MementoAdmin(){
        maxSavedStates = Configuration.getInstance().getSavedDays();
    }

    public void addMemento(Memento memento){
        if(states.size() -1 == maxSavedStates){
            states.remove();
            states.add(memento);
            //Agregar escritura en disco
        }
        else{
            states.add(memento);
            //Agregar escritura en disco
        }
    }

    public Memento getMemento(int index){
        if(index > 0 && index < maxSavedStates ){
            return (Memento) ((LinkedList)states).get(index);
        }
        return null;
    }
}
