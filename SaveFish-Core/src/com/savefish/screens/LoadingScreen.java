package com.savefish.screens;

import java.util.logging.Level;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.savefish.assets.Assets;
import com.savefish.service.LoadedScreen;
import com.savefish.util.logger.GreenLogger;

public class LoadingScreen implements Screen {
	private static LoadingScreen loadingScreen = null;

	public static LoadingScreen getInstance(Game game) {
		GreenLogger.getInstance().logp(Level.INFO,
				LoadingScreen.class.getName(), "getInstance", "called!");

		if (null == loadingScreen) {
			loadingScreen = new LoadingScreen(game);
			LoadedScreen.screens.add(loadingScreen);
		}
		return loadingScreen;
	}

	private Game game = null;

	private LoadingScreen(Game game) {
		this.game = game;
		this.loadingTexture = new Texture(
				Gdx.files.internal("textures/loading.png"));
		this.loadingImage = new Image(loadingTexture);

	}

	private Stage stage = null;
	private Texture loadingTexture = null;
	private Image loadingImage = null;

	private void initStage() {
		this.stage = new Stage(Gdx.graphics.getWidth(),
				Gdx.graphics.getHeight(), true);
		this.stage.addActor(loadingImage);
	}

	@Override
	public void render(float delta) {
		Gdx.gl10.glClear(GL10.GL_COLOR_BUFFER_BIT);
		stage.act(delta);
		stage.draw();

		GreenLogger.getInstance().logp(Level.INFO,
				LoadingScreen.class.getName(), "render", "render called!",
				delta);

		if (Assets.getInstance().update()) {
			GreenLogger.getInstance().logp(Level.INFO,
					LoadingScreen.class.getName(), "render",
					"Loading complete!");

			Assets.getInstance().setComplete(true);
			this.game.setScreen(HighScoreScreen.getInstance(game));
		} else {
			GreenLogger.getInstance().logp(Level.INFO,
					LoadingScreen.class.getName(), "render",
					Assets.getInstance().getProgress() + " loaded!");
		}

	}

	@Override
	public void resize(int width, int height) {
		GreenLogger.getInstance().logp(Level.INFO,
				LoadingScreen.class.getName(), "resize",
				"width: " + width + ", height: " + height);
	}

	@Override
	public void show() {
		GreenLogger.getInstance().logp(Level.INFO,
				LoadingScreen.class.getName(), "show", "called!");

		this.initStage();
	}

	@Override
	public void hide() {
		GreenLogger.getInstance().logp(Level.INFO,
				LoadingScreen.class.getName(), "hide", "called!");
	}

	@Override
	public void pause() {
		GreenLogger.getInstance().logp(Level.INFO,
				LoadingScreen.class.getName(), "pause", "called!");
	}

	@Override
	public void resume() {
		GreenLogger.getInstance().logp(Level.INFO,
				LoadingScreen.class.getName(), "resume", "called!");
	}

	@Override
	public void dispose() {
		GreenLogger.getInstance().logp(Level.INFO,
				LoadingScreen.class.getName(), "dispose", "called!");
		if (this.stage != null)
			this.stage.dispose();
		game = null;
	}

	@Override
	public String toString() {
		return LoadingScreen.class.getName();
	}

}
