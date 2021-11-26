package model;

import model.actions.GameContex;
import org.SportLib.Attack;
import org.SportLib.Sport;

import java.util.ArrayList;

public class Soccer extends Sport implements GameContex {
    public Soccer() {
        super("Soccer", new ArrayList<Attack>(), "soccer.png", 90f);
        ArrayList<Attack> newLoot = new ArrayList<Attack>();
        newLoot.add(new Attack("patada1Futbol",15,"patada1Futbol.png"));
        newLoot.add(new Attack("patada2Futbol",25,"patada2Futbol.png"));
        newLoot.add(new Attack("patada3Futbol",35,"patada3Futbol.png"));
        //add more attacks
        setLoot(newLoot);
    }
}
