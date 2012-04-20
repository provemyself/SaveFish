package com.savefish.screens.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.savefish.assets.Assets;
import com.savefish.constant.Constant;
import com.savefish.pointsystem.GameResult;
import com.savefish.screens.EndScreen;
import com.savefish.service.BackgroundMusic;

public class GameControlStage extends Stage {

	public static GameControlStage getInstance(Game game) {
		return new GameControlStage(game);
	}

	private Game game = null;

	private GameControlStage(Game game) {
		super(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), true);
		this.game = game;
		this.initPauseImage();
	}

	private Image pauseImage = null;

	private void initPauseImage() {
		this.pauseImage = new PauseImage(Assets.getInstance().getTextureRegion(
				Constant.asset.PAUSE));
		this.pauseImage.scaleX = 0.3f;
		this.pauseImage.scaleY = 0.3f;
		this.pauseImage.x = Gdx.graphics.getWidth() - this.pauseImage.width
				/ 2.0f;
		this.pauseImage.y = Gdx.graphics.getHeight() - this.pauseImage.height
				/ 2.0f;
	}

	class PauseImage extends Image {

		public PauseImage(TextureRegion textureRegion) {
			super(textureRegion);
		}

		@Override
		public boolean touchDown(float x, float y, int pointer) {
			BackgroundMusic.getInstance().stop();
			GameResult.isPassed = false;
			game.setScreen(new EndScreen(game));
			return super.touchDown(x, y, pointer);
		}

	}

	public void render(float delta) {
		this.addActor(pauseImage);
		this.act(delta);
		this.draw();
	}

	@Override
	public boolean touchDown(int x, int y, int pointer, int button) {
		return super.touchDown(x, y, pointer, button);
	}

	@Override
	public boolean touchUp(int x, int y, int pointer, int button) {
		return super.touchUp(x, y, pointer, button);
	}

	@Override
	public boolean touchDragged(int x, int y, int pointer) {
		return super.touchDragged(x, y, pointer);
	}
}
