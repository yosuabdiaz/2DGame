package model;

import model.actions.GameContex;
import com.badlogic.gdx.utils.Array;

import java.util.ArrayList;

public class Storage implements GameContex {
    private ArrayList<Food> food;
    private ArrayList<Medicine> medicine;

    public Storage(){
        food = new ArrayList<Food>();
        medicine = new ArrayList<Medicine>();
    }

    public void addFood(Food food){
        this.food.add(food);
    }

    public void addMedicine(Medicine medicine){
        this.medicine.add(medicine);
    }

    public Array<String> getAll(){
        Array<String> array = new Array<String>();
        for(Food food:food){
            array.add(food.getName());
        }
        for(Medicine medicine:medicine){
            array.add(medicine.getName());
        }
        return array;
    }
}
