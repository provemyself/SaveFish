package com.savefish.screens.game;

import java.util.logging.Level;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.savefish.pointsystem.CurrentLevel;
import com.savefish.pointsystem.GameLevel;
import com.savefish.pointsystem.GameScoreRecord;
import com.savefish.pointsystem.ScoreRecord;
import com.savefish.service.MusicManager;
import com.savefish.util.GreenLogger;

public class GameScreen implements Screen {

	private static GameScreen gameScreen = null;

	public static GameScreen getInstance(Game game, GameLevel defaultLevel) {
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

	private GameLevel defaultLevel = null;

	private GameScreen(Game game, GameLevel defaultLevel) throws Exception {
		GreenLogger.getInstance().logp(Level.WARNING,
				GameScreen.class.getName(), "GameScreen", "called!");
		this.game = game;
		this.defaultLevel = defaultLevel.clone();
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
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {
		MusicManager.enableMusic();
		this.initStages();
		this.switchToGameLevel(defaultLevel);
	}

	@Override
	public void hide() {
		MusicManager.disableMusic();
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
		gameScreen = null;
		game = null;
	}

	/**
	 * @description This is a special dispose, as it is just designed for
	 *              MiddleStage
	 */
	public void disposeMiddleStage() {
		if (null != middleStage)
			middleStage.dispose();
	}

	@Override
	public String toString() {
		return GameScreen.class.getName();
	}

	private Game game;

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
		System.out.println("当前关卡： " + "(" + level.getBig() + ", "
				+ level.getSmall() + ")");
		if (null != middleStage)
			middleStage.dispose();
		try {
			middleStage = GameMiddleStage.createInstance(level.clone(), game);
			CurrentLevel.level = level.clone();
			this.defaultLevel = level.clone();
			GameScoreRecord.currentLevelScore = new ScoreRecord(level.clone());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return gameScreen;
	}
}
