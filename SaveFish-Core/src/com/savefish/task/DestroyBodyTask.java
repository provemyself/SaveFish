package com.savefish.task;

import java.util.logging.Level;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.savefish.util.GreenLogger;

public class DestroyBodyTask implements Task<Body, World> {

	private Body body = null;
	
	public Body getBody(){
		return this.body;
	}

	public DestroyBodyTask(Body body) {
		this.body = body;
	}

	@Override
	public Body onDestroyTask(World world) {
		if ((null != world) && (body != null))
			try {
				world.destroyBody(body);
			} catch (Exception e) {
				GreenLogger.getInstance().logp(Level.WARNING,
						DestroyBodyTask.class.getName(), "onDeleteTask",
						e.toString(), e);
			}

		return this.body;
	}
}
