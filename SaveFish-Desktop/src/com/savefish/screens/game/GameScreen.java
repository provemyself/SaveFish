package com.savefish.screens.game;

import java.util.logging.Level;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.savefish.constant.Constant;
import com.savefish.physics.resolve.GreenWorldFactory;
import com.savefish.util.PathHelper;
import com.savefish.util.logger.GreenLogger;

public class GameScreen implements Screen {

	private static GameScreen gs = null;

	public static GameScreen getInstance(Game game) {
		if (null == gs) {
			try {
				gs = new GameScreen(game);
			} catch (Exception e) {
			}
		}
		return gs;
	}

	private GameScreen(Game game) throws Exception {
		this.initGame(game);
		this.initCamera();
		this.initWorld();
		this.initRender();
		this.initStages();
	}

	@SuppressWarnings("unused")
	private Game game;

	private void initGame(Game game) {
		this.game = game;
	}

	private OrthographicCamera camera;

	private void initCamera() {
		camera = new OrthographicCamera(Constant.physics.CAMERA_VIEW_WIDTH,
				Constant.physics.CAMERA_VIEW_HEIGHT);
		camera.position.set(24, 15, 0);
	}

	private World world;

	private void initWorld() throws Exception {
		world = GreenWorldFactory.creatWorld(PathHelper
				.getMapPath("firstMap.json"));
	}

	private Box2DDebugRenderer render;

	private void initRender() {
		render = new Box2DDebugRenderer();
	}

	private ParticleStage particle;

	private void initStages() {
		this.particle = new ParticleStage();
	}

	@Override
	public void render(float delta) {
		GreenLogger.getInstance().log(Level.INFO, "render world!");
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
}
