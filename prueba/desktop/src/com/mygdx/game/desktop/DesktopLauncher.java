package com.mygdx.game.desktop;

import Utils.DiseaseReader;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.mainClass;
import View.mainView;
import model.Disease;


public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		mainView myMainView = mainView.getInstance();
		new LwjglApplication(myMainView, config);
	}
}
