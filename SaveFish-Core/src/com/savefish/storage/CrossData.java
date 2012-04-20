package com.savefish.storage;

public class CrossData {
	private String dateTime;
	private int crossScore;
	private int cleanIndex;

	public static CrossData createInstance(String dateTime, int crossScore,
			int cleanIndex) {
		return new CrossData(dateTime, crossScore, cleanIndex);
	}

	private CrossData(String dateTime, int crossScore, int cleanIndex) {
		super();
		this.dateTime = dateTime;
		this.crossScore = crossScore;
		this.cleanIndex = cleanIndex;
	}

	public String getDateTime() {
		return this.dateTime;
	}

	public int getCrossScore() {
		return this.crossScore;
	}

	public int getCleanIndex() {
		return this.cleanIndex;
	}
}
