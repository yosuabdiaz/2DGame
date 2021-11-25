package View;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Skin; // yes
import controller.ExecutionAdmin;
import controller.MainController;
import controller.MementoAdmin;
import controller.NPCAdmin;
import model.Player;
import model.Storage;



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

    private Stage stage;
    private Skin skin;



    //Interface variables end
    //Game variables
    private final MainController myController = new MainController();
    private Player player1 = myController.getPlayer();
    private Storage storage = myController.getStorage();
    private ExecutionAdmin myExecutionAdmin = new ExecutionAdmin(player1);
    private MementoAdmin myMementoAdmin = new MementoAdmin();
    private boolean AcceptFight = false;
    private boolean AcceptFriend = false;
    private boolean AcceptDisease = false;
    private boolean AcceptSleep = false;

    private NPCAdmin myNPCAdmin = new NPCAdmin();

    private int control=0;

    public GameScreen(mainView myView) {
        super(myView);
        localBatch = myView.getBatch();
        houseMap = new Texture("map.jpeg");
        Texture moveTexture = new Texture("moving1.png");
        Texture moveTexture2 = new Texture("moving2.png");
        Texture attackTexture = new Texture("attack.png");
        Texture sleepTexture = new Texture("sleep.png");
        myText = new BitmapFont();
        makeAnimationA(moveTexture,6);
        makeAnimationB(attackTexture,6);
        makeAnimationC(moveTexture2,9);
        makeAnimationD(sleepTexture,3);
        weight = Gdx.graphics.getWidth();
        height = Gdx.graphics.getHeight();
        skin = new Skin(Gdx.files.internal("default_skin/uiskin.json"));
        Gdx.input.setInputProcessor(stage = new Stage());
        Texture img = new Texture("moving1.png");
        TextureRegion[][] moveTextureRegion = TextureRegion.split(img,img.getWidth()/6,img.getHeight());
        MyActor actor = new MyActor(moveTextureRegion[0][2]);
        stage.addActor(actor);
        stage.setKeyboardFocus(actor);
    }

    public boolean AcceptFigth(){
        if (AcceptFight == false){
            new Dialog("Confirm Figth", skin) {
                {
                    text("Yes/No");
                    button("Yes", true);
                    button("No", false);
                }

                @Override
                protected void result(final Object object) {
                    AcceptFight = (boolean)object;
                    System.out.printf(object.toString());
                }
            }.show(stage);
        }
        return AcceptFight;
    }
    public boolean AcceptFriend(){
        if (AcceptFriend == false){
            new Dialog("Confirm Friend", skin) {
                {
                    text("Yes/No");
                    button("Yes", true);
                    button("No", false);
                }

                @Override
                protected void result(final Object object) {
                    AcceptFriend = (boolean)object;
                    System.out.printf(object.toString());
                }
            }.show(stage);
        }
        return AcceptFriend;
    }
    public boolean AcceptDisease(){
        if (AcceptDisease == false){
            new Dialog("Confirm Disease", skin) {
                {
                    text("Yes/No");
                    button("Yes", true);
                    button("No", false);
                }

                @Override
                protected void result(final Object object) {
                    AcceptDisease = (boolean)object;
                    System.out.printf(object.toString());
                }
            }.show(stage);
        }
        return AcceptDisease;
    }
    public boolean AcceptSleep(){
        if (AcceptSleep == false){
            new Dialog("Confirm Sleep", skin) {
                {
                    text("Yes/No");
                    button("Yes", true);
                    button("No", false);
                }

                @Override
                protected void result(final Object object) {
                    AcceptSleep = (boolean)object;
                    System.out.printf(object.toString());
                }
            }.show(stage);
        }
        return AcceptSleep;
    }


    @Override
    public void render(float delta) {
        player1 = myController.getPlayer();
        player1.setAge(player1.getAge()+1);
        elapsedTime += Gdx.graphics.getDeltaTime();
        localBatch.begin();
        localBatch.draw(houseMap, 0, 0, weight, height);

        localBatch.draw((TextureRegion) animationTopRight.getKeyFrame(elapsedTime,true),515,60,50,50);
        localBatch.draw((TextureRegion) animationTopLeft.getKeyFrame(elapsedTime,true),575,58,50,50);
        localBatch.draw((TextureRegion) animationDownRight.getKeyFrame(elapsedTime,true),575,5,50,50);
        localBatch.draw((TextureRegion) animationDownLeft.getKeyFrame(elapsedTime,true),515,0,50,50);
        drawPlayerInfo();
        drawIndications();
        localBatch.end();

        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
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
    public void drawIndications(){
        myText.draw(localBatch,"1.Bathroom",10,90);
        myText.draw(localBatch,"2.Kitchen",10,75);
        myText.draw(localBatch,"3.Bedroom",10,60);
        myText.draw(localBatch,"4.Fight Room",10,45);
        myText.draw(localBatch,"5.Meditation",10,30);
        myText.draw(localBatch,"6.Socialize",100,90);
        myText.draw(localBatch,"7.Train",100,75);
        myText.draw(localBatch,"8.Gather",100,60);
        myText.draw(localBatch,"9.Eat",100,45);

    }

    public boolean getAcceptSleep(){
        return this.AcceptSleep;
    }

    public boolean getAcceptFight(){
        return this.AcceptFight;
    }

    public boolean getAcceptFriend(){
        return this.AcceptFriend;
    }

    public boolean getAcceptDisease(){
        return this.AcceptDisease;
    }

    public void setAcceptSleep(boolean x){
        this.AcceptSleep = x;
    }

    public void setAcceptFight(boolean x){
        this.AcceptFight = x;
    }

    public void setAcceptFriend(boolean x){
        this.AcceptFriend = x;
    }

    public void setAcceptDisease(boolean x){
        this.AcceptDisease = x;
    }

    public Player getPlayer(){
        return this.player1;
    }

    public MainController getMyController(){
        return this.myController;
    }
}
