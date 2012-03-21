package com.savefish.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.savefish.constant.Constants;
import com.savefish.physics.resolve.GreenWorldFactory;
import com.savefish.util.PathHelper;
import com.savefish.util.logger.GreenLogger;

public class GameScreen implements Screen {

	@SuppressWarnings("unused")
	private Game game;

	private OrthographicCamera camera;
	private Box2DDebugRenderer render;
	private ParticleStage particle;
	private World world;

	public GameScreen(Game game) throws Exception {
		this.game = game;

		this.initCamera();
		this.initWorld();
		this.initRender();
		this.particle = new ParticleStage();
	}

	@Override
	public void render(float delta) {
		this.world.step(Gdx.app.getGraphics().getDeltaTime(), 3, 3);
		GL10 gl = Gdx.app.getGraphics().getGL10();
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		this.particle.render();
		this.camera.update();
		this.camera.apply(gl);
		this.render.render(world, this.camera.combined);
	}

	@Override
	public void resize(int width, int height) {
		GreenLogger.getInstance().info(
				"GameScreen resize" + width + " : " + height);
	}

	@Override
	public void show() {
	}

	@Override
	public void hide() {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
		this.render.dispose();
		this.world.dispose();
		this.render = null;
		this.world = null;
	}

	private void initCamera() {
		camera = new OrthographicCamera(Constants.physics.CAMERA_VIEW_WIDTH,
				Constants.physics.CAMERA_VIEW_HEIGHT);
		camera.position.set(24, 15, 0);
	}

	private void initWorld() throws Exception {
		world = GreenWorldFactory.creatWorld(PathHelper
				.getMapPath("fourthMap.json"));
		// world.setContactListener(collision);
		// world.setContactFilter(new DetectFilter(this));
	}

	private void initRender() {
		render = new Box2DDebugRenderer();
	}
}
