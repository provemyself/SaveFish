package com.savefish.screens.button;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.savefish.screens.AboutScreen;

public class HelpActor extends Image {

	private TextureRegion[] region;
	private Game game;

	public HelpActor(Game game, TextureRegion[] region) {

		super(region[0]);
		this.x = (float) (3 * Gdx.graphics.getWidth() / 4);
		this.y = (float) (Gdx.graphics.getHeight() / 4);
		this.scaleX = (float) (Gdx.graphics.getWidth() / (8 * region[0]
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
		game.setScreen(new AboutScreen(game));////转到help界面
		return false;

	}

}
