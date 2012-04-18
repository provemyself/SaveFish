package com.savefish.rule;

/********************************
 * Description: 该类是河水清澈指数字典 
 * Author : 王志伟
 *  Date : 2012/04/01
 *******************************/

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

	private static class WaterCleanIndex {
		private int initialIndex;
		private int boundaryIndex;

		/**
		 * @description 根据关卡确定河水的初始清澈指数
		 * @param level
		 */
		public WaterCleanIndex(int level) {
			this.initialIndex = 600 + (level - 1) * 300;
			this.boundaryIndex = 400 + (level - 1) * 200;
		}

		/**
		 * @description 获取初始清澈指数
		 * @return
		 */
		@SuppressWarnings("unused")
		public int getInitialIndex() {
			return this.initialIndex;
		}

		/**
		 * @description 获取边界清澈指数
		 * @return
		 */
		@SuppressWarnings("unused")
		public int getBoundaryIndex() {
			return this.boundaryIndex;
		}
	}
}
