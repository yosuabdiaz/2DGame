package View;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import controller.ExecutionAdmin;
import controller.MainController;
import controller.MementoAdmin;
import controller.NPCAdmin;
import model.Player;
import model.Storage;

import java.awt.*;

public class GameScreen extends BaseScreen{
    //Interface variables
    private final SpriteBatch localBatch;
    private final Texture houseMap;
    private final int weight;
    private final int height;
    private Animation animationTopRight, animationTopLeft,
            animationDownRight, animationDownLeft;
    private final BitmapFont  myText;
    private	float elapsedTime;

    //Interface variables end
    //Game variables
    private final MainController myController = new MainController();
    private Player player1 = myController.getPlayer();
    private Storage storage = myController.getStorage();
    private ExecutionAdmin myExecutionAdmin = new ExecutionAdmin(player1);
    private MementoAdmin myMementoAdmin = new MementoAdmin();

    private NPCAdmin myNPCAdmin = new NPCAdmin();
    public GameScreen(mainView myView) {
        super(myView);
        localBatch = myView.getBatch();
        houseMap = new Texture("map.jpeg");
        Texture moveTexture = new Texture("moving1.png");
        Texture moveTexture2 = new Texture("moving2.png");
        Texture attackTexture = new Texture("attack2.png");
        Texture sleepTexture = new Texture("sleep.png");
        myText = new BitmapFont();
        makeAnimationA(moveTexture,6);
        makeAnimationB(attackTexture,6);
        makeAnimationC(moveTexture2,9);
        makeAnimationD(sleepTexture,3);
        weight = Gdx.graphics.getWidth();
        height = Gdx.graphics.getHeight();
    }

    @Override
    public void render(float delta) {
        player1 = myController.getPlayer();
        player1.setAge(player1.getAge()+1);
        elapsedTime += Gdx.graphics.getDeltaTime();
        localBatch.begin();
        localBatch.draw(houseMap, 0, 0, weight, height);

        localBatch.draw((TextureRegion) animationTopRight.getKeyFrame(elapsedTime,true),515,51);
        localBatch.draw((TextureRegion) animationTopLeft.getKeyFrame(elapsedTime,true),575,58);
        localBatch.draw((TextureRegion) animationDownRight.getKeyFrame(elapsedTime,true),575,5);
        localBatch.draw((TextureRegion) animationDownLeft.getKeyFrame(elapsedTime,true),515,0);
        drawPlayerInfo();
        localBatch.end();

        if(Gdx.input.isKeyPressed(Input.Keys.NUM_1)){
            myGame.setScreen(myGame.myAskScreen);
        }else if(Gdx.input.isKeyPressed(Input.Keys.NUM_2)){
            myGame.setScreen(myGame.myStorageScreen);
        }else if(Gdx.input.isKeyPressed(Input.Keys.NUM_3)){
            myGame.setScreen(myGame.myGameScreen);
        }

    }
    public void makeAnimationA(Texture tmpTexture, int numberOfSplits){
        TextureRegion[][] moveTextureRegion = TextureRegion.split(tmpTexture,tmpTexture.getWidth()/numberOfSplits,tmpTexture.getHeight());
        TextureRegion[] animationArray = new TextureRegion[numberOfSplits];
        int index = 0;
        for(int i= 0; i< numberOfSplits; i++){
            animationArray[index++] = moveTextureRegion[0][i];
        }
        animationTopRight = new Animation(1f/4f, animationArray);
    }
    public void makeAnimationB(Texture tmpTexture, int numberOfSplits){
        TextureRegion[][] moveTextureRegion = TextureRegion.split(tmpTexture,tmpTexture.getWidth()/numberOfSplits,tmpTexture.getHeight());
        TextureRegion[] animationArray2 = new TextureRegion[numberOfSplits];
        int index = 0;
        for(int i= 0; i< numberOfSplits; i++){
            animationArray2[index++] = moveTextureRegion[0][i];
        }
        animationTopLeft = new Animation(1f/4f, animationArray2);
    }
    public void makeAnimationC(Texture tmpTexture, int numberOfSplits){
        TextureRegion[][] moveTextureRegion = TextureRegion.split(tmpTexture,tmpTexture.getWidth()/numberOfSplits,tmpTexture.getHeight());
        TextureRegion[] animationArray3 = new TextureRegion[numberOfSplits];
        int index = 0;
        for(int i= 0; i< numberOfSplits; i++){
            animationArray3[index++] = moveTextureRegion[0][i];
        }
        animationDownRight = new Animation(1f/4f, animationArray3);
    }
    public void makeAnimationD(Texture tmpTexture, int numberOfSplits){
        TextureRegion[][] moveTextureRegion = TextureRegion.split(tmpTexture,tmpTexture.getWidth()/numberOfSplits,tmpTexture.getHeight());
        TextureRegion[] animationArray4 = new TextureRegion[numberOfSplits];
        int index = 0;
        for(int i= 0; i< numberOfSplits; i++){
            animationArray4[index++] = moveTextureRegion[0][i];
        }
        animationDownLeft = new Animation(1f/8f, animationArray4);
    }
    public void drawPlayerInfo(){
        // titles : value
        myText.setColor(Color.BLACK);
        myText.draw(localBatch,"Stats: ",555,460 );
        myText.draw(localBatch,"Age: "+ player1.getAge(),515,440 );
        myText.draw(localBatch,"Sleep: "+ player1.getSleep(),515,420 );
        myText.draw(localBatch,"hunger: "+ player1.getHunger(),515,400 );
        if (player1.getDisease() != null){
            myText.draw(localBatch,"disease: "+ player1.getDisease().getName(),515,380 );
        }else{
            myText.draw(localBatch,"disease: healthy",515,380 );
        }
        myText.draw(localBatch,"trainingCharge: "+ player1.getTrainingCharge(),515,360 );
        myText.draw(localBatch,"retainedLiquids: "+ player1.getRetainedLiquids(),515,340 );
        myText.draw(localBatch,"eatenFood: "+ player1.getEatenFood(),515,320 );
        myText.draw(localBatch,"happiness: "+ player1.getHappiness(),515,300 );
        myText.draw(localBatch,"muscles: "+ player1.getMuscles(),515,280 );
        myText.draw(localBatch,"speed: "+ player1.getSpeed(),515,260 );
        myText.draw(localBatch,"strength: "+ player1.getStrength(),515,240 );
        myText.draw(localBatch,"fatness: "+ player1.getFatness(),515,220 );
        myText.draw(localBatch,"mentalHealth: "+ player1.getMentalHealth(),515,200 );
        myText.draw(localBatch,"physicalHealth: "+ player1.getPhysicalHealth(),515,180 );
        myText.draw(localBatch,"meditation: "+ player1.getMeditation(),515,160 );
        myText.draw(localBatch,"energy: "+ player1.getEnergy(),515,140 );
    }
}
