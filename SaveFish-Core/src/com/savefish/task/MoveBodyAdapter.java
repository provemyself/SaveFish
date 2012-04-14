package com.savefish.task;

import com.badlogic.gdx.physics.box2d.Body;
import com.savefish.render.Direction;

public abstract class MoveBodyAdapter implements Task<Body, Direction> {
	@Override
	public Body onProcess(Direction arg) {
		return null;
	}

	public abstract Body onMoveBody();
}
