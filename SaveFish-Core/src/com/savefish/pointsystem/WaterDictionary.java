package com.savefish.pointsystem;

/********************************
 * Description: 该类是河水清澈指数字典 
 * Author : 王志伟
 *  Date : 2012/04/01
 *******************************/

import java.util.HashMap;

public class WaterDictionary {
	private HashMap<GameLevel, WaterCleanIndex> waterMap = new HashMap<GameLevel, WaterCleanIndex>();

	public static WaterDictionary createInstance() {
		return new WaterDictionary();
	}

	private WaterDictionary() {
		waterMap.put(GameLevel.createInstance(1, 1),
				WaterCleanIndex.createInstance(1200, 800));
		waterMap.put(GameLevel.createInstance(1, 2),
				WaterCleanIndex.createInstance(2100, 1500));
		waterMap.put(GameLevel.createInstance(1, 3),
				WaterCleanIndex.createInstance(3300, 2200));
		waterMap.put(GameLevel.createInstance(1, 4),
				WaterCleanIndex.createInstance(4500, 3000));
		waterMap.put(GameLevel.createInstance(1, 5),
				WaterCleanIndex.createInstance(5700, 3800));
		waterMap.put(GameLevel.createInstance(1, 6),
				WaterCleanIndex.createInstance(6000, 4000));
	}

	public int getInitialWaterIndex(GameLevel level) {
		WaterCleanIndex cleanIndex = waterMap.get(level);
		return cleanIndex.getBoundaryIndex();
	}

	public int getBoundaryIndex(GameLevel level) {
		WaterCleanIndex cleanIndex = waterMap.get(level);
		return cleanIndex.getBoundaryIndex();
	}
}
