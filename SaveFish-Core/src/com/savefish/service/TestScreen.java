package com.savefish.service;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.savefish.assets.Assets;
import com.savefish.constant.Constant;
import com.savefish.rule.GameLevel;
import com.savefish.screens.game.GameScreen;

public class TestScreen implements Screen {

	private Game game = null;
	private Stage stage = null;

	public TestScreen(Game game) {
		this.game = game;
		this.stage = new Stage(Gdx.graphics.getWidth(),
				Gdx.graphics.getHeight(), true);
		this.initBackgroundImage();
		this.initMusicImage();
		Gdx.input.setInputProcessor(stage);
	}

	private Image musicImage = null;

	private void initMusicImage() {
		this.musicImage = new MusicImage(Assets.getInstance().getTextureRegion(
				Constant.asset.PAUSE));
	}

	private Image backgroundImage = null;

	private void initBackgroundImage() {
		this.backgroundImage = new Image(Assets.getInstance().getSpriteRigion(
				Constant.asset.BACKGROUND_ONE));
	}

	@Override
	public void render(float delta) {
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {
		this.stage.addActor(backgroundImage);
		this.stage.addActor(musicImage);
		this.stage.act(Gdx.graphics.getDeltaTime());
		this.stage.draw();
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

	class MusicImage extends Image {

		public MusicImage(TextureRegion region) {
			super(region);
		}

		@Override
		public boolean touchDown(float x, float y, int pointer) {

			game.setScreen(GameScreen.getInstance().switchToGameLevel(
					GameLevel.createInstance(1, 5)));
			return super.touchDown(x, y, pointer);
		}

	}

}
