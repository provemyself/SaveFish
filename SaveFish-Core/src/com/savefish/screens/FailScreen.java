package com.savefish.screens;

import java.util.logging.Level;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.savefish.service.LoadedScreen;
import com.savefish.util.GreenLogger;

public class FailScreen implements Screen {

	private static FailScreen failScreen = null;

	public static FailScreen getInstance(Game game) {
		if (null == failScreen) {
			failScreen = new FailScreen(game);
			LoadedScreen.screens.add(failScreen);
		}
		return failScreen;
	}

	@SuppressWarnings("unused")
	private Game game;

	private FailScreen(Game game) {
		super();
		this.game = game;
	}

	private Stage stage = null;

	private void initStage() {
		stage = new Stage(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(),
				true);
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		this.stage.act(delta);
		this.stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		this.stage.setViewport(width, height, true);
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		this.initStage();
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
		GreenLogger.getInstance().logp(Level.INFO, FailScreen.class.getName(),
				"dispose", "called!");

		if (this.stage != null)
			this.stage.dispose();
		game = null;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return FailScreen.class.getName();
	}

}
