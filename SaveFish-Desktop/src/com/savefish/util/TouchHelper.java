package com.savefish.util;

/********************************
 * Description: 该类将触摸事件捕捉到的
 *              坐标系转为屏幕绘制坐标
 * Author     : 王志伟
 * Date       : 2012/03/08
 *******************************/

import com.badlogic.gdx.math.Vector2;
import com.savefish.constant.Constants;

public class TouchHelper {
	/**
	 * @description 将触碰检测坐标转为绘制坐标
	 * @param x
	 * @param y
	 * @return 位置向量
	 */
	public static Vector2 toRenderCoordinate(float x, float y) {
		return new Vector2(x, Constants.screen.SCREEN_HEIGHT - y);
	}

	/**
	 * @description 将触碰检测坐标转为绘制坐标
	 * @param source
	 * @return 位置向量
	 */
	public static Vector2 toRenderCoordinate(Vector2 source) {
		return new Vector2(source.x, (Constants.screen.SCREEN_HEIGHT - source.y));
	}
}
