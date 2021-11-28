package model;

import Utils.FoodReader;
import Utils.MedicineReader;
import View.mainView;
import com.badlogic.gdx.Game;
import model.actions.GameContex;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;

public class Garden implements GameContex {
    private ArrayList<Food> existentFood = new ArrayList<Food>();
    private ArrayList<Cure> existentCures = new ArrayList<Cure>();
    private ArrayList<Food> food = new ArrayList<Food>();
    private ArrayList<Cure> cures = new ArrayList<Cure>();

    public Garden() {
        loadData();
        //growGarden();
        harvestGardenFood();
        harvestGardenFood();
    }

    public void growGarden(){
        Random rand = new Random();
        Configuration config = Configuration.getInstance();
        if(food.isEmpty()) {
            System.out.println(mainView.getInstance().getMyGameScreen());
            mainView.getInstance().getMyGameScreen().setShowGarden(true);
            for (int i = 0; i < config.getFoodInGarden(); i++) {
                int randIndex = rand.nextInt(existentFood.size());
                food.add(existentFood.get(randIndex));
            }
        }
        if(cures.isEmpty()) {
            int cureProbability = rand.nextInt(100);
            if (cureProbability < config.getCureProbability()) {
                int cureQuantity = rand.nextInt(50);
                for(int i = 0; i < cureQuantity; i++){
                    int randIndex = rand.nextInt(existentCures.size());
                    cures.add(existentCures.get(randIndex));
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

    private void loadData(){
        File folder = new File(Configuration.getInstance().getFoodPath());
        File[] files = folder.listFiles();
        FoodReader r = new FoodReader();
        for(File f : files){
            System.out.println(f);
                Food food = r.read(f.getPath());
                if(food != null){
                    existentFood.add(food);
                }
        }
        folder = new File(Configuration.getInstance().getMedicinePath());
        files = folder.listFiles();
        MedicineReader mr = new MedicineReader();
        for(File f : files){
            Medicine medicine = mr.read(f.getPath());
            if(medicine != null){
                existentCures.add(medicine);
            }
        }
    }
}
