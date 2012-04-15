package com.savefish.screens.button;

/********************************
 * Description: 该类为游动的鱼背景，
 *              让鱼在屏幕中游动作为背景
 *              需要修改
 * Author     : 杨勇
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

	/*
	 * @Introduce 该函数用来设置鱼的起始游动位置是从左还是从右
	 */
	boolean directionLeft = true; // 标志位，判断鱼的游动方向是屏幕左还是右
	static final int frame = 24;
	int fishMove = 0;

	public void setPosition(float x, float y, boolean direction) {
		this.x = x;
		this.y = y;
		directionLeft = direction;
	}

	/*
	 * @Description 下面这个函数是用来使界面背景中的鱼来回游动显示
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
