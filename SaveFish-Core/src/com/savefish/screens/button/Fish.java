package com.savefish.screens.button;

/********************************
 * Description: the class is shown
 * when we use it.and the fish will
 * move in the screen
 * Author     : Yang Yong
 * Date       : 2012/03/08
 *******************************/
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Fish extends Image {

	private TextureRegion[] region;

	public Fish(TextureRegion[] region) {

		super(region[0]);
		this.x = 20;
		this.y = 20;
		this.scaleX = 0.5f;
		this.scaleY = 0.5f;
		this.region = region;

	}

	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		fishMoving();
		super.draw(batch, parentAlpha);

	}

	boolean directionLeft = true; // flag bit.we need it to judge the fish is
									// moving left or right
	static final int frame = 24;
	int fishMove = 0;

	public void setPosition(float x, float y, boolean direction) {
		this.x = x;
		this.y = y;
		directionLeft = direction;
	}

	/*
	 * @Description the fuction will make the fish move in the screen.
	 */

	private void fishMoving() {
		this.scaleX -= 0.0005f;
		this.scaleY -= 0.0005f;
		if (directionLeft == true) {
			this.x -= 1;
			if (this.x <= -100) {
				this.x = 480;
				this.scaleX = 0.5f;
				this.scaleY = 0.5f;
			}
		} else {
			this.x += 1;
			if (this.x >= 480) {
				this.x = 0;
				this.scaleX = 0.5f;
				this.scaleY = 0.5f;
			}
		}

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

}
