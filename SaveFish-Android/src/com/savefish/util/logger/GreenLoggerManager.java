package com.savefish.util.logger;

import java.util.logging.Level;

public class GreenLoggerManager {
	public static void filterLogByLevel(Level level) {
		GreenLogger.getInstance().setLevel(level);
	}
}
