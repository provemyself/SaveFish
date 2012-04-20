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
import com.savefish.render.FishChecker;
import com.savefish.render.RubbishChecker;
import com.savefish.render.StoneChecker;
import com.savefish.service.EatSound;
import com.savefish.task.DestroyBodyTask;
import com.savefish.task.FilterBodyTask;
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
			TaskContainer<MoveBodyTask> moveTasks,
			TaskContainer<FilterBodyTask> filterTasks) {
		return new CollisionHandler(destroyTasks, moveTasks, filterTasks);
	}

	private TaskContainer<DestroyBodyTask> destroyTasks = null;
	private TaskContainer<MoveBodyTask> moveTasks = null;
	private TaskContainer<FilterBodyTask> filterTasks = null;

	private Set<Body> killedRubbishes = null;
	@SuppressWarnings("unused")
	private Set<Body> movedNatureFish = null;

	private Set<Body> filteredRubbish = null;

	private CollisionHandler(TaskContainer<DestroyBodyTask> destroyTasks,
			TaskContainer<MoveBodyTask> moveTasks,
			TaskContainer<FilterBodyTask> filterTasks) {
		super();
		this.destroyTasks = destroyTasks;
		this.moveTasks = moveTasks;
		this.filterTasks = filterTasks;
		this.killedRubbishes = new HashSet<Body>();
		this.movedNatureFish = new HashSet<Body>();
		this.filteredRubbish = new HashSet<Body>();
	}

	@Override
	public void postSolve(Contact contact, ContactImpulse impulse) {
		this.doPostSolve(contact, impulse);
		super.postSolve(contact, impulse);
	}

	/**
	 * @description 检测人工鱼与垃圾的碰撞
	 * @param contact
	 * @param impulse
	 */
	private void doPostSolve(Contact contact, ContactImpulse impulse) {
		Fixture fixtureA = contact.getFixtureA();
		Fixture fixtureB = contact.getFixtureB();
		if ((null != fixtureA) && (null != fixtureB)) {
			Body bodyA = fixtureA.getBody();
			Body bodyB = fixtureB.getBody();
			if ((null != bodyA) && (null != bodyB)) {
				String bodyAName = (String) bodyA.getUserData();
				String bodyBName = (String) bodyB.getUserData();
				if ((null != bodyAName) && (null != bodyBName)) {
					this.destroyRubbish(bodyA, bodyAName, bodyB, bodyBName);
					this.moveNatureFish(bodyA, bodyAName, bodyB, bodyBName);
					this.filterRubbish(bodyA, bodyAName, bodyB, bodyBName);
				}
			}
		}
	}

	/**
	 * @description 人工鱼吃掉垃圾
	 * @param bodyA
	 * @param bodyAName
	 * @param bodyB
	 * @param bodyBName
	 */
	private void destroyRubbish(Body bodyA, String bodyAName, Body bodyB,
			String bodyBName) {
		if (FishChecker.isArtificial(bodyAName)
				&& !BoundaryChecker.isScreenBoundary(bodyBName)
				&& !StoneChecker.isStone(bodyBName)
				&& !killedRubbishes.contains(bodyB)) {
			EatSound.createInstance().play();
			addDestroyTask(new DestroyBodyTask(bodyB));
			System.out.println(bodyBName);
			killedRubbishes.add(bodyB);
		} else if (FishChecker.isArtificial(bodyBName)
				&& !BoundaryChecker.isScreenBoundary(bodyAName)
				&& !StoneChecker.isStone(bodyAName)
				&& !killedRubbishes.contains(bodyA)) {
			EatSound.createInstance().play();
			addDestroyTask(new DestroyBodyTask(bodyA));
			System.out.println(bodyAName);
			killedRubbishes.add(bodyA);
		}
	}

	/**
	 * @description 循环随机对天然鱼施加力
	 * @param bodyA
	 * @param bodyAName
	 * @param bodyB
	 * @param bodyBName
	 */
	private void moveNatureFish(Body bodyA, String bodyAName, Body bodyB,
			String bodyBName) {
		if (BoundaryChecker.isWorldRight(bodyAName)
				&& FishChecker.isNatureRight(bodyBName)) {
			addMoveTask(new MoveBodyTask(bodyB, Direction.MOVE_LEFT));
		} else if (BoundaryChecker.isWorldLeft(bodyAName)
				&& FishChecker.isNatureLeft(bodyBName)) {
			addMoveTask(new MoveBodyTask(bodyB, Direction.MOVE_RIGHT));
		}
	}

	/**
	 * @description 过滤掉碰到地面的垃圾
	 * @param bodyA
	 * @param bodyAName
	 * @param bodyB
	 * @param bodyBName
	 */
	private void filterRubbish(Body bodyA, String bodyAName, Body bodyB,
			String bodyBName) {
		if (BoundaryChecker.isBottom(bodyAName)
				&& RubbishChecker.isRubbish(bodyBName)
				&& !filteredRubbish.contains(bodyB)) {
			this.addFilterTask(new FilterBodyTask(bodyB));
			filteredRubbish.add(bodyB);
		} else if (BoundaryChecker.isBottom(bodyBName)
				&& RubbishChecker.isRubbish(bodyAName)
				&& !filteredRubbish.contains(bodyA)) {
			this.addFilterTask(new FilterBodyTask(bodyA));
			filteredRubbish.add(bodyA);
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

	/**
	 * @description 添加过滤Body的任务
	 * 
	 * @param task
	 */
	private void addFilterTask(FilterBodyTask task) {
		this.filterTasks.push(task);
	}
}
