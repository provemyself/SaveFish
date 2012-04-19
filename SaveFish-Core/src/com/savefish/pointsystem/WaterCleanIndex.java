package com.savefish.pointsystem;

public class WaterCleanIndex {
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