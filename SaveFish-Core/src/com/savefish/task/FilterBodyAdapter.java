package com.savefish.task;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;

public abstract class FilterBodyAdapter implements Task<Body, World> {

	@Override
	public Body onProcess(World world) {
		return null;
	}

	public abstract void onFilterBody();
}
