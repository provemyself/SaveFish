package com.savefish.util;

/********************************
 * Description: 该类将物理世界中Body
 *              坐标系转为屏幕绘制坐标
 * Author     : 王志伟
 * Date       : 2012/03/08
 *******************************/

import com.badlogic.gdx.math.Vector2;
import com.savefish.constant.Constant;

public class WorldRenderHelper {

	/**
	 * @description 将物理世界坐标转为绘制坐标
	 * @param x
	 * @param y
	 * @return 位置向量
	 */
	public static Vector2 toRenderCoordinate(float x, float y) {
		return new Vector2(
				(x * Constant.physics.RATE + Constant.screen.SCREEN_HALF_WIDTH),
				y * Constant.physics.RATE);
	}

	/**
	 * @description 将物理世界坐标转为绘制坐标
	 * @param source
	 * @return 位置向量
	 */
	public static Vector2 toRenderCoordinate(Vector2 source) {
		return new Vector2(
				(source.x * Constant.physics.RATE + Constant.screen.SCREEN_HALF_WIDTH),
				source.y * Constant.physics.RATE);
	}

	/**
	 * @description 将绘制坐标转为物理世界坐标
	 * @param x
	 * @param y
	 * @return 位置向量
	 */
	public static Vector2 toWorldCoordinate(float x, float y) {
		return new Vector2((x - Constant.screen.SCREEN_HALF_WIDTH)
				/ Constant.physics.RATE, y / Constant.physics.RATE);
	}

	/**
	 * @description 将绘制坐标转为物理世界坐标
	 * @param source
	 * @return 位置向量
	 */
	public static Vector2 toWorldCoordinate(Vector2 source) {
		return new Vector2((source.x - Constant.screen.SCREEN_HALF_WIDTH)
				/ Constant.physics.RATE, source.y / Constant.physics.RATE);
	}
}
