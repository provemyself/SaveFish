package com.savefish.screens.game;

import java.util.logging.Level;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.savefish.constant.Constant;
import com.savefish.util.logger.GreenLogger;

public class ParticleStage extends Stage {

	private ParticleEffect particle;
	private SpriteBatch batch;
	private GL10 gl;

	public ParticleStage() {
		super(Constant.screen.SCREEN_WIDTH, Constant.screen.SCREEN_HEIGHT, true);

		GreenLogger.getInstance().logp(Level.INFO,
				ParticleStage.class.getName(), "ParticleStage", "called!");

		this.initGL10();
		this.initSpriteBatch();
		this.initParticleEffect();
	}

	public void render() {

		GreenLogger.getInstance().logp(Level.INFO,
				ParticleStage.class.getName(), "render", "called!");

		this.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		this.batch.begin();
		this.batch.setColor(Color.WHITE);
		particle.draw(this.batch, Gdx.graphics.getDeltaTime());
		this.batch.end();
		Gdx.input.setInputProcessor(new ParticleProcessor());
	}

	/**
	 * @description 初始化ParticleEffect
	 */
	private void initParticleEffect() {

		GreenLogger.getInstance().logp(Level.INFO,
				ParticleStage.class.getName(), "initParticleEffect", "called!");

		this.particle = new ParticleEffect();

		this.particle.load(
				Gdx.files.internal(Constant.asset.PARTICLES_BASE_PATH
						+ Constant.asset.PARTICLE_ONE_TEXT),
				Gdx.files.internal(Constant.asset.PARTICLES_BASE_PATH));

		particle.setPosition(100f, 100f);
		particle.start();
		particle.setDuration(0);
	}

	/**
	 * @description 初始化SpriteBatch
	 */
	private void initSpriteBatch() {
		GreenLogger.getInstance().logp(Level.INFO,
				ParticleStage.class.getName(), "initSpriteBatch", "called!");

		this.batch = new SpriteBatch();
	}

	private void initGL10() {
		GreenLogger.getInstance().logp(Level.INFO,
				ParticleStage.class.getName(), "initGL10", "called!");

		this.gl = Gdx.graphics.getGL10();
	}

	class ParticleProcessor extends InputAdapter {

		@Override
		public boolean touchDown(int x, int y, int pointer, int button) {
			particle.setPosition(x, y);
			particle.start();
			return super.touchDown(x, y, pointer, button);
		}

		@Override
		public boolean touchUp(int x, int y, int pointer, int button) {
			return super.touchUp(x, y, pointer, button);
		}

	}
}
