package com.savefish.screens.game;

import java.util.HashMap;
import java.util.logging.Level;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.savefish.assets.Assets;
import com.savefish.constant.Constant;
import com.savefish.physics.resolve.GreenWorldFactory;
import com.savefish.util.logger.GreenLogger;

public class MiddleStage extends Stage {

	public static MiddleStage createMiddleStage(int gate) {
		return new MiddleStage(gate);
	}

	private MiddleStage(int gate) {
		super(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), true);
		this.initCamera();
		this.initRender();
		this.initMaps();

		try {
			this.initWorld(gate);
		} catch (Exception e) {
			GreenLogger.getInstance().severe(e.toString());
		}

		this.initSprite();
	}

	private OrthographicCamera camera;

	private void initCamera() {
		GreenLogger.getInstance().logp(Level.INFO, GameScreen.class.getName(),
				"initCamera", "called!");

		camera = new OrthographicCamera(Constant.physics.CAMERA_VIEW_WIDTH,
				Constant.physics.CAMERA_VIEW_HEIGHT);
		camera.position.set(Constant.physics.CAMERA_X,
				Constant.physics.CAMERA_Y, Constant.physics.CAMERA_Z);
	}

	private World world;

	private void initWorld(int gate) throws Exception {
		GreenLogger.getInstance().logp(Level.INFO, GameScreen.class.getName(),
				"initWorld", "called!");

		if (gate <= maps.size())
			world = GreenWorldFactory.creatWorld(Constant.asset.MAPS_BASE_PATH
					+ maps.get(gate));
		else
			world = GreenWorldFactory.creatWorld(Constant.asset.MAPS_BASE_PATH
					+ maps.get(1));
	}

	private Box2DDebugRenderer render;

	private void initRender() {
		GreenLogger.getInstance().logp(Level.INFO, GameScreen.class.getName(),
				"initRender", "called!");

		render = new Box2DDebugRenderer();
	}

	Sprite sprite = Assets.getInstance().getSprite();

	private void initSprite() {
		this.sprite.setScale(0.3f);
	}

	HashMap<Integer, String> maps = new HashMap<Integer, String>();

	private void initMaps() {
		maps.put(1, Constant.asset.PREVENT_FIRST);
		maps.put(2, Constant.asset.PREVENT_SECOND);
		maps.put(3, Constant.asset.PREVENT_THIRD);
		maps.put(4, Constant.asset.PREVENT_FOURTH);
		maps.put(5, Constant.asset.PREVETN_FIFTH);
		maps.put(6, Constant.asset.PREVENT_SIXTH);
	}

	public void render(float delta, GL10 gl) {
		this.batch.begin();
		sprite.draw(batch);
		this.batch.end();
		this.world.step(delta, 3, 3);
		this.camera.update();
		this.camera.apply(gl);
		this.render.render(world, this.camera.combined);
	}

	@Override
	public void dispose() {
		this.render.dispose();
		this.world.dispose();
		super.dispose();
	}

	@Override
	public boolean touchDown(int x, int y, int pointer, int button) {
		GreenLogger.getInstance().logp(Level.INFO, MiddleStage.class.getName(),
				"touchDown", "called");

		return super.touchDown(x, y, pointer, button);
	}

	@Override
	public boolean touchUp(int x, int y, int pointer, int button) {
		GreenLogger.getInstance().logp(Level.INFO, MiddleStage.class.getName(),
				"touchUp", "called");
		return super.touchUp(x, y, pointer, button);
	}

	@Override
	public boolean touchDragged(int x, int y, int pointer) {
		return super.touchDragged(x, y, pointer);
	}

	@Override
	public boolean touchMoved(int x, int y) {
		return super.touchMoved(x, y);
	}

}
