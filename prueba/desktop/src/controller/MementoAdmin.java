package controller;

import Utils.MedicineReader;
import Utils.MementoReader;
import model.Configuration;
import model.Memento;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;

public class MementoAdmin {
    private Queue<Memento> states = new LinkedList<>();
    private int maxSavedStates = 3;
    private MementoReader reader =  new MementoReader();
    private String path;

    public MementoAdmin(){
        maxSavedStates = Configuration.getInstance().getSavedDays();
        path = Configuration.getInstance().getMementoPath();
        loadMemento();
    }

    public void addMemento(Memento memento){
        if(states.size() -1 == maxSavedStates){
            states.remove();
        }
        System.out.println( memento.getPlayer().getAge());
        states.add(memento);
        reader.write(states, path);
    }

    public Memento getMemento(int index){
        if(index > 0 && index < maxSavedStates ){
            return (Memento) ((LinkedList)states).get(index);
        }
        return null;
    }

    public void loadMemento(){

        Queue<Memento> temp = reader.read(path);
        states = (temp != null)? temp: states;
        //System.out.println(((LinkedList<Memento>)states).get(2).getPlayer().getAge());
    }
}
