package model;

import java.util.ArrayList;
import java.util.Random;

public class Garden {
    private ArrayList<Food> existentFood = new ArrayList<Food>();
    private ArrayList<Cure> existentCures = new ArrayList<Cure>();
    private ArrayList<Food> food = new ArrayList<Food>();
    private ArrayList<Cure> cures = new ArrayList<Cure>();

    public void growGarden(){
        Random rand = new Random();
        Configuration config = Configuration.getInstance();
        if(!food.isEmpty()) {
            for (int i = 0; i < config.getFoodInGarden(); i++) {
                int randIndex = rand.nextInt(existentFood.size());
                food.add(existentFood.get(randIndex));
            }
        }
        if(!cures.isEmpty()) {
            int cureProbability = rand.nextInt(100);
            if (cureProbability < config.getCureProbability()) {
                int cureQuantity = rand.nextInt();

                for(int i = 0; i < cureQuantity; i++){
                    int randIndex = rand.nextInt(existentCures.size());
                    cures.add(cures.get(randIndex));
                }

            }
        }

    }
    public ArrayList<Food> harvestGardenFood(){
        ArrayList<Food> harvestedFood = (ArrayList<Food>)food.clone();
        food.clear();
        return harvestedFood;
    }

    public ArrayList<Cure> harvestGardenCures(){
        ArrayList<Cure> harvestedCures = (ArrayList<Cure>)cures.clone();
        cures.clear();
        return harvestedCures;
    }
}
