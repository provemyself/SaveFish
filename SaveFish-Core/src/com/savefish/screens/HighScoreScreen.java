package com.savefish.screens;

import java.util.logging.Level;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.savefish.service.LoadedScreen;
import com.savefish.util.GreenLogger;

public class HighScoreScreen implements Screen {

	private static HighScoreScreen highScoreScreen = null;

	public static HighScoreScreen getInstance(Game game) {
		if (null == highScoreScreen) {
			highScoreScreen = new HighScoreScreen(game);
			LoadedScreen.screens.add(highScoreScreen);
		}
		return highScoreScreen;
	}

	@SuppressWarnings("unused")
	private Game game;

	public HighScoreScreen(Game game) {
		this.game = game;
	}

	private Stage stage = null;

	private void initStage() {
		this.stage = new Stage(Gdx.graphics.getWidth(),
				Gdx.graphics.getHeight(), true);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		this.stage.act(delta);
		this.stage.draw();
		Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void resize(int width, int height) {

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
		GreenLogger.getInstance().logp(Level.INFO,
				HighScoreScreen.class.getName(), "dispose", "called!");

		if (this.stage != null)
			this.stage.dispose();
		game = null;
	}

	@Override
	public String toString() {
		return HighScoreScreen.class.getName();
	}

}
