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
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.savefish.constant.Constant;
import com.savefish.service.MusicManager;

public class OptionButton {

	private MusicActor musicActor;
	private SoundActor soundActor;
	private HighscoreActor highscoreActor;
	@SuppressWarnings("unused")
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

			// 点击后，会关闭背景音乐
			if (Constant.asset.isBgMusicOn) {
				this.setRegion(region[1]);
				Constant.asset.isBgMusicOn = false;
				MusicManager.getInstance().stop();
			} else {
				this.setRegion(region[0]);
				Constant.asset.isBgMusicOn = true;
				MusicManager.getInstance().play();
			}

			return false;

		}

	}

	public class HighscoreActor extends Image {

		private HighscoreActor(TextureRegion[] region) {

			super(region[0]);
			this.x = (float) (Gdx.graphics.getWidth() / 3);
			this.y = (float) (Gdx.graphics.getHeight() / 4);

		}

		@Override
		public void draw(SpriteBatch batch, float parentAlpha) {

			super.draw(batch, parentAlpha);

		}

		@Override
		public boolean touchDown(float x, float y, int point) {

			// 点击后会关闭或开启音效
			return false;

		}

	}

	public class SoundActor extends Image {

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

		private boolean soundJudge = true;

		@Override
		public boolean touchDown(float x, float y, int point) {

			if (soundJudge) {
				this.setRegion(region[1]);
				soundJudge = false;
				// MusicManager.getInstance().stop();
				// 关闭音效

			} else {
				this.setRegion(region[0]);
				soundJudge = true;
				// MusicManager.getInstance().play();
				// 打开音效
			}
			return false;

		}

	}
}
