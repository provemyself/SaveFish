package com.savefish.logical;

/********************************
 * Description: 该类是物理世界中的力控制器
 *              负责给刚体施加力
 * Author     : 王志伟
 * Date       : 2012/04/10
 *******************************/

import java.util.Iterator;
import java.util.logging.Level;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.savefish.render.RubbishChecker;
import com.savefish.util.GreenLogger;
import com.savefish.util.RandomHelper;

public class ForceController {

	/**
	 * @description 给物理世界中的垃圾施加力，使其下落
	 * @param world
	 */
	public static void applyToRubbish(World world) {
		Iterator<Body> iter = world.getBodies();
		while (iter.hasNext()) {
			Body body = iter.next();
			String bodyName = (String) body.getUserData();
			if (RubbishChecker.isRubbish(bodyName)) {
				Vector2 force = world.getGravity();
				force.x *= -RandomHelper.getInstance().nextInt(
						(int) (body.getMass() / 9.0f));
				force.y *= RandomHelper.getInstance().nextInt(
						(int) (body.getMass() / 9.0f));
				body.applyForceToCenter(force);
			}
		}
	}

	/**
	 * @description 给全部的物理世界中的天然鱼施加力
	 * @param world
	 */
	public static void applyWholeNature(World world) {
		Iterator<Body> iter = world.getBodies();
		while (iter.hasNext()) {
			Body body = iter.next();
			String bodyName = (String) body.getUserData();
			Vector2 vec = body.getLinearVelocity();
			if ((null != bodyName)) {
				if (bodyName.startsWith("l_nature"))
					vec.x = -2;
				else if (bodyName.startsWith("r_nature"))
					vec.x = 2;
				body.setLinearVelocity(vec);
			}
		}
	}

	/**
	 * @description 给某一个特定的鱼施加向左的力
	 * @param body
	 */
	public static void applySomeNatureLeft(Body body) {
		GreenLogger.getInstance().logp(Level.SEVERE,
				ForceController.class.getName(), "applySomeNatureLeft",
				"called!");

		Vector2 vec = body.getLinearVelocity();
		vec.x = -2;
		body.setLinearVelocity(vec);
	}

	/**
	 * @description 给某一个特定的天然鱼施加向右的力
	 * @param body
	 */
	public static void applySomeNatureRight(Body body) {
		GreenLogger.getInstance().logp(Level.SEVERE,
				ForceController.class.getName(), "applySomeNatureRight",
				"called!");

		Vector2 vec = body.getLinearVelocity();
		vec.x = 2;
		body.setLinearVelocity(vec);
	}
}
