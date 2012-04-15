package com.savefish.screens.button;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
/********************************
 * Description: 该类为退出按钮，需要修改监听事件
 * Author     : 杨勇
 * Date       : 2012/03/08
 *******************************/
public class ExitActor extends Image {

	private TextureRegion[] region = null;

	public ExitActor(TextureRegion[] region) {

		super(region[0]);
		// 设置退出按钮的相对位置为右下角
		this.x = (float) (Gdx.graphics.getWidth() - region[0].getRegionWidth());
		this.y = (float) (Gdx.graphics.getHeight() - Gdx.graphics.getHeight());
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
		System.exit(0);// 直接退出游戏,需要修改
		return false;
	}
}
