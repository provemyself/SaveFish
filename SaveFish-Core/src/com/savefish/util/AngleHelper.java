package com.savefish.util;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class AngleHelper {
	public static float computeDegree(Vector2 start, Vector2 end) {
		Vector2 startPosition = start.cpy();
		Vector2 endPosition = end.cpy();
		endPosition.sub(startPosition);
		float radian = MathUtils.atan2(endPosition.y, endPosition.x);
		float degree = radian * MathUtils.radiansToDegrees;
		return degree;
	}

	public static float computeRadian(Vector2 start, Vector2 end) {
		Vector2 startPosition = start.cpy();
		Vector2 endPosition = end.cpy();
		endPosition.sub(startPosition);
		float radian = MathUtils.atan2(endPosition.y, endPosition.x);
		return radian;
	}
}
