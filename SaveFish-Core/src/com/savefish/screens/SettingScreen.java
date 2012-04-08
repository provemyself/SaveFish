package com.savefish.screens;

import java.util.logging.Level;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.savefish.service.LoadedScreen;
import com.savefish.util.GreenLogger;

public class SettingScreen implements Screen {

	private static SettingScreen settingScreen = null;

	public static SettingScreen getInstance(Game game) {
		if (null == settingScreen) {
			settingScreen = new SettingScreen(game);
			LoadedScreen.screens.add(settingScreen);
		}
		return settingScreen;
	}

	@SuppressWarnings("unused")
	private Game game;

	private SettingScreen(Game game) {
		super();
		this.game = game;
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub

	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
		GreenLogger.getInstance().warning("SettingScreen is shown!");

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		GreenLogger.getInstance().logp(Level.INFO,
				SettingScreen.class.getName(), "dispose", "called!");
		game = null;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return SettingScreen.class.getName();
	}
}
