package View;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.lwjgl.opengl.GL11;

public class StorageScreen extends BaseScreen{

    private BitmapFont myText = new BitmapFont();

    private SpriteBatch localBatch;

    public StorageScreen(mainView myGame){
        super(myGame);
        localBatch = myGame.getBatch();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL11.GL_COLOR_BUFFER_BIT);
        localBatch.begin();
        myText.draw(localBatch, "Storage Screen",100,100);
        localBatch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
        myText.dispose();
    }
}
