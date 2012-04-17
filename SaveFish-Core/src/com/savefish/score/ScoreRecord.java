package com.savefish.score;

/********************************
 * Description: 该类用于保存过关分数 Author : 王志伟 Date : 2012/04/01
 *******************************/

public abstract class ScoreRecord {
	private String dateTime = null;// 过关的时间
	private int crossScore;// 过关分数
	private int crossCleanIndex;// 过关时河水清澈指数

	public ScoreRecord(String dateTime, int crossScore, int crossWaterIndex) {
		this.dateTime = dateTime;
		this.crossScore = crossScore;
		this.crossCleanIndex = crossWaterIndex;
	}

	/**
	 * @description 获取过关时间
	 * @return
	 */
	public String getDateTime() {
		return this.dateTime;
	}

	/**
	 * @description 获取过关时分数
	 * @return
	 */
	public int getCrossScore() {
		return this.crossScore;
	}

	/**
	 * @description 获取过关河水清澈指数
	 * @return
	 */
	public int getCrossCleanIndex() {
		return this.crossCleanIndex;
	}
}
