package com.savefish.screens.game;

import java.util.HashMap;
import java.util.Iterator;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.savefish.constant.Constant;
import com.savefish.event.BodyKilledListener;
import com.savefish.event.GreenEvent;
import com.savefish.logical.WorldManager;
import com.savefish.pointsystem.GameLevel;
import com.savefish.render.GameActorFactory;
import com.savefish.service.BackgroundMusic;

public class GameMiddleStage extends Stage implements BodyKilledListener<Body> {

	public static GameMiddleStage createInstance(GameLevel level, Game game) {
		BackgroundMusic.getInstance().play();
		return new GameMiddleStage(level, game);
	}

	private GameMiddleStage(GameLevel level, Game game) {
		super(Constant.screen.SCREEN_WIDTH, Constant.screen.SCREEN_HEIGHT, true);
		this.initGame(game);
		this.initCamera();
		this.initRender();
		this.initWorldManager(level);
		this.initHashMap();
	}

	private Game game;

	private void initGame(Game game) {
		this.game = game;
	}

	public Game getGame() {
		return this.game;
	}

	// 正交相机
	private OrthographicCamera camera;

	private void initCamera() {
		camera = new OrthographicCamera(Constant.physics.CAMERA_VIEW_WIDTH,
				Constant.physics.CAMERA_VIEW_HEIGHT);
		camera.position.set(Constant.physics.CAMERA_X,
				Constant.physics.CAMERA_Y, Constant.physics.CAMERA_Z);
	}

	// Box2D调试器
	private Box2DDebugRenderer render;

	private void initRender() {
		render = new Box2DDebugRenderer();
	}

	// 物理世界管理器
	private WorldManager worldManager = null;

	private void initWorldManager(GameLevel level) {
		this.worldManager = WorldManager.createWorldManager(level, this);
	}

	private HashMap<Body, Actor> bodyActorMap = new HashMap<Body, Actor>();

	private void initHashMap() {
		if ((null != bodyActorMap) && (!bodyActorMap.isEmpty()))
			bodyActorMap.clear();

		Iterator<Body> iter = this.worldManager.getWorld().getBodies();
		while (iter.hasNext()) {
			Body body = iter.next();
			Actor actor = GameActorFactory.createGameActor(this, body);
			if (null != actor) {
				this.addActor(actor);
				this.bodyActorMap.put(body, actor);
			}
		}
	}

	public HashMap<Body, Actor> getBodyActorMap() {
		return this.bodyActorMap;
	}

	public void render(float delta) {
		GL10 gl = Gdx.graphics.getGL10();
		this.camera.update();
		this.camera.apply(gl);
		this.worldManager.render(delta);
		this.render.render(worldManager.getWorld(), this.camera.combined);
		this.act(delta);
		this.draw();
	}

	@Override
	public void dispose() {
		bodyActorMap = null;
		this.render.dispose();
		this.camera = null;
		this.worldManager.dispose();
		BackgroundMusic.getInstance().stop();
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
	public void onKillActor(GreenEvent<Body> arg) {
		if (null != arg) {
			Body body = arg.getSource();
			if ((null != body) && (bodyActorMap.containsKey(body)))
				this.removeActor(bodyActorMap.get(body));
		}
	}
}
