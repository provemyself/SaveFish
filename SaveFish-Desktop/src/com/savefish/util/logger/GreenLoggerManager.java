package com.savefish.util.logger;

public class GreenLoggerManager {

	public static void filterLogByLevel(int level) {
		GreenLogger.getInstance().setLevel(level);
	}
}
