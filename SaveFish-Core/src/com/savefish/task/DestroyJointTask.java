package com.savefish.task;

import java.util.logging.Level;

import com.badlogic.gdx.physics.box2d.Joint;
import com.badlogic.gdx.physics.box2d.World;
import com.savefish.util.GreenLogger;

public class DestroyJointTask implements Task<Joint, World> {

	private Joint joint = null;

	public DestroyJointTask(Joint joint) {
		this.joint = joint;
	}

	@Override
	public Joint onDestroyTask(World world) {
		if ((null != world) && (null != joint)) {
			try {
				world.destroyJoint(joint);
			} catch (Exception e) {
				GreenLogger.getInstance().logp(Level.WARNING,
						DestroyJointTask.class.getName(), "onDeleteTask",
						e.toString(), e);
			}
		}

		return null;
	}

}
