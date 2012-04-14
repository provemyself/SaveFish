package com.savefish.screens;

import java.util.logging.Level;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ClickListener;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.savefish.assets.Assets;
import com.savefish.constant.Constant;
import com.savefish.screens.game.GameScreen;
import com.savefish.service.LoadedScreen;
import com.savefish.util.GreenLogger;

public class MainMenuScreen implements Screen {

	private static MainMenuScreen mainMenuScreen = null;

	public static MainMenuScreen getInstance(Game game) {
		if (null == mainMenuScreen) {
			mainMenuScreen = new MainMenuScreen(game);
			LoadedScreen.screens.add(mainMenuScreen);
		}
		return mainMenuScreen;
	}

	private Game game = null;
	private Stage stage = null;
	private Image startImage = null;
	private Image quitImage = null;

	private MainMenuScreen(Game game) {
		this.game = game;

	}

	@Override
	public void render(float delta) {
		GreenLogger.getInstance().logp(Level.INFO,
				MainMenuScreen.class.getName(), "render", delta + "s called!",
				delta);

		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		stage.act(delta);
		stage.draw();
		Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void resize(int width, int height) {
		this.stage.setViewport(width, height, true);

		GreenLogger.getInstance().logp(Level.INFO,
				MainMenuScreen.class.getName(), "resize",
				"width: " + width + ", height: " + height);
	}

	@Override
	public void show() {
		GreenLogger.getInstance().logp(Level.INFO,
				MainMenuScreen.class.getName(), "show", "called!");

		this.initialize();
	}

	@Override
	public void hide() {
		GreenLogger.getInstance().logp(Level.INFO,
				MainMenuScreen.class.getName(), "hide", "called!");
	}

	@Override
	public void pause() {
		GreenLogger.getInstance().logp(Level.INFO,
				MainMenuScreen.class.getName(), "pause", "called!");
	}

	@Override
	public void resume() {
		GreenLogger.getInstance().logp(Level.INFO,
				MainMenuScreen.class.getName(), "resume", "called!");
	}

	@Override
	public void dispose() {
		GreenLogger.getInstance().logp(Level.INFO,
				MainMenuScreen.class.getName(), "dispose", "called!");
		if (this.stage != null)
			this.stage.dispose();
		game = null;

	}

	@Override
	public String toString() {
		return MainMenuScreen.class.getName();
	}

	private void initialize() {
		this.initImage();
		this.initStage();
	}

	private void initImage() {
		this.startImage = new Image(Assets.getInstance().getTextureRegion(
				Constant.asset.PREVIOUS));
		this.startImage.x = 10;
		this.startImage.y = 10;
		this.startImage.setClickListener(new StartImageListener());

		this.quitImage = new Image(Assets.getInstance().getTextureRegion(
				Constant.asset.STOP));
		this.quitImage.x = 10;
		this.quitImage.y = 400;
		this.quitImage.setClickListener(new QuitImageListener());
	}

	class StartImageListener implements ClickListener {

		@Override
		public void click(Actor actor, float x, float y) {
			game.setScreen(GameScreen.getInstance(game, 1));
		}
	}

	class QuitImageListener implements ClickListener {

		@Override
		public void click(Actor actor, float x, float y) {

			GreenLogger.getInstance().logp(Level.INFO,
					MainMenuScreen.class.getName(), "click", "click");

			game.dispose();
		}
	}

	private void initStage() {
		this.stage = new Stage(Gdx.graphics.getWidth(),
				Gdx.graphics.getHeight(), true);
		this.stage.addActor(quitImage);
		this.stage.addActor(startImage);
	}
}
