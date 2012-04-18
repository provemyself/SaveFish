package com.savefish.screens.game;

import java.util.logging.Level;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.savefish.rule.CurrentLevel;
import com.savefish.rule.GameLevel;
import com.savefish.service.BackgroundMusic;
import com.savefish.service.MusicManager;
import com.savefish.util.GreenLogger;
import com.savefish.util.TimingManager;

public class GameScreen implements Screen {

	private static GameScreen gameScreen = null;

	public static GameScreen getInstance(Game game, GameLevel defaultLevel) {
		MusicManager.disableMusic();
		BackgroundMusic.getInstance().play();
		if (null == gameScreen) {
			try {
				gameScreen = new GameScreen(game, defaultLevel);
			} catch (Exception e) {
				GreenLogger.getInstance().logp(Level.WARNING,
						GameScreen.class.getName(), "getInstance",
						e.toString(), e);
			}
		}
		return gameScreen;
	}

	public static GameScreen getInstance() {
		if (null != gameScreen)
			return gameScreen;
		else
			return null;
	}

	private GameScreen(Game game, GameLevel defaultLevel) throws Exception {
		GreenLogger.getInstance().logp(Level.WARNING,
				GameScreen.class.getName(), "GameScreen", "called!");
		this.game = game;
		this.switchToGameLevel(defaultLevel);
	}

	@Override
	public void render(float delta) {
		GreenLogger.getInstance().log(Level.INFO, "render world!");

		Gdx.graphics.getGL10().glClear(GL10.GL_COLOR_BUFFER_BIT);
		this.backGroundStage.render(delta);
		this.middleStage.render(delta);
		this.gameControlStage.render(delta);
		this.foreGroundStage.render(delta);

		Gdx.input.setInputProcessor(new InputMultiplexer(backGroundStage,
				middleStage, foreGroundStage, gameControlStage));

		TimingManager.getInstance(game).start();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {
		this.initGame(game);
		this.initStages();
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
		middleStage.dispose();
		gameControlStage.dispose();
		foreGroundStage.dispose();
	}

	@Override
	public String toString() {
		return GameScreen.class.getName();
	}

	private Game game;

	private void initGame(Game game) {
		this.game = game;
	}

	private GameBackgroundStage backGroundStage;
	private GameMiddleStage middleStage;
	private GameControlStage gameControlStage;
	private GameForegroundStage foreGroundStage;

	private void initStages() {
		this.backGroundStage = GameBackgroundStage.getInstance();
		this.gameControlStage = GameControlStage.getInstance(game);
		this.foreGroundStage = GameForegroundStage.getInstance();
	}

	public GameScreen switchToGameLevel(GameLevel level) {
		if (null != middleStage)
			middleStage.dispose();
		CurrentLevel.level = level;
		middleStage = GameMiddleStage.createInstance(level);
		return gameScreen;
	}
}
