package com.savefish.task;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.savefish.logical.ForceController;
import com.savefish.pointsystem.CurrentLevel;
import com.savefish.render.Direction;
import com.savefish.util.RandomHelper;

public class MoveBodyTask extends MoveBodyAdapter {

	private Body body = null;
	private Direction direction = null;

	public MoveBodyTask(Body body, Direction direction) {
		this.body = body;
		this.direction = direction;
	}

	@Override
	public Body onMoveBody() {

		if ((null != body) && (null != direction)) {

			if (direction == Direction.MOVE_LEFT) {
				if (1 == CurrentLevel.level.getBig()) {
					body.setTransform(new Vector2(0, RandomHelper.createInstance()
							.nextInt(16)), body.getAngle());
				} else {
					body.setTransform(new Vector2(0, RandomHelper.createInstance()
							.nextInt(32)), body.getAngle());
				}
				ForceController.applySomeNatureLeft(body);
			} else if (direction == Direction.MOVE_RIGHT) {
				if (1 == CurrentLevel.level.getBig()) {
					body.setTransform(new Vector2(52, RandomHelper
							.createInstance().nextInt(16)), body.getAngle());
				} else {
					body.setTransform(new Vector2(52, RandomHelper
							.createInstance().nextInt(32)), body.getAngle());
				}
				ForceController.applySomeNatureRight(body);
			}
		}
		return this.body;
	}

}
