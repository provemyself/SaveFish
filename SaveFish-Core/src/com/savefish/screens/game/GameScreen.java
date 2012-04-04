package com.savefish.screens.game;

import java.util.logging.Level;

import org.lwjgl.util.Timer;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.savefish.screens.HighScoreScreen;
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
		this.game = game;
	}

	@Override
	public void render(float delta) {
		GreenLogger.getInstance().log(Level.INFO, "render world!");
		
		Timer.tick();

		GL10 gl = Gdx.graphics.getGL10();
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		this.backGroundStage.render(delta);
		this.middleStage.render(delta, gl);
		this.foreGroundStage.render(delta);

		Gdx.input.setInputProcessor(new InputMultiplexer(backGroundStage,
				middleStage, foreGroundStage));

		GreenLogger.getInstance().warning(timer.getTime() + "");
		if ((int) timer.getTime() % 5 == 0) {
			timer.pause();
			game.setScreen(HighScoreScreen.getInstance(game));
		}
	}

	@Override
	public void resize(int width, int height) {
		GreenLogger.getInstance().logp(Level.WARNING,
				GameScreen.class.getName(), "resize", "called!");

	}

	@Override
	public void show() {
		this.initGame(game);
		this.initStages();
		this.initTimer();
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
		backGroundStage.dispose();
		this.middleStage.dispose();
		this.foreGroundStage.dispose();
	}

	@Override
	public String toString() {
		return GameScreen.class.getName();
	}

	private Game game;

	private void initGame(Game game) {
		this.game = game;
	}

	private BackgroundStage backGroundStage;
	private MiddleStage middleStage;
	private ForegroundStage foreGroundStage;

	private void initStages() {
		this.backGroundStage = BackgroundStage.getInstance();
		this.middleStage = MiddleStage.createMiddleStage(1);
		this.foreGroundStage = ForegroundStage.getInstance();
	}

	private Timer timer;

	private void initTimer() {
		this.timer = new Timer();
	}

}
