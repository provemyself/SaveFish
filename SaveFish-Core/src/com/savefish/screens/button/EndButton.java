package com.savefish.screens.button;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.savefish.pointsystem.GameLevel;
import com.savefish.screens.game.GameScreen;

public class EndButton {

	private ReplayActor replayActor;
	private ShareActor shareActor;
	private NextActor nextActor;
	private Game game;

	public EndButton(Game game) {
		this.game = game;
	}

	public ReplayActor getReplayActor(TextureRegion[] region) {
		replayActor = new ReplayActor(region);
		return replayActor;
	}

	public ShareActor getShareActor(TextureRegion[] region) {
		shareActor = new ShareActor(region);
		return shareActor;
	}

	public NextActor getNextActor(TextureRegion[] region) {
		nextActor = new NextActor(region);
		return nextActor;
	}

	public class ReplayActor extends Image {

		@SuppressWarnings("unused")
		private TextureRegion[] region;
		private BitmapFont bitmapFont = null;

		private ReplayActor(TextureRegion[] region) {

			super(region[0]);
			this.x = (float) (Gdx.graphics.getWidth() / 2);
			this.y = (float) (Gdx.graphics.getHeight() / 8);
			this.region = region;
			bitmapFont = new BitmapFont(
					Gdx.files.internal("fonts/highScore.fnt"),
					Gdx.files.internal("fonts/highScore.png"), false);

		}

		private boolean isFailed = false;

		@Override
		public void draw(SpriteBatch batch, float parentAlpha) {

			// 增加变量来使游戏显示胜利与否
			if (isFailed) {
				bitmapFont.draw(batch, "You Failed!",
						Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight()
								- bitmapFont.getScaleY());
			} else {
				bitmapFont.draw(batch, "You Succeed!",
						Gdx.graphics.getWidth() / 2,
						Gdx.graphics.getHeight() / 2);

			}

			super.draw(batch, parentAlpha);

		}

		@Override
		public boolean touchDown(float x, float y, int point) {

			// isFailed = true;

			return false;

		}

	}

	public class ShareActor extends Image {

		@SuppressWarnings("unused")
		private BitmapFont bitmapFont = null;
		@SuppressWarnings("unused")
		private TextureRegion[] region = null;

		private ShareActor(TextureRegion[] region) {

			super(region[0]);
			this.x = (float) (Gdx.graphics.getWidth() / 3);
			this.y = (float) (Gdx.graphics.getHeight() / 4);
			this.region = region;

		}

		@Override
		public void draw(SpriteBatch batch, float parentAlpha) {

			super.draw(batch, parentAlpha);

		}

		@Override
		public boolean touchDown(float x, float y, int point) {

			return false;

		}

	}

	public class NextActor extends Image {

		@SuppressWarnings("unused")
		private TextureRegion[] region;

		private NextActor(TextureRegion[] region) {

			super(region[0]);
			this.x = (float) (Gdx.graphics.getWidth() / 4);
			this.y = (float) (Gdx.graphics.getHeight() / 8);
			this.region = region;

		}

		@Override
		public void draw(SpriteBatch batch, float parentAlpha) {

			super.draw(batch, parentAlpha);

		}

		@Override
		public boolean touchDown(float x, float y, int point) {
			game.setScreen(GameScreen.getInstance().switchToGameLevel(
					GameLevel.createInstance(1, 6)));
			return false;

		}

	}
}