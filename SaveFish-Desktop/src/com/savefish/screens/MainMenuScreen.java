package com.savefish.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ClickListener;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.savefish.assets.Assets;
import com.savefish.constant.Constant;

public class MainMenuScreen implements Screen {

	private static MainMenuScreen mainMenuScreen = null;

	public static MainMenuScreen getInstance(Game game) {
		if (null == mainMenuScreen)
			mainMenuScreen = new MainMenuScreen(game);
		return mainMenuScreen;
	}

	@SuppressWarnings("unused")
	private Game game = null;

	private Stage stage = null;
	private Texture startTexture = null;
	private Texture quitTexture = null;
	private Image startImage = null;
	private Image quitImage = null;
	private Music bgMusic = null;
	private Sound sound = null;

	private MainMenuScreen(Game game) {
		this.game = game;
		this.initialize();
	}

	@Override
	public void render(float delta) {
		// System.out.println("render called!");
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();
		Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void resize(int width, int height) {
		// System.out.println("resize called!");
		this.stage.setViewport(width, height, true);
	}

	@Override
	public void show() {
		// System.out.println("show called!");
	}

	@Override
	public void hide() {
		// System.out.println("hide called!");
	}

	@Override
	public void pause() {
		// System.out.println("pause called!");
	}

	@Override
	public void resume() {
		// System.out.println("resume called!");
	}

	@Override
	public void dispose() {
		// System.out.println("dispose called!");
		this.stage.dispose();
	}

	private void initialize() {
		this.initTexture();
		this.initImage();
		this.initStage();
		this.initBgMusic();
		this.initSound();
	}

	private void initTexture() {
		this.startTexture = Assets.getInstance().getTexture(Constant.asset.START);
		this.quitTexture = Assets.getInstance().getTexture(Constant.asset.QUIT);
	}

	private void initImage() {
		this.startImage = new Image(startTexture);
		this.startImage.x = 10;
		this.startImage.y = 10;
		this.startImage.setClickListener(new StartImageListener());

		this.quitImage = new Image(quitTexture);
		this.quitImage.x = 200;
		this.quitImage.y = 200;
		this.quitImage.setClickListener(new QuitImageListener());
	}

	class StartImageListener implements ClickListener {

		@Override
		public void click(Actor actor, float x, float y) {
			sound.play();
			bgMusic.play();
			bgMusic.setVolume(1f);
			bgMusic.setLooping(true);
		}
	}

	class QuitImageListener implements ClickListener {

		@Override
		public void click(Actor actor, float x, float y) {
			sound.play();
			bgMusic.stop();
		}

	}

	private void initStage() {
		this.stage = new Stage(Gdx.graphics.getWidth(),
				Gdx.graphics.getHeight(), true);
		this.stage.addActor(quitImage);
		this.stage.addActor(startImage);
	}

	private void initBgMusic() {
		this.bgMusic = Assets.getInstance().getMusic(Constant.asset.MUSIC);
	}

	private void initSound() {
		this.sound = Assets.getInstance().getSound(Constant.asset.SOUND);
	}
}
