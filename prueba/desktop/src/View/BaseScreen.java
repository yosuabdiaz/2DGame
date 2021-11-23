package View;

import com.badlogic.gdx.Screen;

public abstract class BaseScreen implements Screen {
    protected mainView myGame;

    public BaseScreen(mainView myView){
        this.myGame = myView;
    }

    @Override
    public void show() {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
