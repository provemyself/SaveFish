package com.savefish.screens.button;

/********************************
 * Description: this class is about button,
 * the game will turn to about screen when 
 * we click it!
 * Author: Yang Yong 
 * Date : 2012/03/08
 *******************************/
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class AboutShow extends Image {

	private TextureRegion[] region;
//	private Game game;

	public AboutShow(TextureRegion[] region) {

		super(region[0]);
//		this.x = (float) (Gdx.graphics.getWidth() / 2);
//		this.y = (float) (Gdx.graphics.getHeight() / 8);
//		this.scaleX = (float) (Gdx.graphics.getWidth() / (7 * region[0]
//				.getRegionWidth()));
//		this.scaleY = this.scaleX;
		this.region = region;
//		this.game = game;
	}

	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
	}


	@Override
	public boolean touchDown(float x, float y, int point) {
		
//		game.setScreen(new AboutScreen(game));
		this.setRegion(region[1]);
		return false;

	}

}
