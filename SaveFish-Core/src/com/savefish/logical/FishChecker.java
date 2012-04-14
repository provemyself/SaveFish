package com.savefish.logical;

/********************************
 * Description: 该类检查给定的body的 
 * 				是否为特定的Fish 
 * Author : 	王志伟 
 * Date : 		2012/03/08
 *******************************/

public class FishChecker implements Checkable {

	/**
	 * @description 检查是否为人工鱼
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
	 * @description 检查是否为天然鱼
	 * @param userData
	 * @return
	 */
	public static boolean isNatureRight(String userData) {
		if ((null != userData) && userData.startsWith("rnature"))
			return true;
		else
			return false;
	}
	
	public static boolean isNatureLeft(String userData) {
		if ((null != userData) && userData.startsWith("lnature"))
			return true;
		else
			return false;
	}

}
