package com.savefish.logical;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.savefish.assets.Assets;
import com.savefish.constant.Constant;
import com.savefish.rule.CurrentLevel;
import com.savefish.rule.GameLevel;
import com.savefish.screens.game.GameScreen;
import com.savefish.service.LoadedScreen;

public class TestScreen implements Screen {

	private static TestScreen testScreen = null;

	public static TestScreen getInstance(Game game) {
		if (null == testScreen) {
			testScreen = new TestScreen(game);
			LoadedScreen.screens.add(testScreen);
		}
		return testScreen;
	}

	private Game game = null;
	private Stage stage = null;
	private Image replayImage = null;
	private Image nextImage = null;

	private TestScreen(Game game) {
		this.game = game;

	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		stage.act(delta);
		stage.draw();
		Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {
		this.initialize();
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
		if (this.stage != null)
			this.stage.dispose();
		game = null;

	}

	private void initialize() {
		this.initImage();
		this.initStage();
	}

	private void initImage() {
		this.replayImage = new ReplayImage(Assets.getInstance()
				.getTextureRegion(Constant.asset.PREVIOUS));
		this.replayImage.x = 10;
		this.replayImage.y = 10;

		this.nextImage = new NextImage(Assets.getInstance().getTextureRegion(
				Constant.asset.NEXT));
		this.nextImage.x = 10;
		this.nextImage.y = 400;
	}

	class ReplayImage extends Image {

		public ReplayImage(TextureRegion region) {
			super(region);
		}

		@Override
		public boolean touchDown(float x, float y, int pointer) {
			game.setScreen(GameScreen.getInstance().switchToGameLevel(
					CurrentLevel.level));
			return super.touchDown(x, y, pointer);
		}
	}

	class NextImage extends Image {

		public NextImage(TextureRegion region) {
			super(region);
		}

		@Override
		public boolean touchDown(float x, float y, int pointer) {
			int small = CurrentLevel.level.getSmall();
			game.setScreen(GameScreen.getInstance().switchToGameLevel(
					GameLevel.createInstance(1, small + 1)));
			return super.touchDown(x, y, pointer);
		}
	}

	private void initStage() {
		this.stage = new Stage(Gdx.graphics.getWidth(),
				Gdx.graphics.getHeight(), true);
		this.stage.addActor(nextImage);
		this.stage.addActor(replayImage);
	}
}
