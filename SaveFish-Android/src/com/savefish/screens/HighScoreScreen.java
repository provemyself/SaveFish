package com.savefish.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

public class HighScoreScreen implements Screen {

	private static HighScoreScreen hss = null;

	public static HighScoreScreen getInstance(Game game) {
		if (null == hss)
			hss = new HighScoreScreen(game);
		return hss;
	}

	@SuppressWarnings("unused")
	private Game game;

	private HighScoreScreen(Game game) {
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

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return HighScoreScreen.class.getName();
	}

}
