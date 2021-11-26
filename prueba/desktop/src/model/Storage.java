package model;

import model.actions.GameContex;
import com.badlogic.gdx.utils.Array;

import java.util.ArrayList;
import java.util.HashMap;

public class Storage implements GameContex {
    private ArrayList<Food> food;
    private ArrayList<Medicine> medicine;
    private HashMap<String, Integer> amountFood;
    private HashMap<String, Integer> amountMedicine;

    public Storage(){
        food = new ArrayList<Food>();
        medicine = new ArrayList<Medicine>();
        amountFood = new HashMap<String, Integer>();
        amountMedicine = new HashMap<String, Integer>();
    }

    public void addFood(Food food){
        if(amountFood.get(food.getName()) == null) {
            this.food.add(food);
            amountFood.put(food.getName(), 1);
        } else {
            amountFood.put(food.getName(), amountFood.get(food.getName()) + 1);
        }
    }

    public void addMedicine(Medicine medicine){
        if(amountMedicine.get(medicine.getName()) == null) {
            this.medicine.add(medicine);
            amountMedicine.put(medicine.getName(), 1);
        } else {
            amountMedicine.put(medicine.getName(), amountMedicine.get(medicine.getName()) + 1);
        }
    }

    public Array<String> getAll(){
        Array<String> array = new Array<String>();
        ArrayList<String> keysFood = new ArrayList<>(amountFood.keySet());
        for(String key:keysFood){
            array.add("Comida:" + key + ": "+ amountFood.get(key));
        }
        ArrayList<String> keysMedicine = new ArrayList<>(amountMedicine.keySet());
        for(String key:keysMedicine){
            array.add("Medicina:" + key + ": "+ amountMedicine.get(key));
        }

        return array;
    }
}
