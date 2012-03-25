package com.savefish.util.logger;

import com.badlogic.gdx.utils.Logger;
import com.savefish.constant.Constant;

public class GreenLogger {

	private Logger logger = null;

	private static GreenLogger gl = new GreenLogger();

	private GreenLogger() {
		logger = new Logger(Constant.logger.LOGGER_NAME);
	}

	public static GreenLogger getInstance() {
		return gl;
	}

	public void debug(String message) {
		logger.debug(message);
	}

	public void debug(String message, Exception exception) {
		logger.debug(message, exception);
	}

	public void error(String message) {
		logger.error(message);
	}

	public void error(String message, Throwable exception) {
		logger.error(message, exception);
	}

	public void info(String message) {
		logger.info(message);
	}

	public void info(String message, Exception exception) {
		logger.info(message, exception);
	}

	public int getLevel() {
		return logger.getLevel();
	}

	public void setLevel(int level) {
		logger.setLevel(level);
	}
}
