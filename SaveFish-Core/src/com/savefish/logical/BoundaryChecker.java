package com.savefish.logical;

/********************************
 * Description: 该类负责检查参数body 是否是边界 Author : 王志伟 Date : 2012/04/10
 *******************************/
public class BoundaryChecker implements Checkable {

	/**
	 * @description 该类检查是否是屏幕边界body
	 * @param userData
	 *            物理世界Body的名字
	 * @return 是任何 边界Body返回true，否则返回false
	 */
	public static boolean isScreenBoundary(String userData) {

		boolean screenLeft = isScreenLeft(userData);
		boolean screenRight = isScreenRight(userData);
		boolean top = isTop(userData);
		boolean middle = isMiddle(userData);
		boolean bottom = isBottom(userData);

		return screenLeft || screenRight || top || middle || bottom;
	}

	public static boolean isWorldBoundary(String userData) {
		boolean worldLeft = isWorldLeft(userData);
		boolean worldRight = isWorldRight(userData);

		return worldLeft || worldRight;
	}

	/**
	 * @description 检查是否是屏幕左边界
	 * @param userData
	 *            body的名字
	 * @return
	 */
	public static boolean isScreenLeft(String userData) {
		if ((null != userData) && userData.startsWith("screen_left"))
			return true;
		else
			return false;
	}

	/**
	 * @description 检查是否是物理世界左边界
	 * @param userData
	 *            body的名字
	 * @return
	 */
	public static boolean isWorldLeft(String userData) {
		if ((null != userData) && userData.startsWith("world_left"))
			return true;
		else
			return false;
	}

	/**
	 * @description 检查是否是屏幕右边界
	 * @param userData
	 * @return
	 */
	public static boolean isScreenRight(String userData) {
		if ((null != userData) && userData.startsWith("screen_right"))
			return true;
		else
			return false;
	}

	/**
	 * @description 检查是否是物理世界右边界
	 * @param userData
	 * @return
	 */
	public static boolean isWorldRight(String userData) {
		if ((null != userData) && userData.startsWith("world_right"))
			return true;
		else
			return false;
	}

	/**
	 * @description 检查是否是下边界
	 * @param userData
	 * @return
	 */
	public static boolean isBottom(String userData) {
		if ((null != userData) && userData.startsWith("bottom"))
			return true;
		else
			return false;
	}

	/**
	 * @description 检查是否是中边界
	 * @param userData
	 * @return
	 */
	public static boolean isMiddle(String userData) {
		if ((null != userData) && userData.startsWith("middle"))
			return true;
		else
			return false;
	}

	/**
	 * @description 检查是否是上边界
	 * @param userData
	 * @return
	 */
	public static boolean isTop(String userData) {
		if ((null != userData) && userData.startsWith("top"))
			return true;
		else
			return false;
	}
}
