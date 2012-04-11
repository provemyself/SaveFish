package com.savefish.logical;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.World;
import com.savefish.constant.Constant;
import com.savefish.physics.resolve.GreenWorldFactory;
import com.savefish.service.SlideSound;
import com.savefish.task.DestroyBodyTask;
import com.savefish.task.Task;
import com.savefish.task.TaskContainer;
import com.savefish.task.TaskQueueContainer;
import com.savefish.util.GreenLogger;

public class WorldManager extends InputAdapter {

	public static WorldManager createWorldManager(int level) {
		return new WorldManager(level);
	}

	private WorldManager(int level) {
		this.initTasks();
		this.initMaps();
		try {
			this.initWorld(level);
		} catch (Exception e) {
			GreenLogger.getInstance().logp(Level.WARNING,
					WorldManager.class.getName(), "WorldManager", e.toString(),
					e);
		}
	}

	public void addTask(Task<Body, World> task) {
		this.tasks.push(task);
	}

	public void render(float delta) {
		if (null != world) {
			this.applyToBody();
			world.step(delta, 3, 3);
			world.clearForces();
			while (!tasks.isEmpty()) {
				Task<Body, World> task = tasks.pop();
				task.onDestroyTask(world);
			}
		}
	}

	private TaskContainer<Task<Body, World>> tasks = null;

	private void initTasks() {
		if (null == tasks)
			this.tasks = new TaskQueueContainer<Task<Body, World>>();
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
		world.setContactListener(new CollisionHandler());
	}

	public World getWorld() {
		return this.world;
	}

	private void applyToBody() {
		Iterator<Body> iter = world.getBodies();
		while (iter.hasNext()) {
			Body body = iter.next();
			String bodyName = (String) body.getUserData();
			if ((bodyName != null) && (bodyName.startsWith("rubbish"))) {
				body.getFixtureList().get(0).setRestitution(0.0f);
				body.applyForceToCenter(body.getPosition().x / 10, -10);

			}
		}
	}

	private Vector2 startPosition = null;
	private Vector2 endPosition = null;

	@Override
	public boolean touchDown(int x, int y, int pointer, int button) {
		startPosition = new Vector2(x, y);
		return super.touchDown(x, y, pointer, button);
	}

	@Override
	public boolean touchUp(int x, int y, int pointer, int button) {
		endPosition = new Vector2(x, y);
		Vector2 tmp = endPosition.sub(startPosition);
		tmp.x *= 50;
		tmp.y *= 50;
		Iterator<Body> iter = world.getBodies();
		while (iter.hasNext()) {
			Body body = iter.next();
			String bodyName = (String) body.getUserData();
			if ((null != bodyName) && (bodyName.startsWith("art"))) {
				body.applyLinearImpulse(tmp, body.getWorldCenter());
				body.setLinearVelocity(tmp);
				body.setAngularDamping(500);
			}
		}
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
		this.world.dispose();
	}

	private class CollisionHandler extends CollisionAdapter {
		@Override
		public void postSolve(Contact contact, ContactImpulse impulse) {
			this.doPostSolve(contact, impulse);
		}

		private Set<Body> addedBodies = new HashSet<Body>();

		private void doPostSolve(Contact contact, ContactImpulse impulse) {

			Fixture fixtureA = contact.getFixtureA();
			Fixture fixtureB = contact.getFixtureB();
			if ((null != fixtureA) && (null != fixtureB)) {
				Body bodyA = fixtureA.getBody();
				Body bodyB = fixtureB.getBody();
				if ((null != bodyA) && (null != bodyB)) {
					String bodyAName = (String) bodyA.getUserData();// 被撞的body
					String bodyBName = (String) bodyB.getUserData();// 主动撞的body
					if (bodyBName != null) {
						if ((null != bodyAName)
								&& (bodyAName.startsWith("artificial"))) {
							if (!bodyBName.startsWith("bottom")) {
								SlideSound.getInstance().play();
								if (!this.addedBodies.contains(bodyB)) {
									addTask(new DestroyBodyTask(bodyB));
									this.addedBodies.add(bodyB);
								}
							}
						}
					}
				}
			}
		}
	}
}