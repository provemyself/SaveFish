package com.savefish.score;

import java.util.Date;

public abstract class ScoreRecord {
	private Date date = null;// 过关的时间
	private int crossScore;// 过关分数
	private int crossWaterIndex;// 过关时河水清澈指数

	public ScoreRecord(Date date, int crossScore, int crossWaterIndex) {
		this.date = date;
		this.crossScore = crossScore;
		this.crossWaterIndex = crossWaterIndex;
	}

	/**
	 * @description 获取过关时间
	 * @return
	 */
	public Date getDate() {
		return this.date;
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
	public int getCrossWaterIndex() {
		return this.crossWaterIndex;
	}
}
