package com.savefish.screens.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.savefish.assets.Assets;
import com.savefish.constant.Constant;
import com.savefish.logical.WorldManager;

public class MiddleStage extends Stage {

	public static MiddleStage createMiddleStage(int gate) {
		return new MiddleStage(gate);
	}

	private MiddleStage(int gate) {
		super(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), true);
		this.initCamera();
		this.initRender();
		this.initSprite();
		this.initWorldManager();
	}

	private OrthographicCamera camera;

	private void initCamera() {
		camera = new OrthographicCamera(Constant.physics.CAMERA_VIEW_WIDTH,
				Constant.physics.CAMERA_VIEW_HEIGHT);
		camera.position.set(Constant.physics.CAMERA_X,
				Constant.physics.CAMERA_Y, Constant.physics.CAMERA_Z);
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

	private WorldManager worldManager = null;

	private void initWorldManager() {
		this.worldManager = WorldManager.createWorldManager(1);
	}

	public void render(float delta, GL10 gl) {
		this.camera.update();
		this.camera.apply(gl);
		this.worldManager.render(delta);
		this.render.render(worldManager.getWorld(), this.camera.combined);
	}

	@Override
	public void dispose() {
		this.render.dispose();
		this.camera = null;
		this.worldManager = null;
		this.sprite = null;
		super.dispose();
	}

	@Override
	public boolean touchDown(int x, int y, int pointer, int button) {
		return worldManager.touchDown(x, y, pointer, button);
	}

	@Override
	public boolean touchUp(int x, int y, int pointer, int button) {
		return worldManager.touchUp(x, y, pointer, button);
	}

	@Override
	public boolean touchDragged(int x, int y, int pointer) {
		return worldManager.touchDragged(x, y, pointer);
	}

	@Override
	public boolean touchMoved(int x, int y) {
		return worldManager.touchMoved(x, y);
	}
}
