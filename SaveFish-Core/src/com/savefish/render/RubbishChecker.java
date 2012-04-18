package com.savefish.render;

public class RubbishChecker {

	/**
	 * @description 判断是否是圆形刚体垃圾
	 * @param userData
	 * @return
	 */
	public static boolean isCircleRubbish(String userData) {
		if ((null != userData) && (userData.startsWith("c_")))
			return true;
		else
			return false;
	}

	/**
	 * @description 判断是否是多边形垃圾
	 * @param userData
	 * @return
	 */
	public static boolean isPolygonRubbish(String userData) {
		if ((null != userData) && (userData.startsWith("p_")))
			return true;
		else
			return false;
	}

	/**
	 * @description 判断是否是垃圾
	 * @param userData
	 * @return
	 */
	public static boolean isRubbish(String userData) {
		return isCircleRubbish(userData) || isPolygonRubbish(userData);
	}
}
