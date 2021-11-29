package View;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Array;
import controller.ExecutionAdmin;
import controller.MainController;
import controller.MementoAdmin;
import controller.NPCAdmin;
import model.Food;
import model.Player;
import model.Storage;
import org.w3c.dom.Text;

import java.util.HashMap;

// 22/11/2021
// @autor: Yosua Andres Blanco Diaz
public class GameScreen extends BaseScreen{
    //Interface variables
    private SpriteBatch localBatch;
    private Texture houseMap;
    private int weight;
    private int height;
    private Animation animationTopRight, animationTopLeft,
            animationDownRight, animationDownLeft;

    private Animation gardenAnimation;
    private Animation friendAnimation;
    private Animation enemyAnimation;
    private BitmapFont  myText;
    private	float elapsedTime;
    private Stage stage;
    private Skin skin;
    private MyActor actor;
    //Interface variables end
    //Game variables
    private MainController myController;
    private Player player1;
    private Storage storage;
    //private MementoAdmin myMementoAdmin = new MementoAdmin();
    private boolean AcceptFight = false;
    private boolean AcceptFriend = false;
    private boolean AcceptDisease = false;
    private boolean AcceptSleep = false;
    private boolean FoodSelected = false;
    private NPCAdmin myNPCAdmin = new NPCAdmin();
    private int control=0;
    protected Texture moveTexture2 = new Texture("main1.png");
    protected String nameFile;
    protected boolean showGarden = false;
    private boolean showFriend = false;
    private  boolean showEnemy = false;
    private boolean maxLevel = true;
    public GameScreen(mainView myView, MainController mainController) {
        super(myView);
        myController = mainController;
        player1 = myController.getPlayer();
        storage = myController.getStorage();
        localBatch = myView.getBatch();
        loadImages();
        loadCharacter();

        /*Dummy Data
        HashMap<Integer,String> sprites = new HashMap<>();
        sprites.put(0,"main1.png");
        sprites.put(1,"main2.png");
        sprites.put(2,"main3.png");
        myController.getPlayer().setSprites(sprites);*/
        makeAnimationB(new Texture("dead.png"),11);
        loadGarden();
        loadFriend();
        /////////////////////////////
    }
    @Override
    public void render(float delta) {
        player1 = myController.getPlayer();
        elapsedTime += Gdx.graphics.getDeltaTime();
        localBatch.begin();
        localBatch.draw(houseMap, 0, 0, weight, height);
        localBatch.draw((TextureRegion) animationTopRight.getKeyFrame(elapsedTime,true),515,60,50,50);

        if(player1.getDisease() != null){
            localBatch.draw((TextureRegion) animationTopLeft.getKeyFrame(elapsedTime,true),575,65,50,50);
        }

        evolutionCharacter();
        localBatch.draw((TextureRegion) animationDownRight.getKeyFrame(elapsedTime,true),575,5,50,65);
        //localBatch.draw((TextureRegion) animationDownLeft.getKeyFrame(elapsedTime,true),515,0,50,50);
        if(showGarden){
            localBatch.draw((TextureRegion) gardenAnimation.getKeyFrame(elapsedTime,true),25,220,60,60);
        }
        if(showFriend){
            localBatch.draw((TextureRegion) friendAnimation.getKeyFrame(elapsedTime,true), 350,100,60,60);
        }
        loadEnemy();
        if(showEnemy){

            localBatch.draw((TextureRegion) enemyAnimation.getKeyFrame(elapsedTime,true), 10,360,60,60);
        }
        drawPlayerInfo();
        drawIndications();
        moveTexture2.dispose();
        localBatch.end();
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }
    public void setShowGarden(boolean x){
        this.showGarden = x;
    }
    public void evolutionCharacter(){

        if (player1.getAge() == 0 || player1.getAge() == 1 || player1.getAge() == 2 || player1.getAge() == 3 || player1.getAge() == 4 ){
            //System.out.println("evolution");
            nameFile = "main1.png";
            Texture Localmove = new Texture(nameFile);
            makeAnimationC(Localmove,11);
        }else if (player1.getAge() == 5 || player1.getAge() == 6 || player1.getAge() == 7 || player1.getAge() == 8 ){
            nameFile = "main2.png";
            Texture Localmove = new Texture(nameFile);
            makeAnimationC(Localmove,11);
        }else if(player1.getAge()>=9 && maxLevel) {
            maxLevel = false;
            nameFile = "main3.png";
            Texture Localmove = new Texture(nameFile);
            makeAnimationC(Localmove,11);
        }
    }
    public void loadGarden() {
        if (true){
            nameFile = "food.png";
            Texture Localmove = new Texture(nameFile);
            makeGarden(Localmove, 6);
        }
    }
    public void loadFriend() {
            nameFile = "enemy3.png";
            Texture Localmove = new Texture(nameFile);
            makefriend(Localmove, 11);
    }
    public void loadEnemy() {
        if (player1.getAge()==0){
            nameFile = "enemy2.png";
            Texture Localmove = new Texture(nameFile);
            makeEnemy(Localmove,11);
        }else{
            nameFile = "enemy1.png";
            Texture Localmove = new Texture(nameFile);
            makeEnemy(Localmove,11);
        }
    }
    public void makeEnemy(Texture tmpTexture, int numberOfSplits){
        TextureRegion[][] moveTextureRegion = TextureRegion.split(tmpTexture,tmpTexture.getWidth()/numberOfSplits,tmpTexture.getHeight());
        TextureRegion[] animationArray = new TextureRegion[numberOfSplits];
        int index = 0;
        for(int i= 0; i< numberOfSplits; i++){
            animationArray[index++] = moveTextureRegion[0][i];
        }
        enemyAnimation = new Animation(0.1f, animationArray);
    }
    public void makefriend(Texture tmpTexture, int numberOfSplits){
        TextureRegion[][] moveTextureRegion = TextureRegion.split(tmpTexture,tmpTexture.getWidth()/numberOfSplits,tmpTexture.getHeight());
        TextureRegion[] animationArray = new TextureRegion[numberOfSplits];
        int index = 0;
        for(int i= 0; i< numberOfSplits; i++){
            animationArray[index++] = moveTextureRegion[0][i];
        }
        friendAnimation = new Animation(0.1f, animationArray);
    }
    public void loadImages(){
        houseMap = new Texture("map.jpeg");
        Texture moveTexture = new Texture("moving1.png");

        Texture sleepTexture = new Texture("sleep.png");
        myText = new BitmapFont();
        makeAnimationA(moveTexture,6);

        makeAnimationD(sleepTexture,3);
        weight = Gdx.graphics.getWidth();
        height = Gdx.graphics.getHeight();
    }
    public void loadCharacter(){
        skin = new Skin(Gdx.files.internal("default_skin/uiskin.json"));
        Gdx.input.setInputProcessor(stage = new Stage());
        Texture img = new Texture("moving1.png");
        TextureRegion[][] moveTextureRegion = TextureRegion.split(img,img.getWidth()/6,img.getHeight());
        actor = new MyActor(moveTextureRegion[0][2]);
        stage.addActor(actor);
        stage.setKeyboardFocus(actor);
    }
    public void makeGarden(Texture tmpTexture, int numberOfSplits){
        TextureRegion[][] moveTextureRegion = TextureRegion.split(tmpTexture,tmpTexture.getWidth()/numberOfSplits,tmpTexture.getHeight());

        TextureRegion[] animationArray = new TextureRegion[numberOfSplits];
        int index = 0;
        for(int i= 0; i< numberOfSplits; i++){
            animationArray[index++] = moveTextureRegion[0][i];
        }
        gardenAnimation = new Animation(0.7f, animationArray);

    }
    public void makeAnimationA(Texture tmpTexture, int numberOfSplits){

        TextureRegion[][] moveTextureRegion = TextureRegion.split(tmpTexture,tmpTexture.getWidth()/numberOfSplits,tmpTexture.getHeight());
        TextureRegion[] animationArray = new TextureRegion[numberOfSplits];
        int index = 0;
        for(int i= 0; i< numberOfSplits; i++){
            animationArray[index++] = moveTextureRegion[0][i];
        }
        animationTopRight = new Animation(1f/8f, animationArray);
    }
    public void makeAnimationB(Texture tmpTexture, int numberOfSplits){
        TextureRegion[][] moveTextureRegion = TextureRegion.split(tmpTexture,tmpTexture.getWidth()/numberOfSplits,tmpTexture.getHeight());
        TextureRegion[] animationArray2 = new TextureRegion[numberOfSplits];
        int index = 0;
        for(int i= 0; i< numberOfSplits; i++){
            animationArray2[index++] = moveTextureRegion[0][i];
        }
        animationTopLeft = new Animation(1f/8f, animationArray2);
    }
    public void makeAnimationC(Texture tmpTexture, int numberOfSplits){
        TextureRegion[][] moveTextureRegion = TextureRegion.split(tmpTexture,tmpTexture.getWidth()/numberOfSplits,tmpTexture.getHeight());
        TextureRegion[] animationArray3 = new TextureRegion[numberOfSplits];
        int index = 0;
        for(int i= 0; i< numberOfSplits; i++){
            animationArray3[index++] = moveTextureRegion[0][i];
        }
        animationDownRight = new Animation(1f/8f, animationArray3);
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
        myText.draw(localBatch,"Hunger: "+ player1.getHunger(),515,400 );
        if (player1.getDisease() != null){
            myText.draw(localBatch,"Disease: "+ player1.getDisease().getName(),515,380 );
        }else{
            myText.draw(localBatch,"Disease:good",515,380 );
        }
        myText.draw(localBatch,"Train Charge: "+ player1.getTrainingCharge(),515,360 );
        myText.draw(localBatch,"Liquids: "+ player1.getRetainedLiquids(),515,340 );
        myText.draw(localBatch,"Pop: "+ player1.getEatenFood(),515,320 );
        myText.draw(localBatch,"Happiness: "+ player1.getHappiness(),515,300 );
        myText.draw(localBatch,"Muscles: "+ player1.getMuscles(),515,280 );
        myText.draw(localBatch,"Speed: "+ player1.getSpeed(),515,260 );
        myText.draw(localBatch,"Strength: "+ player1.getStrength(),515,240 );
        myText.draw(localBatch,"Fatness: "+ player1.getFatness(),515,220 );
        myText.draw(localBatch,"MentalHealth: "+ player1.getMentalHealth(),515,200 );
        myText.draw(localBatch,"PhysicalHealth: "+ player1.getPhysicalHealth(),515,180 );
        myText.draw(localBatch,"Meditation: "+ player1.getMeditation(),515,160 );
        myText.draw(localBatch,"Energy: "+ player1.getEnergy(),515,140 );
        myText.draw(localBatch, myController.getExecutionAdmin().getHours()+":"+myController.getExecutionAdmin().getMinutes(),300,90);
        if (player1.getInjury() != null){
            myText.draw(localBatch, "Injury:"+player1.getInjury().getName(),300,75);
        }else{
            myText.draw(localBatch, "Injury: none",300,75);
        }

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

    }
    public Player getPlayer(){
        return this.player1;
    }
    public MainController getMyController(){
        return this.myController;
    }
    public void FoodSelected(){
        Array<String> food = new Array<>();
        food = myController.getStorageNames();
        final SelectBox<String> selectBox=new SelectBox<String>(skin);
        final Array<String> finalFood = food;
        makeAnimationA(new Texture("chest.png"),3);
        Dialog d = new Dialog("Select food", skin) {
            {
                text("Select:");
                button("Yes", true);
                button("No", false);
                selectBox.setItems(finalFood);
                getContentTable().defaults().pad(20);
                getContentTable().add(selectBox);
            }

            @Override
            protected void result(final Object object) {
                AcceptDisease = (boolean)object;
                System.out.printf(object.toString());
                if((boolean)object){
                    //set food

                    float speedMove = myController.getPlayer().getSpeed();;
                    MoveToAction mba = new MoveToAction();
                    mba.setPosition(130f,350f);
                    mba.setDuration(speedMove);
                    actor.addAction(mba);

                    myController.executeAction("ToStock");
                    myController.eatAction(selectBox.getSelected().split(":")[1]);
                }
            }


        }.show(stage);
    }
    public void SportSelected(){
        Array<String> sport = new Array<>();
        sport = myController.SportsNames();
        final SelectBox<String> selectBox=new SelectBox<String>(skin);
        final Array<String> finalSport = sport;
        Dialog d = new Dialog("Select sport", skin) {
            {
                text("Select:");
                button("Yes", true);
                button("No", false);
                selectBox.setItems(finalSport);
                getContentTable().defaults().pad(20);
                getContentTable().add(selectBox);
            }

            @Override
            protected void result(final Object object) {
                AcceptDisease = (boolean)object;
                System.out.printf(object.toString());
                if((boolean)object){
                    //set sport
                    myController.workoutAction(selectBox.getSelected());
                    makeAnimationA(new Texture(myController.getSportSprite(selectBox.getSelected())),4);
                }
            }
        }.show(stage);
    }
    public void selectAttack(){
        player1.cleanSelectedAttacks();
        Array<String> attacks = new Array<>();
        attacks = myController.attacksNames();
        final Array<String> finalAttacks = attacks;

        for (String x :attacks) {
            final SelectBox<String> selectBox1=new SelectBox<String>(skin);
            new Dialog("Select attack:", skin){
                {
                    text("");
                    button("Yes",true);
                    button("No",false);
                    selectBox1.setItems(finalAttacks);
                    getContentTable().defaults().pad(10);
                    getContentTable().add(selectBox1);
                }

                @Override
                protected void result(final Object object){
                    if((boolean) object){
                        myController.addSelectedAttack(selectBox1.getSelected());

                        System.out.printf("selectBox1.getSelected()="+myController.getSeletedAtacks());
                    }
                }
            }.show(stage);
        }
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public boolean AcceptFigth(){
        AcceptFight = false;
            new Dialog("Confirm Figth", skin) {
                {
                    showEnemy = true;
                    text("Yes/No");
                    button("Yes", true);
                    button("No", false);
                }

                @Override
                protected void result(final Object object) {
                    showEnemy = false;
                    if((boolean)object){
                        float speedMove = myController.getPlayer().getSpeed();;
                        MoveToAction mba = new MoveToAction();
                        mba.setPosition(10,350f);
                        mba.setDuration(speedMove);
                        actor.addAction(mba);
                        AcceptFight = (boolean)object;
                    }
                }
            }.show(stage);

        return AcceptFight;
    }
    public boolean AcceptFriend(){
        showFriend = true;
        if (AcceptFriend == false){
            new Dialog("Confirm Friend", skin) {
                {
                    text("Yes/No");
                    button("Yes", true);
                    button("No", false);
                }

                @Override
                protected void result(final Object object) {
                    showFriend = false;
                    AcceptFriend = (boolean)object;
                    System.out.printf(object.toString());
                    float speedMove = myController.getPlayer().getSpeed();;
                    MoveToAction mba = new MoveToAction();
                    mba.setPosition(130f,350f);
                    mba.setDuration(speedMove);
                    actor.addAction(mba);
                }
            }.show(stage);
        }
        return AcceptFriend;
    }
    public boolean AcceptDisease(){
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
                    if(AcceptSleep){
                        myController.executeAction("Sleep");

                        float speedMove = myController.getPlayer().getSpeed();;
                        MoveToAction mba = new MoveToAction();
                        mba.setPosition(310,390);
                        mba.setDuration(speedMove);
                        actor.addAction(mba);

                    }
                }
            }.show(stage);
        }
        return AcceptSleep;
    }
    public void AcceptGather(){
        showGarden = true;
        new Dialog("Confirm Gather", skin) {
            {
                text("Yes/No");
                button("Yes", false);
                button("No", true);
            }

            @Override
            protected void result(final Object object) {
                showGarden = (boolean)object;
                if((boolean)object){
                    myController.executeAction("Gather");//GatherAction!
                    float speedMove = myController.getPlayer().getSpeed();//0.5f;
                    MoveToAction mba = new MoveToAction();
                    mba.setPosition(290f,210f);
                    mba.setDuration(speedMove);
                    actor.addAction(mba);
                }
            }
        }.show(stage);
    }
    public void acceptDead(){
            final SelectBox<String> selectBox1=new SelectBox<String>(skin);

            new Dialog("Select day:", skin){
                {
                    text("");
                    button("Yes",true);
                    button("No",false);
                    selectBox1.setItems("1","2","3");
                    getContentTable().defaults().pad(10);
                    getContentTable().add(selectBox1);
                }

                @Override
                protected void result(final Object object){
                    if((boolean) object){
                        System.out.printf("selectBox1.getSelected() -1 ="+selectBox1.getSelected());
                        myController.dead(Integer.parseInt( selectBox1.getSelected()) -1);
                    }
                    else {
                        myController.dead();
                    }
                }
            }.show(stage);
    }
    public void resume(final String message){
        new Dialog("Confirm Figth", skin) {
            {
                text(message);
                button("OK", true);

            }

            @Override
            protected void result(final Object object) {
            }
        }.show(stage);
    }
    public Skin getSkin(){
        return this.skin;
    }
    public Stage getStage(){
        return this.stage;
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
    public int getWeight(){
        return weight;
    }
    public int getHeight(){
        return height;
    }
    @Override
    public void dispose(){
        if (localBatch!=null){
            localBatch.dispose();
            localBatch = null;
        }
        stage.dispose();
        myText.dispose();
    }
}