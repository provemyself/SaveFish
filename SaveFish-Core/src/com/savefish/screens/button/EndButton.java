package com.savefish.screens.button;

/********************************
 * Description: the class include
 * buttons when we end our game 
 * every time.mabye win,or failed
 * Author: Yang Yong 
 * Date : 2012/03/08
 *******************************/
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.savefish.pointsystem.CurrentLevel;
import com.savefish.pointsystem.GameLevel;
import com.savefish.pointsystem.GameResult;
import com.savefish.pointsystem.GameScoreRecord;
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

		@Override
		public void draw(SpriteBatch batch, float parentAlpha) {

			fontShow(batch);
			super.draw(batch, parentAlpha);

		}

		private void fontShow(SpriteBatch batch) {
			if (!GameResult.isPassed) {
				bitmapFont.draw(batch, "You Failed!",
						Gdx.graphics.getWidth() / 2,
						Gdx.graphics.getHeight() / 2);
			} else {
				bitmapFont.draw(batch, "You Succeed!",
						Gdx.graphics.getWidth() / 2,
						Gdx.graphics.getHeight() / 2);
			}
			String crossScore = String
					.valueOf(GameScoreRecord.currentLevelScore.getCrossScore());
			String cleanIndex = String
					.valueOf(GameScoreRecord.currentLevelScore
							.getCrossCleanIndex());
			bitmapFont.draw(batch, "Date:  "
					+ GameScoreRecord.currentLevelScore.getDateTime(),
					Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 3);
			bitmapFont.draw(batch, "cross score:  " + crossScore,
					Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 4);
			bitmapFont.draw(batch, "clean index:  " + cleanIndex,
					Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 5);
		}

		@Override
		public boolean touchDown(float x, float y, int point) {
			game.setScreen(GameScreen.getInstance().switchToGameLevel(
					CurrentLevel.level));
			return super.touchDown(x, y, point);

		}

	}

	public class ShareActor extends Image {

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
					GameLevel.createInstance(CurrentLevel.level.getBig(),
							CurrentLevel.level.getSmall() + 1)));
			return super.touchDown(x, y, point);

		}

	}
}