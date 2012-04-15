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
import com.savefish.screens.button.Fish;
import com.savefish.util.GreenLogger;

/********************************
 * Description: 该类为加载界面， 游戏开始时加载资源的等待界面 Author : 杨勇 Date : 2012/03/08
 *******************************/
public class LoadingScreen implements Screen {

	private Stage stage;
	private Image bgLoadImage;
	private Fish fish1;
	private Fish fish2;
	private Fish fish3;
	private Fish fish4;
	private Game game;

	public LoadingScreen(Game game) {

		init(game);
		stage.addActor(bgLoadImage);
		stage.addActor(fish1);
		stage.addActor(fish2);
		stage.addActor(fish3);
		stage.addActor(fish4);
		this.game = game;
	}

	private void init(Game game) {
		bgLoadImage = new Image(Constant.asset.bgMainTexture);
		stage = new Stage(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(),
				true);
		fish1 = new Fish(Constant.asset.fish1Texture);
		fish2 = new Fish(Constant.asset.fish2Texture);
		fish3 = new Fish(Constant.asset.fish3Texture);
		fish4 = new Fish(Constant.asset.fish2Texture);
		fish1.setPosition(0, 100, false);
		fish2.setPosition(480, 200, true);
		fish3.setPosition(0, 300, false);
		fish4.setPosition(480, 400, true);
		bgLoadImage.height = Gdx.graphics.getHeight();
		bgLoadImage.width = Gdx.graphics.getWidth();
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
					Assets.getInstance().getProgress() + "Loading complete!");

			Assets.getInstance().setComplete(true);

			game.setScreen(new MenuScreen(game));
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
	}

	@Override
	public String toString() {
		return LoadingScreen.class.getName();
	}

}
