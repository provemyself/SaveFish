package com.savefish.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

public class MainMenuScreen implements Screen {

	private static MainMenuScreen mms = null;

	public static MainMenuScreen getInstance(Game game) {
		if (null == mms)
			mms = new MainMenuScreen(game);
		return mms;
	}

	@SuppressWarnings("unused")
	private Game game;

	private MainMenuScreen(Game game) {
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

	}

}
