package com.savefish.util;

import java.util.logging.Logger;

public class GreenLogger {

	private Logger logger;

	private static GreenLogger glogger = null;

	private GreenLogger() {
		this.setLogger(Logger.getAnonymousLogger());
	}

	public static GreenLogger getInstance() {
		if (null == glogger)
			glogger = new GreenLogger();
		return glogger;
	}

	/**
	 * @return the logger
	 */
	public Logger getLogger() {
		return logger;
	}

	/**
	 * @param logger
	 *            the logger to set
	 */
	private void setLogger(Logger logger) {
		if (null == this.logger)
			this.logger = logger;
	}
}
