package com.savefish.logical;

import java.util.HashMap;
import java.util.Iterator;
import java.util.logging.Level;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.savefish.constant.Constant;
import com.savefish.physics.resolve.GreenWorldFactory;
import com.savefish.screens.game.GameMiddleStage;
import com.savefish.service.SlideSound;
import com.savefish.task.BodyKilledLisetener;
import com.savefish.task.DestroyBodyTask;
import com.savefish.task.TaskContainer;
import com.savefish.task.TaskQueueContainer;
import com.savefish.util.AngleHelper;
import com.savefish.util.GreenLogger;

public class WorldManager extends InputAdapter {

	public static WorldManager createWorldManager(int level,
			GameMiddleStage gameMiddleStage) {
		return new WorldManager(level, gameMiddleStage);
	}

	private GameMiddleStage gameMiddleStage = null;

	private WorldManager(int level, GameMiddleStage gameMiddleStage) {
		this.initTasks();
		this.initMaps();
		this.gameMiddleStage = gameMiddleStage;
		this.listener = this.gameMiddleStage;
		try {
			this.initWorld(level);
		} catch (Exception e) {
			GreenLogger.getInstance().logp(Level.WARNING,
					WorldManager.class.getName(), "WorldManager", e.toString(),
					e);
		}
	}

	private BodyKilledLisetener<Body> listener = null;

	public void addTask(DestroyBodyTask task) {
		this.tasks.push(task);
	}

	public void render(float delta) {
		if (null != world) {
			ForceController.applyToRubbish(world);
			ForceController.applyWholeNatureLeft(world);
			world.step(delta, 3, 3);
			world.clearForces();
			while (!tasks.isEmpty()) {
				DestroyBodyTask task = tasks.pop();
				this.listener.onKillActor(task.getBody());
				task.onDestroyTask(world);
			}
		}
	}

	private TaskContainer<DestroyBodyTask> tasks = null;

	private void initTasks() {
		if (null == tasks)
			this.tasks = new TaskQueueContainer<DestroyBodyTask>();
		else
			this.tasks.clear();
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

	private World world = null;

	private void initWorld(int level) throws Exception {
		if (level <= maps.size())
			world = GreenWorldFactory.creatWorld(Constant.asset.MAPS_BASE_PATH
					+ maps.get(level));
		else
			world = GreenWorldFactory.creatWorld(Constant.asset.MAPS_BASE_PATH
					+ maps.get(5));
		world.setContactListener(CollisionHandler.createCollisionHandler(tasks,
				world));
	}

	public World getWorld() {
		return this.world;
	}

	private Vector2 startPosition = null;
	private Vector2 endPosition = null;

	@Override
	public boolean touchDown(int x, int y, int pointer, int button) {
		Vector3 tmp = new Vector3(x, y, 0);
		this.gameMiddleStage.getCamera().unproject(tmp);
		startPosition = new Vector2(tmp.x, tmp.y);

		return super.touchDown(x, y, pointer, button);
	}

	@Override
	public boolean touchUp(int x, int y, int pointer, int button) {
		Vector3 tmp = new Vector3(x, y, 0);
		this.gameMiddleStage.getCamera().unproject(tmp);
		endPosition = new Vector2(tmp.x, tmp.y);

		System.out.println(AngleHelper
				.computeRadian(startPosition, endPosition));
		System.out.println(AngleHelper
				.computeDegree(startPosition, endPosition));

		Vector2 result = endPosition.sub(startPosition);
		Iterator<Body> iter = world.getBodies();
		while (iter.hasNext()) {
			Body body = iter.next();
			String bodyName = (String) body.getUserData();
			if ((null != bodyName) && (bodyName.startsWith("art"))) {
				result.mul(body.getMass());
				body.applyLinearImpulse(result, body.getWorldCenter());
			}
		}
		SlideSound.getInstance().play();
		return super.touchUp(x, y, pointer, button);
	}

	@Override
	public boolean touchDragged(int x, int y, int pointer) {
		return super.touchDragged(x, y, pointer);
	}

	public void dispose() {
		this.endPosition = null;
		this.startPosition = null;
		this.tasks = null;
		this.maps = null;
		this.gameMiddleStage = null;
		this.world.dispose();
	}
}
