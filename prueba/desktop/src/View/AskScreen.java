package View;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import org.lwjgl.opengl.GL11;

public class AskScreen extends BaseScreen{

    private BitmapFont myText = new BitmapFont();

    private SpriteBatch localBatch;

    public AskScreen(mainView myGame){
        super(myGame);
        localBatch = myGame.getBatch();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL11.GL_COLOR_BUFFER_BIT);
        localBatch.begin();
        myText.draw(localBatch,"Ask for User", 100,100);
        localBatch.end();
        if(Gdx.input.isKeyPressed(Input.Keys.NUM_1)){
            myGame.setScreen(myGame.myAskScreen);
        }else if(Gdx.input.isKeyPressed(Input.Keys.NUM_2)){
            myGame.setScreen(myGame.myStorageScreen);
        }else if(Gdx.input.isKeyPressed(Input.Keys.NUM_3)){
            myGame.setScreen(myGame.myGameScreen);
        }
    }

    @Override
    public void dispose() {
        super.dispose();
        myText.dispose();
    }

}