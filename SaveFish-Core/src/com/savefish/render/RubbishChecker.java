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

	/**
	 * @description 判断是否是垃圾袋（白色污染）
	 * @param userdata
	 * @return
	 */
	public static boolean isRubbishBag(String userData) {
		if ((null != userData) && (userData.contains("bag")))
			return true;
		else
			return false;
	}

	/**
	 * @description 判断是否是温度计（重金属汞的污染）
	 * @param userdata
	 * @return
	 */
	public static boolean isThermograph(String userData) {
		if ((null != userData) && (userData.contains("thermograph")))
			return true;
		else
			return false;
	}
	
	/**
	 * @description 判断是否是放射性物质污染
	 * @param userData
	 * @return
	 */
	public static boolean isRadioactive(String userData){
		if ((null != userData) && (userData.contains("rm")))
			return true;
		else
			return false;
	}
	
	/**
	 * @description 判断是否是电池污染
	 * @param userData
	 * @return
	 */
	public static boolean isElectricBattery(String userData){
		if ((null != userData) && (userData.contains("eb")))
			return true;
		else
			return false;
	}
	
	/**
	 * @description 判断是否是农药污染
	 * @param userData
	 * @return
	 */
	public static boolean isPesticide(String userData){
		if ((null != userData) && (userData.contains("pesticide")))
			return true;
		else
			return false;
	}
}
