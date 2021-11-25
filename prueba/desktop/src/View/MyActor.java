package View;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import controller.MainController;
import model.Player;
import model.actions.Action;
import model.actions.GameContex;

import java.util.ArrayList;

public class MyActor extends Image {
    private mainView myMainview = mainView.getInstance();
    public MyActor(TextureRegion texture){
        super(texture);

        setBounds(getX(), getY(), getWidth(), getHeight());
        setPosition(280,100);
        addListener(new InputListener(){
            @Override
            public boolean keyDown(InputEvent event, int keycode){

                float speedMove = 0.5f;
                MoveToAction mba = new MoveToAction();
                GameScreen x =myMainview.getMyGameScreen();
                Player player = x.getPlayer();
                if (player.getEnergy() < 20){
                    speedMove = 0.05f;
                }
                MainController controller = x.getMyController();
                switch (keycode){
                    case Input.Keys.NUM_1: // bathroom
                        mba.setPosition(130f,200f);
                        if(player.getRetainedLiquids() > 50 || player.getEatenFood() > 50 ){
                            mba.setDuration(speedMove/2); // this change the speed
                        }else{
                            mba.setDuration(speedMove); // this change the speed
                        }
                        MyActor.this.addAction(mba);
                        controller.executeAction("GoBathroom");//GoBathroomAction
                        break;
                    case Input.Keys.NUM_2: // kitchen
                        mba.setPosition(290f,210f);
                        mba.setDuration(speedMove); // this change the speed
                        MyActor.this.addAction(mba);
                        controller.executeAction("ToStock");//ToStockAction
                        break;
                    case Input.Keys.NUM_3:// bedroom
                        mba.setPosition(310f,390f);
                        mba.setDuration(speedMove); // this change the speed
                        MyActor.this.addAction(mba);
                        controller.executeAction("Sleep");//SleepAction
                        break;
                    case Input.Keys.NUM_4:// fight Room
                        mba.setPosition(10f,350f);
                        mba.setDuration(speedMove); // this change the speed
                        controller.executeAction("GoFight");//GoFightAction
                        MyActor.this.addAction(mba);
                        break;
                    case Input.Keys.NUM_5: // Meditation
                        mba.setPosition(280f,100f);
                        mba.setDuration(speedMove); // this change the speed
                        controller.executeAction("Meditation");//MeditationAction
                        MyActor.this.addAction(mba);
                        break;
                    case Input.Keys.NUM_6: // Socialize
                        mba.setPosition(350f,100f);
                        mba.setDuration(speedMove); // this change the speed
                        controller.executeAction("Socialize");//SocializeAction
                        MyActor.this.addAction(mba);
                        break;
                    case Input.Keys.NUM_7: // train
                        mba.setPosition(10,100);
                        mba.setDuration(speedMove); // this change the speed
                        controller.executeAction("Workout");//WorkoutAction
                        MyActor.this.addAction(mba);
                        break;
                    case Input.Keys.NUM_8: // Gather
                        mba.setPosition(10f,200f);
                        mba.setDuration(speedMove); // this change the speed
                        controller.executeAction("Gather");//GatherAction
                        MyActor.this.addAction(mba);
                        break;
                    case Input.Keys.NUM_9: // Eat
                        mba.setPosition(130f,350f);
                        mba.setDuration(speedMove); // this change the speed
                        //No puedo llamar a comer porque no tengo comida
                        //controller.executeAction(gc,1);//EatAction
                        MyActor.this.addAction(mba);
                        break;
                }

                return true;
            }
        });
    }
}
