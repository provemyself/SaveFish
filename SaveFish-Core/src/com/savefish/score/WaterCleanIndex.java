package com.savefish.score;

/********************************
 * Description: 该类代表水清澈程度
 * Author     : 王志伟
 * Date       : 2012/04/01
 *******************************/
public class WaterCleanIndex {
	private int initialIndex;
	private int boundaryIndex;

	public WaterCleanIndex(int level) {
		this.initialIndex = 600 + (level - 1) * 300;
		this.boundaryIndex = 400 + (level - 1) * 200;
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
