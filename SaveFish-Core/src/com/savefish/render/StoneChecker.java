package com.savefish.render;

public class StoneChecker {
	/**
	 * @description 判断是否是石头
	 * @param userData
	 * @return
	 */
	public static boolean isStone(String userData) {
		if ((null != userData) && (userData.contains("stone")))
			return true;
		else
			return false;
	}

	/**
	 * @description 判断是否是动态的石头
	 * @param userData
	 * @return
	 */
	public static boolean isDynamicStone(String userData) {
		if ((null != userData) && (userData.startsWith("d_stone")))
			return true;
		else
			return false;
	}

	/**
	 * @description 判断是否是静态的石头
	 * @param userData
	 * @return
	 */
	public static boolean isStillStone(String userData) {
		if ((null != userData) && (userData.startsWith("s_stone")))
			return true;
		else
			return false;
	}
}
