package com.savefish.screens.game;

import java.util.logging.Level;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.savefish.util.logger.GreenLogger;

public class GameScreen implements Screen {

	private static GameScreen gs = null;

	public static GameScreen getInstance(Game game) {
		if (null == gs) {
			try {
				gs = new GameScreen(game);
			} catch (Exception e) {
				GreenLogger.getInstance().logp(Level.WARNING,
						GameScreen.class.getName(), "getInstance",
						e.toString(), e);
			}
		}
		return gs;
	}

	private GameScreen(Game game) throws Exception {
		GreenLogger.getInstance().logp(Level.WARNING,
				GameScreen.class.getName(), "GameScreen", "called!");

		this.initGame(game);
		this.initStages();
	}

	@SuppressWarnings("unused")
	private ParticleStage particle;
	private GameStage gameStage;

	@Override
	public void render(float delta) {
		GreenLogger.getInstance().log(Level.INFO, "render world!");
		this.gameStage.render(delta);
	}

	@Override
	public void resize(int width, int height) {
		this.gameStage.setViewport(width, height, true);
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
		this.gameStage.dispose();
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

	private void initStages() {
		GreenLogger.getInstance().logp(Level.INFO, GameScreen.class.getName(),
				"initStages", "called!");

		this.particle = new ParticleStage();
		try {
			this.gameStage = new GameStage(Gdx.graphics.getWidth(),
					Gdx.graphics.getHeight(), true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
