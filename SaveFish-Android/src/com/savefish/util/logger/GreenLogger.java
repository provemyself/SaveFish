package com.savefish.util.logger;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.savefish.constant.Constant;

public class GreenLogger {

	private Logger logger = null;

	private GreenLogger() {
		logger = Logger.getLogger(Constant.logger.LOGGER_NAME);
	}

	private static GreenLogger gl = null;

	public static GreenLogger getInstance() {
		if (null == gl)
			gl = new GreenLogger();
		return gl;
	}

	public void log(Level level, String msg) {
		logger.log(level, msg);
	}

	public void log(Level level, String msg, Object param1) {
		logger.log(level, msg, param1);
	}

	public void log(Level level, String msg, Object params[]) {
		logger.log(level, msg, params);
	}

	public void log(Level level, String msg, Throwable thrown) {
		logger.log(level, msg, thrown);
	}

	public void entering(String sourceClass, String sourceMethod) {
		logger.entering(sourceClass, sourceMethod);
	}

	public void logp(Level level, String sourceClass, String sourceMethod,
			String msg) {
		logger.logp(level, sourceClass, sourceMethod, msg);
	}

	public void logp(Level level, String sourceClass, String sourceMethod,
			String msg, Object param1) {
		logger.logp(level, sourceClass, sourceMethod, msg, param1);
	}

	public void logp(Level level, String sourceClass, String sourceMethod,
			String msg, Object params[]) {
		logger.logp(level, sourceClass, sourceMethod, msg, params);
	}

	public void logp(Level level, String sourceClass, String sourceMethod,
			String msg, Throwable thrown) {
		logger.logp(level, sourceClass, sourceMethod, msg, thrown);
	}

	public void entering(String sourceClass, String sourceMethod, Object param1) {
		logger.entering(sourceClass, sourceMethod, param1);
	}

	public void entering(String sourceClass, String sourceMethod,
			Object params[]) {
		logger.entering(sourceClass, sourceMethod, params);
	}

	public void exiting(String sourceClass, String sourceMethod) {
		logger.exiting(sourceClass, sourceMethod);
	}

	public void exiting(String sourceClass, String sourceMethod, Object result) {
		logger.exiting(sourceClass, sourceMethod, result);
	}

	public void severe(String msg) {
		logger.severe(msg);
	}

	public void warning(String msg) {
		logger.warning(msg);
	}

	public void info(String msg) {
		logger.info(msg);
	}

	public void setLevel(Level newLevel) throws SecurityException {
		logger.setLevel(newLevel);
	}
}
