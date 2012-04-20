package com.savefish.screens.game.actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.savefish.assets.Assets;

public class GrassActor extends Image {

	private float stateTime = 0;

	public GrassActor() {
		super(new TextureRegion());
		this.stateTime = 0;
		this.initGrassAnimation();
	}

	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		this.stateTime += Gdx.graphics.getDeltaTime();
		Sprite sprite = new Sprite(this.grassAnimation.getKeyFrame(stateTime,
				true));
		batch.begin();
		sprite.draw(batch);
		batch.end();
	}

	private Animation grassAnimation = null;

	private void initGrassAnimation() {
		this.grassAnimation = new Animation(0.25f, Assets.getInstance()
				.getGrass());
	}
}
