package com.savefish.screens.button;
/********************************
 * Description: the game will turn
 * to the option screen when we click
 * the option button
 * Author     : Yang Yong
 * Date       : 2012/03/08
 *******************************/
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.savefish.screens.OptionScreen;

public class OptionActor extends Image {

	private TextureRegion[] region;
	private Game game;

	public OptionActor(Game game, TextureRegion[] region) {

		super(region[0]);
		this.x = (float) (5 * Gdx.graphics.getWidth() / 6);
		this.y = (float) (Gdx.graphics.getHeight() / 2);
		this.scaleX = (float) (Gdx.graphics.getWidth() / (6 * region[0]
				.getRegionWidth()));
		this.scaleY = this.scaleX;
		this.region = region;
		this.game = game;
	}

	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		fishMoving();
		super.draw(batch, parentAlpha);

	}

	static final int frame = 24;// 让option按钮图片每隔12帧改变一下
								// 24帧一个循环
	int fishMove = 0;

	private void fishMoving() {

		if (fishMove < frame / 2) {
			fishMove++;
			this.setRegion(region[0]);
		} else if ((fishMove >= frame / 2) && (fishMove < frame)) {
			fishMove++;
			this.setRegion(region[1]);
		} else {
			fishMove = 0;
		}
	}

	@Override
	public boolean touchDown(float x, float y, int point) {

		game.setScreen(new OptionScreen(game));
		return false;
	}

	@Override
	public void touchUp(float x, float y, int point) {

	}
}
