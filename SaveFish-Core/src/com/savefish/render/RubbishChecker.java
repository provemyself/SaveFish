package com.savefish.render;

public class RubbishChecker {

	public static boolean isCircleRubbish(String userData) {
		if ((null != userData) && (userData.startsWith("rubbish_circle")))
			return true;
		else
			return false;
	}

	public static boolean isPolygonRubbish(String usersData) {
		if ((null != usersData) && (usersData.startsWith("rubbish_polygon")))
			return true;
		else
			return false;
	}

}
