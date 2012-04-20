package com.savefish.storage;

import java.util.HashMap;

import com.savefish.pointsystem.GameLevel;

public class RecordFileDictionary {
	private HashMap<GameLevel, String> filesMap = new HashMap<GameLevel, String>();

	public static RecordFileDictionary createInstance() {
		return new RecordFileDictionary();
	}

	private RecordFileDictionary() {
		filesMap.put(GameLevel.createInstance(1, 1), "score_prevent_first");
		filesMap.put(GameLevel.createInstance(1, 2), "score_prevent_second");
		filesMap.put(GameLevel.createInstance(1, 3), "score_prevent_third");
		filesMap.put(GameLevel.createInstance(1, 4), "score_prevent_four");
		filesMap.put(GameLevel.createInstance(1, 5), "score_prevent_five");
		filesMap.put(GameLevel.createInstance(1, 6), "score_prevent_six");

		filesMap.put(GameLevel.createInstance(2, 1), "score_clear_first");
		filesMap.put(GameLevel.createInstance(2, 2), "score_clear_second");
		filesMap.put(GameLevel.createInstance(2, 3), "score_clear_third");
		filesMap.put(GameLevel.createInstance(2, 4), "score_clear_four");
		filesMap.put(GameLevel.createInstance(2, 5), "score_clear_five");
		filesMap.put(GameLevel.createInstance(2, 6), "score_clear_six");
	}

	public String getStoreFile(GameLevel level) {
		return filesMap.get(level);
	}

}
