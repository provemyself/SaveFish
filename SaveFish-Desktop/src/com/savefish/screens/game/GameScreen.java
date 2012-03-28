package com.savefish.screens.game;

import java.util.logging.Level;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.savefish.util.logger.GreenLogger;

public class GameScreen implements Screen {

	private static GameScreen gameScreen = null;

	public static GameScreen getInstance(Game game) {
		if (null == gameScreen) {
			try {
				gameScreen = new GameScreen(game);
			} catch (Exception e) {
				GreenLogger.getInstance().logp(Level.WARNING,
						GameScreen.class.getName(), "getInstance",
						e.toString(), e);
			}
		}
		return gameScreen;
	}

	private GameScreen(Game game) throws Exception {
		GreenLogger.getInstance().logp(Level.WARNING,
				GameScreen.class.getName(), "GameScreen", "called!");

		this.initGame(game);
		this.initStages();
	}

	@Override
	public void render(float delta) {
		GreenLogger.getInstance().log(Level.INFO, "render world!");

		GL10 gl = Gdx.graphics.getGL10();
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		this.backGroundStage.render(delta);
		this.middleStage.render(delta, gl);
		this.foreGroundStage.render();

		Gdx.input.setInputProcessor(new InputMultiplexer(backGroundStage,
				middleStage, foreGroundStage));
	}

	@Override
	public void resize(int width, int height) {

		GreenLogger.getInstance().logp(Level.WARNING,
				GameScreen.class.getName(), "resize", "called!");

		this.backGroundStage.setViewport(width, height, true);
		this.middleStage.setViewport(width, height, true);
		this.foreGroundStage.setViewport(width, height, true);
	}

	@Override
	public void show() {
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
		this.middleStage.dispose();
	}

	@Override
	public String toString() {
		return GameScreen.class.getName();
	}

	@SuppressWarnings("unused")
	private Game game;

	private void initGame(Game game) {
		GreenLogger.getInstance().logp(Level.INFO, GameScreen.class.getName(),
				"initGame", "called!");

		this.game = game;
	}

	private BackgroundStage backGroundStage;
	private MiddleStage middleStage;
	private ForegroundStage foreGroundStage;

	private void initStages() {
		GreenLogger.getInstance().logp(Level.INFO, GameScreen.class.getName(),
				"initStages", "called!");

		this.backGroundStage = BackgroundStage.getInstance();
		this.middleStage = MiddleStage.getInstance();
		this.foreGroundStage = ForegroundStage.getInstance();
	}

}
