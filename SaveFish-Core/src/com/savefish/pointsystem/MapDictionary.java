package com.savefish.pointsystem;

import java.util.HashMap;

import com.savefish.constant.Constant;

public class MapDictionary {
	private static HashMap<GameLevel, String> dict = new HashMap<GameLevel, String>();
	static {
		dict.put(GameLevel.createInstance(1, 1), Constant.map.PREVENT_FIRST);
		dict.put(GameLevel.createInstance(1, 2), Constant.map.PREVENT_SECOND);
		dict.put(GameLevel.createInstance(1, 3), Constant.map.PREVENT_THIRD);
		dict.put(GameLevel.createInstance(1, 4), Constant.map.PREVENT_FOURTH);
		dict.put(GameLevel.createInstance(1, 5), Constant.map.PREVETN_FIFTH);
		dict.put(GameLevel.createInstance(1, 6), Constant.map.PREVENT_SIXTH);

		dict.put(GameLevel.createInstance(2, 1), Constant.map.CLEAR_FIRST);
		dict.put(GameLevel.createInstance(2, 2), Constant.map.CLEAR_SECOND);
		dict.put(GameLevel.createInstance(2, 3), Constant.map.CLEAR_THIRD);
		dict.put(GameLevel.createInstance(2, 4), Constant.map.CLEAR_FOURTH);
		dict.put(GameLevel.createInstance(2, 5), Constant.map.CLEAR_FIFTH);
		dict.put(GameLevel.createInstance(2, 6), Constant.map.CLEAR_SIXTH);
	}

	/**
	 * @description 根据关卡获取地图
	 * @param level
	 * @return
	 */
	public static String getMap(GameLevel level) {
		return dict.get(level);
	}
}
