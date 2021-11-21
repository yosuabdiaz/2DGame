package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;
import org.w3c.dom.Text;

public class mainClass extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img, moveTexture, moveTexture2, attackTexture;
	int weith, heght;
	private TextureRegion[] animationArray, animatioArray2;
	private Animation animationTopRigth, animationTopLeft, animationDownRigth, animationDownLeft;
	private	float elapsedTime;

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("map.jpeg");

		moveTexture = new Texture("moving1.png");
		moveTexture2 = new Texture("moving2.png");
		attackTexture = new Texture("attack2.png");

		drawTopRight(moveTexture,6);
		drawTopLeft(attackTexture,6);
		drawTDownRight(moveTexture2,9);
		drawDownLeft(moveTexture,6);

		weith = Gdx.graphics.getWidth();
		heght = Gdx.graphics.getHeight();
	}
	public void drawTopRight(Texture tmpTexture, int numberOfSplits){
		TextureRegion[][] moveTextureRegion = TextureRegion.split(tmpTexture,tmpTexture.getWidth()/numberOfSplits,tmpTexture.getHeight());
		animationArray = new TextureRegion[numberOfSplits];
		int index = 0;
		for(int i= 0; i< numberOfSplits; i++){
			animationArray[index++] = moveTextureRegion[0][i];
		}
		animationTopRigth = new Animation(1f/4f,animationArray);
	}

	public void drawTopLeft(Texture tmpTexture, int numberOfSplits){
		TextureRegion[][] moveTextureRegion = TextureRegion.split(tmpTexture,tmpTexture.getWidth()/numberOfSplits,tmpTexture.getHeight());
		animatioArray2 = new TextureRegion[numberOfSplits];
		int index = 0;
		for(int i= 0; i< numberOfSplits; i++){
			animatioArray2[index++] = moveTextureRegion[0][i];
		}
		animationTopLeft = new Animation(1f/4f,animatioArray2);
	}
	public void drawTDownRight(Texture tmpTexture, int numberOfSplits){
		TextureRegion[][] moveTextureRegion = TextureRegion.split(tmpTexture,tmpTexture.getWidth()/numberOfSplits,tmpTexture.getHeight());
		animationArray = new TextureRegion[numberOfSplits];
		int index = 0;
		for(int i= 0; i< numberOfSplits; i++){
			animationArray[index++] = moveTextureRegion[0][i];
		}
		animationDownRigth = new Animation(1f/4f,animationArray);
	}

	public void drawDownLeft(Texture tmpTexture, int numberOfSplits){
		TextureRegion[][] moveTextureRegion = TextureRegion.split(tmpTexture,tmpTexture.getWidth()/numberOfSplits,tmpTexture.getHeight());
		animatioArray2 = new TextureRegion[numberOfSplits];
		int index = 0;
		for(int i= 0; i< numberOfSplits; i++){
			animatioArray2[index++] = moveTextureRegion[0][i];
		}
		animationDownLeft = new Animation(1f/8f,animatioArray2);
	}


	@Override
	public void render () {
		elapsedTime += Gdx.graphics.getDeltaTime();
		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		batch.draw(img, 0, 0, weith, heght);

		batch.draw((TextureRegion) animationTopRigth.getKeyFrame(elapsedTime,true),515,51);
		batch.draw((TextureRegion) animationTopLeft.getKeyFrame(elapsedTime,true),575,58);
		batch.draw((TextureRegion) animationDownRigth.getKeyFrame(elapsedTime,true),575,5);
		batch.draw((TextureRegion) animationDownLeft.getKeyFrame(elapsedTime,true),515,0);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
