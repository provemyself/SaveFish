package com.savefish.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

public class WinScreen implements Screen {

	private static WinScreen ws = null;

	public static WinScreen getInstance(Game game) {
		if (null == ws)
			ws = new WinScreen(game);
		return ws;
	}

	@SuppressWarnings("unused")
	private Game game;

	private WinScreen(Game game) {
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
		return WinScreen.class.getName();
	}

}
