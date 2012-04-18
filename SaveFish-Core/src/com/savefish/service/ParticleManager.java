package com.savefish.service;

/********************************
 * Description: 该类是粒子效果管理器
 *              负责例子效果的设置
 * Author     : 王志伟
 * Date       : 2012/03/08
 *******************************/

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.savefish.constant.Constant;

public class ParticleManager implements Managable {

	private static ParticleManager particle = null;

	public static ParticleManager getInstance() {
		if (null == particle)
			particle = new ParticleManager();
		return particle;
	}

	private ParticleManager() {
		this.initSpriteBatch();
		this.initParticleEffect();
	}

	public void render(float delta) {
		this.spriteBatch.begin();
		this.spriteBatch.setColor(Color.WHITE);
		particleEffect.draw(this.spriteBatch, delta);
		this.spriteBatch.end();
	}

	public void start() {
		this.particleEffect.start();
	}

	public void setPosition(float x, float y) {
		this.particleEffect.setPosition(x, y);
	}

	public void setPosition(Body body) {
		Vector2 tmp = body.getPosition();
		tmp.x *= (2f * 10);
		tmp.y *= (2f * 10);
		this.setPosition(tmp.x, tmp.y);
	}

	public void setDuration(int duration) {
		this.particleEffect.setDuration(duration);
	}

	public void dispose() {
		this.spriteBatch.dispose();
		this.particleEffect.dispose();
		particle = null;
	}

	private ParticleEffect particleEffect = null;

	private void initParticleEffect() {
		this.particleEffect = new ParticleEffect();
		this.particleEffect.load(
				Gdx.files.internal(Constant.basepath.PARTICLES_BASE_PATH
						+ Constant.particle.PARTICLE_SIX),
				Gdx.files.internal(Constant.basepath.PARTICLES_BASE_PATH));
		particleEffect.setPosition(100f, 100f);
		particleEffect.setDuration(1);
	}

	private SpriteBatch spriteBatch = null;

	private void initSpriteBatch() {
		this.spriteBatch = new SpriteBatch();
	}
}
