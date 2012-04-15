package com.savefish.screens.button;

/********************************
 * Description: 该类为返回按钮，
 *              点击后返回到主界面
 * Author     : 杨勇
 * Date       : 2012/03/08
 *******************************/
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.savefish.screens.MenuScreen;

public class MenuActor extends Image {

	private TextureRegion[] region;
	private Game game;

	public MenuActor(Game game, TextureRegion[] region) {

		super(region[0]);
		this.x = (float) (Gdx.graphics.getWidth() - region[0].getRegionWidth());
		this.y = (float) (Gdx.graphics.getHeight() - Gdx.graphics.getHeight());

		this.game = game;
		this.region = region;
	}

	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		fishMoving();
		super.draw(batch, parentAlpha);

	}

	static final int frame = 24;
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

		game.setScreen(new MenuScreen(game));
		return false;

	}

}
