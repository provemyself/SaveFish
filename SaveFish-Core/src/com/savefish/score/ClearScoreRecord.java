package com.savefish.score;

import java.util.Date;

public class ClearScoreRecord extends ScoreRecord {

	private int time;// 清理垃圾所用时间

	public ClearScoreRecord(Date date, int crossScore, int crossWaterIndex,
			int time) {
		super(date, crossScore, crossWaterIndex);
		this.time = time;
	}

	public int getTime() {
		return this.time;
	}

}
