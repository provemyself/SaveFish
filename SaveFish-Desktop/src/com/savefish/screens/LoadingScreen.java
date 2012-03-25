package com.savefish.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.savefish.assets.Assets;

public class LoadingScreen implements Screen {
	private static LoadingScreen loadingScreen = null;

	public static LoadingScreen getInstance(Game game) {
//		System.out.println("LoadingScreen called!");
		if (null == loadingScreen)
			loadingScreen = new LoadingScreen(game);
		return loadingScreen;
	}

	private Game game = null;

	private LoadingScreen(Game game) {
		this.game = game;
		this.loadingTexture = new Texture(Gdx.files.internal("textures/loading.png"));
		this.loadingImage = new Image(loadingTexture);
	}

	private Stage stage = null;
	private Texture loadingTexture = null;
	private Image loadingImage = null;

	@Override
	public void render(float delta) {
//		System.out.println("render called");
		if (Assets.getInstance().update()) {
			Assets.getInstance().setComplete(true);
//			System.out.println("Loading Complete!");
			this.game.setScreen(MainMenuScreen.getInstance(game));
		} else {
//			System.out.println(Assets.getInstance().getProgress() + " left!");
		}
		Gdx.gl10.glClear(GL10.GL_COLOR_BUFFER_BIT);
		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void show() {
//		System.out.println("Loading Screen called!");
		this.stage = new Stage(Gdx.graphics.getWidth(),
				Gdx.graphics.getHeight(), true);
		this.stage.addActor(loadingImage);
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

	}

}
