package com.savefish.logical;

/********************************
 * Description: 该类是碰撞处理器
 * Author     : 王志伟
 * Date       : 2012/04/10
 *******************************/

import java.util.HashSet;
import java.util.Set;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.savefish.render.Direction;
import com.savefish.service.EatSound;
import com.savefish.task.DestroyBodyTask;
import com.savefish.task.MoveBodyTask;
import com.savefish.task.TaskContainer;

public class CollisionHandler extends CollisionAdapter {

	/**
	 * @description 工厂方法负责创建对象
	 * @param destroyTasks
	 *            任务容器
	 * @param world
	 *            物理世界对象
	 * @return
	 */
	public static CollisionHandler createCollisionHandler(
			TaskContainer<DestroyBodyTask> destroyTasks,
			TaskContainer<MoveBodyTask> moveTasks) {
		return new CollisionHandler(destroyTasks, moveTasks);
	}

	private TaskContainer<DestroyBodyTask> destroyTasks = null;
	private TaskContainer<MoveBodyTask> moveTasks = null;

	private Set<Body> killedRubbishes = null;
	private Set<Body> movedNatureFish = null;

	private CollisionHandler(TaskContainer<DestroyBodyTask> destroyTasks,
			TaskContainer<MoveBodyTask> moveTasks) {
		super();
		this.destroyTasks = destroyTasks;
		this.moveTasks = moveTasks;
		this.killedRubbishes = new HashSet<Body>();
		this.movedNatureFish = new HashSet<Body>();
	}

	@Override
	public void postSolve(Contact contact, ContactImpulse impulse) {
		this.doPostSolveArtificial(contact, impulse);
		this.doPostSolveNature(contact, impulse);
		super.postSolve(contact, impulse);
	}

	/**
	 * @description 检测人工鱼与垃圾的碰撞
	 * @param contact
	 * @param impulse
	 */
	private void doPostSolveArtificial(Contact contact, ContactImpulse impulse) {
		Fixture fixtureA = contact.getFixtureA();
		Fixture fixtureB = contact.getFixtureB();
		if ((null != fixtureA) && (null != fixtureB)) {
			Body bodyA = fixtureA.getBody();
			Body bodyB = fixtureB.getBody();
			if ((null != bodyA) && (null != bodyB)) {
				String bodyAName = (String) bodyA.getUserData();
				String bodyBName = (String) bodyB.getUserData();
				if (bodyBName != null) {
					if (FishChecker.isArtificial(bodyAName)
							&& !BoundaryChecker.isScreenBoundary(bodyBName)
							&& !this.killedRubbishes.contains(bodyB)) {
						EatSound.getInstance().play();
						addDestroyTask(new DestroyBodyTask(bodyB));
						this.killedRubbishes.add(bodyB);
					}
				}
			}
		}
	}

	/**
	 * @description 检测天然鱼与边界的碰撞
	 * @param contact
	 * @param impulse
	 */
	private void doPostSolveNature(Contact contact, ContactImpulse impulse) {
		Fixture fixtureA = contact.getFixtureA();
		Fixture fixtureB = contact.getFixtureB();
		if ((null != fixtureA) && (null != fixtureB)) {
			Body bodyA = fixtureA.getBody();
			Body bodyB = fixtureB.getBody();
			if ((null != bodyA) && (null != bodyB)) {
				String bodyAName = (String) bodyA.getUserData();
				String bodyBName = (String) bodyB.getUserData();
				if (BoundaryChecker.isWorldRight(bodyAName)
						&& FishChecker.isNatureRight(bodyBName)
						&& !movedNatureFish.contains(bodyB)) {
					addMoveTask(new MoveBodyTask(bodyB, Direction.MOVE_LEFT));
				} else if (BoundaryChecker.isWorldLeft(bodyAName)
						&& FishChecker.isNatureLeft(bodyBName)
						&& !movedNatureFish.contains(bodyB)) {
					addMoveTask(new MoveBodyTask(bodyB, Direction.MOVE_RIGHT));
				}
			}
		}
	}

	/**
	 * @description 添加删除Body任务
	 * @param task
	 */
	private void addDestroyTask(DestroyBodyTask task) {
		this.destroyTasks.push(task);
	}

	/**
	 * @description 添加移动Body的任务
	 * @param task
	 */
	private void addMoveTask(MoveBodyTask task) {
		this.moveTasks.push(task);
	}
}
