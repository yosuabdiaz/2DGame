package View;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class MyActor extends Image {
    public MyActor(TextureRegion texture){
        super(texture);
        setBounds(getX(), getY(), getWidth(), getHeight());
        setPosition(280,100);
        addListener(new InputListener(){
            @Override
            public boolean keyDown(InputEvent event, int keycode){
                MoveToAction mba = new MoveToAction();
                switch (keycode){
                    case Input.Keys.NUM_1: // bathroom

                        mba.setPosition(130f,200f);
                        mba.setDuration(0.5f); // this change the speed
                        MyActor.this.addAction(mba);
                        break;
                    case Input.Keys.NUM_2: // kitchen

                        mba.setPosition(290f,210f);
                        mba.setDuration(0.5f); // this change the speed
                        MyActor.this.addAction(mba);
                        break;
                    case Input.Keys.NUM_3:// bedroom

                        mba.setPosition(310f,390f);
                        mba.setDuration(0.5f); // this change the speed
                        MyActor.this.addAction(mba);
                        break;
                    case Input.Keys.NUM_4:// right Room

                        mba.setPosition(10f,350f);
                        mba.setDuration(0.5f); // this change the speed
                        MyActor.this.addAction(mba);
                        break;
                    case Input.Keys.NUM_5: // Meditation

                        mba.setPosition(280f,100f);
                        mba.setDuration(0.5f); // this change the speed
                        MyActor.this.addAction(mba);
                        break;
                    case Input.Keys.NUM_6: // Socialize

                        mba.setPosition(350f,100f);
                        mba.setDuration(0.5f); // this change the speed
                        MyActor.this.addAction(mba);
                        break;
                    case Input.Keys.NUM_7: // train

                        mba.setPosition(10,100);
                        mba.setDuration(0.5f); // this change the speed
                        MyActor.this.addAction(mba);
                        break;
                    case Input.Keys.NUM_8: // Gather

                        mba.setPosition(10f,200f);
                        mba.setDuration(0.5f); // this change the speed
                        MyActor.this.addAction(mba);
                        break;

                }

                return true;
            }
        });
    }
}
