package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class mainClass extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	int weith, heght;
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("map.jpeg");
		weith = Gdx.graphics.getWidth();
		heght = Gdx.graphics.getHeight();
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		batch.draw(img, 0, 0, weith, heght);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
