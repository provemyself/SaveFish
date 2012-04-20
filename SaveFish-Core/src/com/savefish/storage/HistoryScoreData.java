package com.savefish.storage;

import com.google.gson.Gson;
import com.savefish.pointsystem.CurrentLevel;
import com.savefish.util.JsonHelper;

public class HistoryScoreData {
	public static CrossData getHistoryData() {
		Gson gson = new Gson();
		String jsonContext = JsonHelper.readFromJson(RecordFileDictionary
				.createInstance().getStoreFile(CurrentLevel.level));
		CrossData historyScoreData = gson
				.fromJson(jsonContext, CrossData.class);
		if (null == historyScoreData)
			return null;
		else
			return historyScoreData;

	}
}
