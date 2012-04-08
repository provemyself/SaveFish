package com.savefish.logical;

/********************************
 * Description: 该类实现了接口
 *              ContactFilter
 * Author     : 王志伟
 * Date       : 2012/03/09
 *******************************/

import com.badlogic.gdx.physics.box2d.ContactFilter;
import com.badlogic.gdx.physics.box2d.Fixture;

public class CollisionFilter implements ContactFilter {

	@Override
	public boolean shouldCollide(Fixture fixtureA, Fixture fixtureB) {
		return false;
	}

}
