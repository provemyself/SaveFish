package com.savefish.render;

/********************************
 * Description: 该类检查给定的body的 是否为特定的Fish Author : 王志伟 Date : 2012/03/08
 *******************************/

public class FishChecker implements Checkable {

	/**
	 * @description 判断是否为人工鱼
	 * @param userData
	 * @return
	 */
	public static boolean isArtificial(String userData) {
		if ((null != userData) && userData.startsWith("artifi"))
			return true;
		else
			return false;
	}

	/**
	 * @description 判断是否为向右游动天然鱼
	 * @param userData
	 * @return
	 */
	public static boolean isNatureRight(String userData) {
		if ((null != userData) && userData.startsWith("r_nature"))
			return true;
		else
			return false;
	}

	/**
	 * @description 判断是否为向左移动天然鱼
	 * @param userData
	 * @return
	 */
	public static boolean isNatureLeft(String userData) {
		if ((null != userData) && userData.startsWith("l_nature"))
			return true;
		else
			return false;
	}

}
