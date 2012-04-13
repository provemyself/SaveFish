package com.savefish.screens;

import java.util.logging.Level;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.savefish.assets.Assets;
import com.savefish.constant.Constant;
import com.savefish.util.GreenLogger;

public class LoadingScreen implements Screen {

	private Stage stage;
	private Image bgLoadImage;
	private Game game;

	public LoadingScreen(Game game) {

		bgLoadImage = new Image(Constant.asset.bghelpTexture);// 换成加载背景
		stage = new Stage(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(),
				true);
		stage.addActor(bgLoadImage);
		this.game = game;
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
			GreenLogger.getInstance().logp(Level.SEVERE,
					LoadingScreen.class.getName(), "render",
					Assets.getInstance().getProgress() + "Loading complete!");

			Assets.getInstance().setComplete(true);

			// 加载完成跳转到主界面
			game.setScreen(new MenuScreen(game));
		} else {
			GreenLogger.getInstance().logp(Level.SEVERE,
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

	}

	@Override
	public void hide() {
		GreenLogger.getInstance().logp(Level.WARNING,
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
	}

	@Override
	public String toString() {
		return LoadingScreen.class.getName();
	}

}
