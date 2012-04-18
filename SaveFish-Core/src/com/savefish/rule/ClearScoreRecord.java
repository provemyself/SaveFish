package com.savefish.rule;

/********************************
 * Description: 该类是治理关卡分数记录 
 * Author : 王志伟 
 * Date : 2012/04/01
 *******************************/

public class ClearScoreRecord extends ScoreRecord {

	private int duration;

	public ClearScoreRecord(String dateTime, int crossScore,
			int crossWaterIndex, int duration) {
		super(dateTime, crossScore, crossWaterIndex);
		this.duration = duration;
	}

	/**
	 * @description 获取过关时间
	 * @return
	 */
	public int getDuration() {
		return this.duration;
	}

}
