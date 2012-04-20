package com.savefish.storage;

import com.google.gson.Gson;
import com.savefish.pointsystem.CurrentLevel;
import com.savefish.util.JsonHelper;

public class StoreCrossRecord {
	public static void store() {
		Gson gson = new Gson();
		JsonHelper.writeTojson(RecordFileDictionary.createInstance()
				.getStoreFile(CurrentLevel.level), gson.toJson(CurrentCrossData
				.getCurrentRecord()));
	}
}
