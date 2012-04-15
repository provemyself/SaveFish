package com.savefish.screens.button;

/********************************
 * Description: 该类为开始界面的两个，需要修改
 *              按钮类，点击后进入细
 *              分的关卡选择
 * Author     : 杨勇
 * Date       : 2012/03/08
 *******************************/
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.savefish.screens.SelectScreen;

public class StartButton {
	private ChoiceoneActor choiceoneActor;
	private ChoicetwoActor choicetwoActor;
	private Game game;

	public StartButton(Game game) {
		this.game = game;
	}

	public ChoiceoneActor getChoiceoneActor(TextureRegion[] region) {
		choiceoneActor = new ChoiceoneActor(region);
		return choiceoneActor;
	}

	public ChoicetwoActor getChoicetwoActor(TextureRegion[] region) {
		choicetwoActor = new ChoicetwoActor(region);
		return choicetwoActor;
	}

	public class ChoiceoneActor extends Image {

		private TextureRegion[] region;

		private ChoiceoneActor(TextureRegion[] region) {

			super(region[0]);
			this.x = (float) (Gdx.graphics.getWidth() / 6);
			this.y = (float) (3 * Gdx.graphics.getHeight() / 8);
			this.scaleX = (float) (5 * Gdx.graphics.getWidth() / (12 * region[0]
					.getRegionWidth()));
			this.scaleY = this.scaleX;
			this.region = region;

		}

		@Override
		public void draw(SpriteBatch batch, float parentAlpha) {

			fishMoveButton();
			super.draw(batch, parentAlpha);

		}

		static final int frame = 12;
		int fishMove = 0;

		private void fishMoveButton() {
			if (fishMove < frame) {
				fishMove++;
				this.setRegion(region[0]);
			} else if ((fishMove >= frame) && (fishMove < frame * 2)) {
				fishMove++;
				this.setRegion(region[1]);
			} else if ((fishMove >= 2 * frame) && (fishMove < frame * 3)) {
				fishMove++;
				this.setRegion(region[2]);
			} else if ((fishMove >= 3 * frame) && (fishMove < frame * 4)) {
				fishMove++;
				this.setRegion(region[3]);
			} else {
				fishMove = 0;
			}
		}

		@Override
		public boolean touchDown(float x, float y, int point) {
			game.setScreen(new SelectScreen(game));
			return false;

		}

	}

	public class ChoicetwoActor extends Image {

		private TextureRegion[] region;

		private ChoicetwoActor(TextureRegion[] region) {

			super(region[0]);
			this.x = (float) (7 * Gdx.graphics.getWidth() / 12);
			this.y = (float) (Gdx.graphics.getHeight() / 4);
			this.scaleX = (float) (5 * Gdx.graphics.getWidth() / (12 * region[0]
					.getRegionWidth()));
			this.scaleY = this.scaleX;
			this.region = region;

		}

		@Override
		public void draw(SpriteBatch batch, float parentAlpha) {

			fishMoveButton();
			super.draw(batch, parentAlpha);

		}

		static final int frame = 12;
		int fishMove = 0;

		private void fishMoveButton() {
			if (fishMove < frame) {
				fishMove++;
				this.setRegion(region[0]);
			} else if ((fishMove >= frame) && (fishMove < frame * 2)) {
				fishMove++;
				this.setRegion(region[1]);
			} else if ((fishMove >= 2 * frame) && (fishMove < frame * 3)) {
				fishMove++;
				this.setRegion(region[2]);
			} else if ((fishMove >= 3 * frame) && (fishMove < frame * 4)) {
				fishMove++;
				this.setRegion(region[3]);
			} else {
				fishMove = 0;
			}
		}

		@Override
		public boolean touchDown(float x, float y, int point) {
			game.setScreen(new SelectScreen(game));

			return true;

		}

	}

}
