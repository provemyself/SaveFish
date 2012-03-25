package com.savefish.service;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Logger;
import com.savefish.screens.LoadingScreen;
import com.savefish.util.logger.GreenLogger;
import com.savefish.util.logger.GreenLoggerManager;

public class ApplicationManager extends Game {

	public ApplicationManager() {
		GreenLoggerManager.filterLogByLevel(Logger.INFO);
	}

	@Override
	public void create() {
		try {
			setScreen(LoadingScreen.getInstance(this));
		} catch (Exception e) {
			GreenLogger.getInstance().info(e.toString(), e);
		}
	}
}
