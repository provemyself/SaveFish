package com.savefish.screens;

import java.util.logging.Level;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.savefish.service.LoadedScreen;
import com.savefish.util.GreenLogger;

public class AboutScreen implements Screen {

	private static AboutScreen aboutScreen = null;

	public static AboutScreen getInstance(Game game) {
		if (null == aboutScreen) {
			aboutScreen = new AboutScreen(game);
			LoadedScreen.screens.add(aboutScreen);
		}
		return aboutScreen;
	}

	@SuppressWarnings("unused")
	private Game game;

	private AboutScreen(Game game) {
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
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		this.stage.act(delta);
		this.stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		stage.setViewport(width, height, true);
	}

	@Override
	public void show() {
		this.initStage();
	}

	@Override
	public void hide() {

	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose() {
		GreenLogger.getInstance().logp(Level.INFO, AboutScreen.class.getName(),
				"dispose", "called!");

		if (this.stage != null)
			this.stage.dispose();
		game = null;
	}

	@Override
	public String toString() {
		return AboutScreen.class.getName();
	}

}
