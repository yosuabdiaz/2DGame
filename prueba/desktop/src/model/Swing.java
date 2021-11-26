package model;

import org.SportLib.Attack;
import org.SportLib.Sport;

import java.util.ArrayList;

public class Swing extends Sport {
    public Swing() {
        super("Swing", new ArrayList<Attack>(), "swing.png", 15f);
        ArrayList<Attack> newLoot = new ArrayList<Attack>();
        newLoot.add(new Attack("patada1Nadar",15,"patada1Nadar.png"));
        newLoot.add(new Attack("patada2Nadar",25,"patada2Nadar.png"));
        newLoot.add(new Attack("patada3Nadar",35,"patada3Nadar.png"));
        //add more attacks
        setLoot(newLoot);
    }
}
