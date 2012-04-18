package com.savefish.score;

import java.util.HashMap;

public class WaterDictionary {
	private static HashMap<Integer, WaterCleanIndex> PreventWater = new HashMap<Integer, WaterCleanIndex>();

	static {
		PreventWater.put(1, new WaterCleanIndex(1));
		PreventWater.put(2, new WaterCleanIndex(2));
		PreventWater.put(3, new WaterCleanIndex(3));
		PreventWater.put(4, new WaterCleanIndex(4));
		PreventWater.put(5, new WaterCleanIndex(5));
		PreventWater.put(6, new WaterCleanIndex(6));
	}

	public static WaterCleanIndex getWaterIndex(Integer level) {
		return PreventWater.get(level);
	}
}
