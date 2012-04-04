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
import com.savefish.service.MusicManager;
import com.savefish.service.SoundManager;
import com.savefish.util.logger.GreenLogger;

public class HighScoreScreen implements Screen {

	private static HighScoreScreen highScoreScreen = null;

	public static HighScoreScreen getInstance(Game game) {
		if (null == highScoreScreen) {
			highScoreScreen = new HighScoreScreen(game);
			LoadedScreen.screens.add(highScoreScreen);
		}
		return highScoreScreen;
	}

	private Game game;

	public HighScoreScreen(Game game) {
		super();
		this.game = game;
		this.initImage();
	}

	private Image nextImage = null;
	private Image menuImage = null;

	private void initImage() {
		this.nextImage = new Image(Assets.getInstance().getTextureRegion(
				Constant.asset.NEXT));
		this.nextImage.x = 300;
		this.nextImage.y = 10;
		this.nextImage.setClickListener(new NextImageListener());

		this.menuImage = new Image(Assets.getInstance().getTextureRegion(
				Constant.asset.MENU));
		this.menuImage.x = 50;
		this.menuImage.y = 10;
		this.menuImage.setClickListener(new MenuImageListener());
	}

	class NextImageListener implements ClickListener {

		@Override
		public void click(Actor actor, float x, float y) {
			SoundManager.getInstance().play();
			MusicManager.getInstance().play();
			
			
		}

	}

	class MenuImageListener implements ClickListener {

		@Override
		public void click(Actor actor, float x, float y) {
			game.setScreen(GameScreen.getInstance(game));
		}

	}

	private Stage stage = null;

	private void initStage() {
		this.stage = new Stage(Gdx.graphics.getWidth(),
				Gdx.graphics.getHeight(), true);
		this.stage.addActor(menuImage);
		this.stage.addActor(nextImage);
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
