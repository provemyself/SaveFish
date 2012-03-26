package com.savefish.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

public class FailScreen implements Screen {

	private static FailScreen fs = null;

	public static FailScreen getInstance(Game game) {
		if (null == fs)
			fs = new FailScreen(game);
		return fs;
	}

	@SuppressWarnings("unused")
	private Game game;

	private FailScreen(Game game) {
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
		return FailScreen.class.getName();
	}

}
