package com.savefish.screens.game;

import java.util.HashMap;
import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.CircleShape;
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
		this.initSprite();
		try {
			this.initWorld(gate);
		} catch (Exception e) {
			GreenLogger.getInstance().severe(e.toString());
		}

	}

	private OrthographicCamera camera;

	private void initCamera() {
		camera = new OrthographicCamera(Constant.physics.CAMERA_VIEW_WIDTH,
				Constant.physics.CAMERA_VIEW_HEIGHT);
		camera.position.set(Constant.physics.CAMERA_X,
				Constant.physics.CAMERA_Y, Constant.physics.CAMERA_Z);
	}

	private World world;

	private void initWorld(int gate) throws Exception {
		if (gate <= maps.size())
			world = GreenWorldFactory.creatWorld(Constant.asset.MAPS_BASE_PATH
					+ maps.get(gate));
		else
			world = GreenWorldFactory.creatWorld(Constant.asset.MAPS_BASE_PATH
					+ maps.get(1));
	}

	private Box2DDebugRenderer render;

	private void initRender() {
		render = new Box2DDebugRenderer();
	}

	private Sprite sprite = null;

	private void initSprite() {
		sprite = Assets.getInstance().getSprite();
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

	@SuppressWarnings("unused")
	private void applyToBody() {
		Iterator<Body> iter = world.getBodies();
		while (iter.hasNext()) {
			Body body = iter.next();
			String bodyName = (String) body.getUserData();
			if ((bodyName != null) && bodyName.startsWith("Rubbish")) {
				CircleShape shape = (CircleShape) body.getFixtureList().get(0)
						.getShape();
				float radius = shape.getRadius();
				Vector2 position = body.getPosition();
//				GreenLogger.getInstance().severe(radius + "");
//				GreenLogger.getInstance().severe(body.getPosition().toString());
//				GreenLogger.getInstance().severe(
//						position.x * 10 + ", " + position.y * 10);
				body.applyForceToCenter(body.getPosition().x / 10, -10);
			}
		}
	}

	public void render(float delta, GL10 gl) {
		this.world.step(delta, 3, 3);
		this.applyToBody();
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
		return super.touchDown(x, y, pointer, button);
	}

	@Override
	public boolean touchUp(int x, int y, int pointer, int button) {
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
