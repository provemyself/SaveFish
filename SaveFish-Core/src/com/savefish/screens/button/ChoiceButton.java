package com.savefish.screens.button;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.savefish.pointsystem.GameLevel;
import com.savefish.screens.AboutScreen;
import com.savefish.screens.game.GameScreen;

/********************************
 * Description: 该类为游戏关卡选择界面的六个关卡按钮 其中每个按钮的内容除了按键监听不同外 事件都相同 还有待完善，应跳转到第一关 Author
 * : 杨勇 Date : 2012/03/08
 *******************************/
public class ChoiceButton {

	private Choice_1Actor choice_1Actor;
	private Choice_2Actor choice_2Actor;
	private Choice_3Actor choice_3Actor;
	private Choice_4Actor choice_4Actor;
	private Choice_5Actor choice_5Actor;
	private Choice_6Actor choice_6Actor;
	private Game game;

	public ChoiceButton(Game game) {
		this.game = game;
	}

	public Choice_1Actor getChoice_1Actor(TextureRegion[] region) {
		choice_1Actor = new Choice_1Actor(region);
		return choice_1Actor;
	}

	public Choice_2Actor getChoice_2Actor(TextureRegion[] region) {
		choice_2Actor = new Choice_2Actor(region);
		return choice_2Actor;
	}

	public Choice_3Actor getChoice_3Actor(TextureRegion[] region) {
		choice_3Actor = new Choice_3Actor(region);
		return choice_3Actor;
	}

	public Choice_4Actor getChoice_4Actor(TextureRegion[] region) {
		choice_4Actor = new Choice_4Actor(region);
		return choice_4Actor;
	}

	public Choice_5Actor getChoice_5Actor(TextureRegion[] region) {
		choice_5Actor = new Choice_5Actor(region);
		return choice_5Actor;
	}

	public Choice_6Actor getChoice_6Actor(TextureRegion[] region) {
		choice_6Actor = new Choice_6Actor(region);
		return choice_6Actor;
	}

	public class Choice_1Actor extends Image {

		private TextureRegion[] region;

		private Choice_1Actor(TextureRegion[] region) {

			super(region[0]);
			this.x = (float) (Gdx.graphics.getWidth() / 4 - region[0]
					.getRegionWidth() / 2);
			this.y = (float) (2*Gdx.graphics.getHeight() / 3 - region[0]
					.getRegionHeight() / 2);
			this.rotation = 45;
			this.region = region;

		}

		private boolean lock = false;

		@Override
		public void draw(SpriteBatch batch, float parentAlpha) {

			if (lock) {
				this.setRegion(region[1]);
			} else {
				this.setRegion(region[0]);
			}
			super.draw(batch, parentAlpha);

		}

		@Override
		public boolean touchDown(float x, float y, int point) {
			if (!lock) {
				// 进入游戏第一关
				game.setScreen(GameScreen.getInstance(game, GameLevel.createInstance(2, 2)));
			}
			return false;

		}

	}

	public class Choice_2Actor extends Image {

		private TextureRegion[] region;

		private Choice_2Actor(TextureRegion[] region) {

			super(region[0]);
			this.x = (float) (Gdx.graphics.getWidth() / 2 - region[0]
					.getRegionWidth() / 2);
			this.y = (float) (2*Gdx.graphics.getHeight() / 3 - region[0]
					.getRegionHeight() / 2);
			this.rotation = 45;
			this.region = region;

		}

		private boolean lock = true;

		@Override
		public void draw(SpriteBatch batch, float parentAlpha) {

			if (lock) {
				this.setRegion(region[1]);
			} else {
				this.setRegion(region[0]);
			}
			super.draw(batch, parentAlpha);

		}

		@Override
		public boolean touchDown(float x, float y, int point) {
			if (!lock) {
				game.setScreen(new AboutScreen(game));// ////////////
			}

			return false;

		}

	}

	public class Choice_3Actor extends Image {

		private TextureRegion[] region;

		private Choice_3Actor(TextureRegion[] region) {

			super(region[0]);
			this.x = (float) (3*Gdx.graphics.getWidth() / 4 - region[0]
					.getRegionWidth() / 2);
			this.y = (float) (2*Gdx.graphics.getHeight() / 3 - region[0]
					.getRegionHeight() / 2);
			this.rotation = 45;
			this.region = region;

		}

		private boolean lock = true;

		@Override
		public void draw(SpriteBatch batch, float parentAlpha) {

			if (lock) {
				this.setRegion(region[1]);
			} else {
				this.setRegion(region[0]);
			}
			super.draw(batch, parentAlpha);

		}

		@Override
		public boolean touchDown(float x, float y, int point) {
			if (!lock) {
				game.setScreen(new AboutScreen(game));// ////////////
			}

			return false;

		}

	}

	public class Choice_4Actor extends Image {

		private TextureRegion[] region;

		private Choice_4Actor(TextureRegion[] region) {

			super(region[0]);
			this.x = (float) (Gdx.graphics.getWidth() / 4 - region[0]
					.getRegionWidth() / 2);
			this.y = (float) (Gdx.graphics.getHeight() / 3 - region[0]
					.getRegionHeight() / 2);
			this.rotation = 45;
			this.region = region;

		}

		private boolean lock = true;

		@Override
		public void draw(SpriteBatch batch, float parentAlpha) {

			if (lock) {
				this.setRegion(region[1]);
			} else {
				this.setRegion(region[0]);
			}
			super.draw(batch, parentAlpha);

		}

		@Override
		public boolean touchDown(float x, float y, int point) {
			if (!lock) {
				game.setScreen(new AboutScreen(game));// ////////////
			}

			return false;

		}

	}

	public class Choice_5Actor extends Image {

		private TextureRegion[] region;

		private Choice_5Actor(TextureRegion[] region) {

			super(region[0]);
			this.x = (float) (Gdx.graphics.getWidth() / 2 - region[0]
					.getRegionWidth() / 2);
			this.y = (float) (Gdx.graphics.getHeight() / 3 - region[0]
					.getRegionHeight() / 2);
			this.rotation = 45;
			this.region = region;

		}

		private boolean lock = true;

		@Override
		public void draw(SpriteBatch batch, float parentAlpha) {

			if (lock) {
				this.setRegion(region[1]);
			} else {
				this.setRegion(region[0]);
			}
			super.draw(batch, parentAlpha);

		}

		@Override
		public boolean touchDown(float x, float y, int point) {
			if (!lock) {
				game.setScreen(new AboutScreen(game));// ////////////
			}
			return false;

		}

	}

	public class Choice_6Actor extends Image {

		private TextureRegion[] region;

		private Choice_6Actor(TextureRegion[] region) {

			super(region[0]);
			this.x = (float) (3*Gdx.graphics.getWidth() / 4 - region[0]
					.getRegionWidth() / 2);
			this.y = (float) (Gdx.graphics.getHeight() / 3 - region[0]
					.getRegionHeight() / 2);
			this.rotation = 45;
			this.region = region;

		}

		private boolean lock = true;

		@Override
		public void draw(SpriteBatch batch, float parentAlpha) {

			if (lock) {
				this.setRegion(region[1]);
			} else {
				this.setRegion(region[0]);
			}
			super.draw(batch, parentAlpha);

		}

		@Override
		public boolean touchDown(float x, float y, int point) {
			if (!lock) {
				game.setScreen(new AboutScreen(game));// ////////////
			}

			return false;

		}

	}

}
