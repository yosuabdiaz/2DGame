package View;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;
import controller.*;
import model.*;
// 22/11/2021
// @autor: Yosua Andres Blanco Diaz
public class mainView extends Game {
    private SpriteBatch batch;

    private Texture houseMap, moveTexture,
            moveTexture2, attackTexture,
            sleepTexture;

    private int weight, height;

    private TextureRegion[] animationArray, animationArray2,
            animationArray3, animationArray4;

    private Animation animationTopRight, animationTopLeft,
            animationDownRight, animationDownLeft;

    private BitmapFont  myText;

    private	float elapsedTime;

    private MainController myController = new MainController();

    private Player player1 = new Player();

    @Override
    public void create() {
        batch = new SpriteBatch();
        houseMap = new Texture("map.jpeg");
        moveTexture = new Texture("moving1.png");
        moveTexture2 = new Texture("moving2.png");
        attackTexture = new Texture("attack2.png");
        sleepTexture = new Texture("sleep.png");
        myText = new BitmapFont();
        makeAnimationA(moveTexture,6);
        makeAnimationB(attackTexture,6);
        makeAnimationC(moveTexture2,9);
        makeAnimationD(sleepTexture,3);

        weight = Gdx.graphics.getWidth();
        height = Gdx.graphics.getHeight();
    }

    public void makeAnimationA(Texture tmpTexture, int numberOfSplits){
        TextureRegion[][] moveTextureRegion = TextureRegion.split(tmpTexture,tmpTexture.getWidth()/numberOfSplits,tmpTexture.getHeight());
        animationArray = new TextureRegion[numberOfSplits];
        int index = 0;
        for(int i= 0; i< numberOfSplits; i++){
            animationArray[index++] = moveTextureRegion[0][i];
        }
        animationTopRight = new Animation(1f/4f,animationArray);
    }

    public void makeAnimationB(Texture tmpTexture, int numberOfSplits){
        TextureRegion[][] moveTextureRegion = TextureRegion.split(tmpTexture,tmpTexture.getWidth()/numberOfSplits,tmpTexture.getHeight());
        animationArray2 = new TextureRegion[numberOfSplits];
        int index = 0;
        for(int i= 0; i< numberOfSplits; i++){
            animationArray2[index++] = moveTextureRegion[0][i];
        }
        animationTopLeft = new Animation(1f/4f,animationArray2);
    }
    public void makeAnimationC(Texture tmpTexture, int numberOfSplits){
        TextureRegion[][] moveTextureRegion = TextureRegion.split(tmpTexture,tmpTexture.getWidth()/numberOfSplits,tmpTexture.getHeight());
        animationArray3 = new TextureRegion[numberOfSplits];
        int index = 0;
        for(int i= 0; i< numberOfSplits; i++){
            animationArray3[index++] = moveTextureRegion[0][i];
        }
        animationDownRight = new Animation(1f/4f,animationArray3);
    }

    public void makeAnimationD(Texture tmpTexture, int numberOfSplits){
        TextureRegion[][] moveTextureRegion = TextureRegion.split(tmpTexture,tmpTexture.getWidth()/numberOfSplits,tmpTexture.getHeight());
        animationArray4 = new TextureRegion[numberOfSplits];
        int index = 0;
        for(int i= 0; i< numberOfSplits; i++){
            animationArray4[index++] = moveTextureRegion[0][i];
        }
        animationDownLeft = new Animation(1f/8f,animationArray4);
    }

    @Override
    public void render () {
        player1 = myController.getPlayer();
        elapsedTime += Gdx.graphics.getDeltaTime();
        ScreenUtils.clear(1, 0, 0, 1);
        batch.begin();
        batch.draw(houseMap, 0, 0, weight, height);

        batch.draw((TextureRegion) animationTopRight.getKeyFrame(elapsedTime,true),515,51);
        batch.draw((TextureRegion) animationTopLeft.getKeyFrame(elapsedTime,true),575,58);
        batch.draw((TextureRegion) animationDownRight.getKeyFrame(elapsedTime,true),575,5);
        batch.draw((TextureRegion) animationDownLeft.getKeyFrame(elapsedTime,true),515,0);
        drawPlayerInfo();
        batch.end();

    }

    public void drawPlayerInfo(){
        // titles : value
        myText.setColor(Color.BLACK);
        myText.draw(batch,"Stats: ",555,460 );
        myText.draw(batch,"Age: "+ player1.getAge(),515,440 );
        myText.draw(batch,"Sleep: "+ player1.getSleep(),515,420 );
        myText.draw(batch,"hunger: "+ player1.getHunger(),515,400 );
        myText.draw(batch,"disease: "+ player1.getDisease(),515,380 );//faltan los metodos de disease
        myText.draw(batch,"trainingCharge: "+ player1.getTrainingCharge(),515,360 );
        myText.draw(batch,"retainedLiquids: "+ player1.getRetainedLiquids(),515,340 );
        myText.draw(batch,"eatenFood: "+ player1.getEatenFood(),515,320 );
        myText.draw(batch,"happiness: "+ player1.getHappiness(),515,300 );
        myText.draw(batch,"muscles: "+ player1.getMuscles(),515,280 );
        myText.draw(batch,"speed: "+ player1.getSpeed(),515,260 );
        myText.draw(batch,"strength: "+ player1.getStrength(),515,240 );
        myText.draw(batch,"fatness: "+ player1.getFatness(),515,220 );
        myText.draw(batch,"mentalHealth: "+ player1.getMentalHealth(),515,200 );
        myText.draw(batch,"physicalHealth: "+ player1.getPhysicalHealth(),515,180 );
        myText.draw(batch,"meditation: "+ player1.getMeditation(),515,160 );
        //myText.draw(batch,""+player1.getAge(),515,460 );
    }
}
