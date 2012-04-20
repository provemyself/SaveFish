package com.savefish.storage;

import com.savefish.pointsystem.GameScoreRecord;

public class CurrentCrossData {
	public static CrossData getCurrentRecord() {
		String dateTime = GameScoreRecord.currentLevelScore.getDateTime();
		int crossScore = GameScoreRecord.currentLevelScore.getCrossScore();
		int cleanIndex = GameScoreRecord.currentLevelScore.getCrossCleanIndex();
		return CrossData.createInstance(dateTime, crossScore, cleanIndex);
	}
}
