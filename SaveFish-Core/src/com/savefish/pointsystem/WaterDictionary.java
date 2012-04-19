package com.savefish.pointsystem;

/********************************
 * Description: 该类是河水清澈指数字典 
 * Author : 王志伟
 *  Date : 2012/04/01
 *******************************/

import java.util.HashMap;

public class WaterDictionary {
	private static HashMap<GameLevel, WaterCleanIndex> waterMap = new HashMap<GameLevel, WaterCleanIndex>();

	static {
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

	public static int getInitialWaterIndex(GameLevel level) {
		return waterMap.get(level).getInitialIndex();
	}

	public static int getBoundaryIndex(GameLevel level) {
		return waterMap.get(level).getBoundaryIndex();
	}

	private static class WaterCleanIndex {
		private int initialIndex;
		private int boundaryIndex;

		public static WaterCleanIndex createInstance(int initialIndex,
				int boundaryIndex) {
			return new WaterCleanIndex(initialIndex, boundaryIndex);
		}

		private WaterCleanIndex(int initialIndex, int boundaryIndex) {
			this.initialIndex = initialIndex;
			this.boundaryIndex = boundaryIndex;
		}

		/**
		 * @description 获取初始清澈指数
		 * @return
		 */
		public int getInitialIndex() {
			return this.initialIndex;
		}

		/**
		 * @description 获取边界清澈指数
		 * @return
		 */
		public int getBoundaryIndex() {
			return this.boundaryIndex;
		}
	}
}
