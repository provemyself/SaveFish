package com.savefish.pointsystem;

/********************************
 * Description: 该类是预防关卡分数记录
 *  Author : 王志伟
 *  Date : 2012/04/01
 *******************************/

public class PreventScoreRecord extends ScoreRecord {

	/**
	 * 
	 * @param dateTime
	 *            游戏日期
	 * @param crossScore
	 *            过关得分
	 * @param crossWaterIndex
	 *            过关时清澈指数
	 */
	public PreventScoreRecord(String dateTime, int crossScore,
			int crossWaterIndex, GameLevel gameLevel) {
		super(dateTime, crossScore, crossWaterIndex, gameLevel);
	}

}
