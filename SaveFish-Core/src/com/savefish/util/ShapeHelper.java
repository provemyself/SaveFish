package com.savefish.util;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.PolygonShape;

public class ShapeHelper {
	/**
	 * @description 该方法必须在检查shape字段值是否为空
	 * @return 返回宽和高的二维向量
	 */
	public static Vector2 getRectangleData(PolygonShape shape) {
		Vector2 vertex0 = new Vector2();
		Vector2 vertex2 = new Vector2();

		shape.getVertex(0, vertex0);
		shape.getVertex(2, vertex2);

		float width = Math.abs(vertex0.x - vertex2.x);
		float height = Math.abs(vertex0.y - vertex2.y);

		return new Vector2(width, height);
	}

	public static float getCircleData(CircleShape shape) {
		return shape.getRadius();
	}
}
