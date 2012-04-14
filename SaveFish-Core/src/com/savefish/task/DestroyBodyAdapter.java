package com.savefish.task;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;

public abstract class DestroyBodyAdapter implements Task<Body, World> {

	@Override
	public Body onProcess(World arg) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public abstract Body onDestroy(World world); 
}
