package com.savefish.screens;

import java.util.logging.Level;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.savefish.physics.resolve.GreenWorldFactory;
import com.savefish.util.GreenLogger;
import com.savefish.util.PathHelper;

public class GameScreen implements Screen {

	@SuppressWarnings("unused")
	private Game game;

	private OrthographicCamera camera;
	private Box2DDebugRenderer render;
	private World world;

	public GameScreen(Game game) throws Exception {
		this.game = game;

		this.initCamera();
		this.initWorld();
		this.initRender();
	}

	@Override
	public void render(float delta) {
		GreenLogger.getInstance().getLogger().log(Level.INFO, "render");
		this.world.step(Gdx.app.getGraphics().getDeltaTime(), 3, 3);
		GL10 gl = Gdx.app.getGraphics().getGL10();
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		this.camera.update();
		this.camera.apply(gl);
		this.render.render(world, this.camera.combined);
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		GreenLogger.getInstance().getLogger().log(Level.INFO, "resize");
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		GreenLogger.getInstance().getLogger().log(Level.INFO, "show");
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		GreenLogger.getInstance().getLogger().log(Level.INFO, "hide");
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		GreenLogger.getInstance().getLogger().log(Level.INFO, "pause");
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		GreenLogger.getInstance().getLogger().log(Level.INFO, "resume");
	}

	@Override
	public void dispose() {
		GreenLogger.getInstance().getLogger().log(Level.INFO, "dispose");
		this.render.dispose();
		this.world.dispose();
		this.render = null;
		this.world = null;
	}

	private void initCamera() {
		camera = new OrthographicCamera(48, 32);
		camera.position.set(4, 12, 0);
	}

	private void initWorld() throws Exception {
		world = GreenWorldFactory
				.creatWorld(PathHelper.getMapPath("HaveName.json"));
		// world.setContactListener(collision);
		// world.setContactFilter(new DetectFilter(this));
	}

	private void initRender() {
		render = new Box2DDebugRenderer();
	}
}
