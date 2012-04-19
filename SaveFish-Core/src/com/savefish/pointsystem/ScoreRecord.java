package com.savefish.pointsystem;

import com.savefish.util.DateTimeHelper;

/********************************
 * Description: 该类用于保存过关分数 Author : 王志伟 Date : 2012/04/01
 *******************************/

public class ScoreRecord {
	private String dateTime = null;// 过关日期
	private int crossScore;// 过关分数
	private int crossCleanIndex;// 过关时河水清澈指数
	private GameLevel gameLevel;// 所属关卡

	public ScoreRecord() {
		this.gameLevel = GameLevel.createInstance(1, 1);
		this.dateTime = DateTimeHelper.getDate();
		this.crossScore = 0;
		this.crossCleanIndex = WaterDictionary.getInitialWaterIndex(gameLevel);
	}

	/**
	 * 
	 * @param dateTime
	 * @param crossScore
	 * @param crossWaterIndex
	 */
	public ScoreRecord(GameLevel gameLevel) {
		this.gameLevel = gameLevel;
		this.dateTime = DateTimeHelper.getDate();
		this.crossScore = 0;
		this.crossCleanIndex = WaterDictionary.getInitialWaterIndex(gameLevel);
	}

	/**
	 * @description 获取过关时间
	 * @return
	 */
	public String getDateTime() {
		return this.dateTime;
	}

	/**
	 * @description 设置过关分数
	 * @param score
	 */
	public void setCrossScore(int score) {
		System.out.println("加分： " + score);
		this.gameLevel.decreaseCount();
		System.out.println("当前剩下垃圾个数： " + this.gameLevel.getCount());
		this.crossScore += score;
	}

	/**
	 * @description 获取过关时分数
	 * @return
	 */
	public int getCrossScore() {
		return this.crossScore;
	}

	public void setCrossCleanIndex(int index) {
		this.crossCleanIndex += index;
	}

	/**
	 * @description 获取过关河水清澈指数
	 * @return
	 */
	public int getCrossCleanIndex() {
		return this.crossCleanIndex;
	}

	/**
	 * @description 返回当前游戏所属关卡
	 * @return
	 */
	public GameLevel getGameLevel() {
		return this.gameLevel;
	}
}
