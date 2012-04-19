package com.savefish.logical;

import java.util.Iterator;
import java.util.logging.Level;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.savefish.constant.Constant;
import com.savefish.event.BodyKilledListener;
import com.savefish.event.GreenEvent;
import com.savefish.physics.resolve.GreenWorldFactory;
import com.savefish.pointsystem.CurrentLevel;
import com.savefish.pointsystem.GameLevel;
import com.savefish.pointsystem.MapDictionary;
import com.savefish.pointsystem.ScoreAnalysis;
import com.savefish.render.FishChecker;
import com.savefish.screens.game.GameMiddleStage;
import com.savefish.service.SlideSound;
import com.savefish.task.DestroyBodyTask;
import com.savefish.task.FilterBodyTask;
import com.savefish.task.MoveBodyTask;
import com.savefish.task.TaskContainer;
import com.savefish.task.TaskQueue;
import com.savefish.util.GreenLogger;

public class WorldManager extends InputAdapter {

	/**
	 * @description 简单工厂方法，创建实例
	 * @param level
	 * @param gameMiddleStage
	 * @return
	 */
	public static WorldManager createWorldManager(GameLevel level,
			GameMiddleStage gameMiddleStage) {
		return new WorldManager(level, gameMiddleStage);
	}

	private GameMiddleStage gameMiddleStage = null;

	private WorldManager(GameLevel level, GameMiddleStage gameMiddleStage) {
		this.initMoveTasks();
		this.initDestroyTasks();
		this.initFilterTasks();
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

	private BodyKilledListener<Body> listener = null;

	public void render(float delta) {
		if (null != world) {
			if (CurrentLevel.level.getBig() == 1)
				ForceController.applyToRubbish(world);
			ForceController.applyWholeNature(world);
			world.step(delta, 10, 10);
			world.clearForces();
			this.doDestroyBody();
			this.doMoveBody();
			this.doFilterBody();
		}
	}

	/**
	 * @description 执行摧毁物理世界中指定body
	 */
	private void doDestroyBody() {
		while (!destroyTasks.isEmpty()) {
			DestroyBodyTask destroyTask = destroyTasks.pop();
			Body body = destroyTask.getBody();
			listener.onKillActor(new GreenEvent<Body>(body));
			ScoreAnalysis.increaseScore(gameMiddleStage.getGame(), body);
			destroyTask.onDestroy(world);
		}
	}

	/**
	 * @description 执行加力使物理世界中的body运动
	 */
	private void doMoveBody() {
		while (!moveTasks.isEmpty()) {
			MoveBodyTask moveTask = moveTasks.pop();
			moveTask.onMoveBody();
		}
	}

	/**
	 * @description 执行过滤碰到水底的垃圾
	 */
	private void doFilterBody() {
		while (!filterTasks.isEmpty()) {
			FilterBodyTask filterTask = filterTasks.pop();
			Body body = filterTask.getBody();
			ScoreAnalysis.decreaseIndex(this.gameMiddleStage.getGame(), body);
			filterTask.onFilterBody();
		}
	}

	private TaskContainer<DestroyBodyTask> destroyTasks = null;

	private void initDestroyTasks() {
		if (null == destroyTasks)
			this.destroyTasks = new TaskQueue<DestroyBodyTask>();
		else
			this.destroyTasks.clear();
	}

	private TaskContainer<MoveBodyTask> moveTasks = null;

	private void initMoveTasks() {
		if (null == moveTasks)
			this.moveTasks = new TaskQueue<MoveBodyTask>();
		else
			this.moveTasks.clear();
	}

	private TaskContainer<FilterBodyTask> filterTasks = null;

	private void initFilterTasks() {
		if (null == filterTasks)
			this.filterTasks = new TaskQueue<FilterBodyTask>();
		else
			this.filterTasks.clear();
	}

	private World world = null;

	private void initWorld(GameLevel level) throws Exception {
		world = GreenWorldFactory.creatWorld(Constant.basepath.MAPS_BASE_PATH
				+ MapDictionary.getMap(level));
		world.setContactListener(CollisionHandler.createCollisionHandler(
				destroyTasks, moveTasks, filterTasks));
	}

	public World getWorld() {
		return this.world;
	}

	private Vector2 startPosition = new Vector2();
	private Vector2 endPosition = new Vector2();

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

		Vector2 result = new Vector2(endPosition.x - startPosition.x,
				endPosition.y - startPosition.y);

		Iterator<Body> iter = world.getBodies();
		while (iter.hasNext()) {
			Body body = iter.next();
			String bodyName = (String) body.getUserData();
			if (FishChecker.isArtificial(bodyName)) {
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
		this.destroyTasks = null;
		this.gameMiddleStage = null;
		this.world.dispose();
	}
}
