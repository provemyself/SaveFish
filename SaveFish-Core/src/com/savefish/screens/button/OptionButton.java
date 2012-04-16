package com.savefish.screens.button;

/********************************
 * Description: 该类为option界面里的按钮，需要修改
 *              放在一个类里便于统一管理
 *              共包含三个主要按钮：
 *              背景音乐、音效、高分榜按
 *              钮
 * Author     : 杨勇
 * Date       : 2012/03/08
 *******************************/
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.savefish.screens.EndScreen;

public class OptionButton {

	private MusicActor musicActor;
	private SoundActor soundActor;
	private HighscoreActor highscoreActor;
	private Game game;

	public OptionButton(Game game) {
		this.game = game;
	}

	public MusicActor getMusicActor(TextureRegion[] region) {
		musicActor = new MusicActor(region);
		return musicActor;
	}

	public SoundActor getSoundActor(TextureRegion[] region) {
		soundActor = new SoundActor(region);
		return soundActor;
	}

	public HighscoreActor getHighscoreActor(TextureRegion[] region) {
		highscoreActor = new HighscoreActor(region);
		return highscoreActor;
	}

	public class MusicActor extends Image {

		@SuppressWarnings("unused")
		private TextureRegion[] region;

		private MusicActor(TextureRegion[] region) {

			super(region[0]);
			this.x = (float) (Gdx.graphics.getWidth() / 2);
			this.y = (float) (Gdx.graphics.getHeight() / 8);
			this.region = region;

		}

		@Override
		public void draw(SpriteBatch batch, float parentAlpha) {

			super.draw(batch, parentAlpha);

		}

		@Override
		public boolean touchDown(float x, float y, int point) {

//			// 点击后，会关闭背景音乐
//			if (Constant.asset.isBgMusicOn) {
//				this.setRegion(region[1]);
//				Constant.asset.isBgMusicOn = false;
//				MusicManager.getInstance().stop();
//			} else {
//				this.setRegion(region[0]);
//				Constant.asset.isBgMusicOn = true;
//				MusicManager.getInstance().play();
//			}

			return false;

		}

	}

	public class HighscoreActor extends Image {

		private BitmapFont bitmapFont = null;
		@SuppressWarnings("unused")
		private TextureRegion[] region = null;

		private HighscoreActor(TextureRegion[] region) {

			super(region[0]);
			this.x = (float) (Gdx.graphics.getWidth() / 3);
			this.y = (float) (Gdx.graphics.getHeight() / 4);
			this.region = region;
			bitmapFont = new BitmapFont(
					Gdx.files.internal("fonts/highScore.fnt"),
					Gdx.files.internal("fonts/highScore.png"), false);

		}

		private boolean isDrawHighScore = false;

		@Override
		public void draw(SpriteBatch batch, float parentAlpha) {

			if (isDrawHighScore) {

				int i = 90;// ///测试用
				bitmapFont.draw(batch, "High  Score", 0,
						Gdx.graphics.getHeight() - bitmapFont.getScaleY());
				bitmapFont.draw(batch, "第一名分数：  " + i,
						Gdx.graphics.getWidth() / 2,
						7 * Gdx.graphics.getHeight() / 8);
				bitmapFont.draw(batch, "第二名分数：  " + i,
						Gdx.graphics.getWidth() / 2,
						6 * Gdx.graphics.getHeight() / 8);
				bitmapFont.draw(batch, "第三名分数：  " + i,
						Gdx.graphics.getWidth() / 2,
						5 * Gdx.graphics.getHeight() / 8);
				bitmapFont.draw(batch, "第四名分数：  " + i,
						Gdx.graphics.getWidth() / 2,
						4 * Gdx.graphics.getHeight() / 8);
			}

			super.draw(batch, parentAlpha);

		}

		@Override
		public boolean touchDown(float x, float y, int point) {

			// 点击后显示高分榜
			isDrawHighScore = true;
			return false;

		}

	}

	public class SoundActor extends Image {

		@SuppressWarnings("unused")
		private TextureRegion[] region;

		private SoundActor(TextureRegion[] region) {

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

			//用于测试结束界面用
			game.setScreen(new EndScreen(game));
			return false;

		}

	}
}
