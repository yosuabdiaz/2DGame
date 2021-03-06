package View;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import controller.ExecutionAdmin;
import controller.MainController;
import controller.MementoAdmin;
import controller.NPCAdmin;
import model.Player;
import model.Storage;
// 22/11/2021
// @autor: Yosua Andres Blanco Diaz
public class mainView extends Game {

    private SpriteBatch batch;
    private StorageScreen myStorageScreen;
    private GameScreen myGameScreen;
    private MainController myController = new MainController();
    private Player player1 = myController.getPlayer();
    private Storage storage = myController.getStorage();


    private static mainView instance;

    public static mainView getInstance() {
        if (instance != null)
            return instance;
        instance = new mainView();
        return instance;
    }

    private mainView(){

    }

    public StorageScreen getMyStorageScreen(){
        return this.myStorageScreen;
    }

    public GameScreen getMyGameScreen(){
        return this.myGameScreen;
    }
    @Override
    public void create() {
        batch = new SpriteBatch();
        myStorageScreen = new StorageScreen(this);
        myGameScreen = new GameScreen(this, myController);

        setScreen(myGameScreen);
    }
    @Override
    public void dispose(){
        super.dispose();
        this.batch = batch;
    }
    public SpriteBatch getBatch(){
        return batch;
    }
}
