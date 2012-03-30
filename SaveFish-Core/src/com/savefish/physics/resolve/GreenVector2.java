package com.savefish.physics.resolve;

/********************************
 * Description: 该类是自定义的二位向量
 *              可以与 Vector2对应
 * Author     : 王志伟
 * Date       : 2012/03/12
 *******************************/

import com.badlogic.gdx.math.Vector2;

public class GreenVector2 {
	public float x;
	public float y;

	public GreenVector2() {
		this.x = 0;
		this.y = 0;
	}

	public GreenVector2(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public GreenVector2(GreenVector2 gv) {
		this.x = gv.x;
		this.y = gv.y;
	}

	public Vector2 toVector2() {
		return new Vector2(this.x, this.y);
	}
}
