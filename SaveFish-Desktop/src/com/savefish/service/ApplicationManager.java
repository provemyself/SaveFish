package com.savefish.service;

import java.util.logging.Level;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.savefish.assets.Assets;
import com.savefish.desktop.GreenGuardsDesktop;
import com.savefish.screens.LoadingScreen;
import com.savefish.util.logger.GreenLogger;
import com.savefish.util.logger.GreenLoggerManager;

public class ApplicationManager extends Game {

	public ApplicationManager() {
		GreenLoggerManager.filterLogByLevel(Level.INFO);
	}

	@Override
	public void create() {
		try {
			setScreen(LoadingScreen.getInstance(this));

		} catch (Exception e) {
			GreenLogger.getInstance().logp(Level.INFO,
					ApplicationManager.class.getName(), "create", e.toString(),
					e);
		}
	}

	@Override
	public void setScreen(Screen screen) {
		super.setScreen(screen);

		GreenLogger.getInstance().log(Level.INFO,
				"The current screen is " + screen.toString());
	}

	@Override
	public void dispose() {
		GreenLogger.getInstance().logp(Level.INFO,
				ApplicationManager.class.getName(), "dispose", "called!");

		disposeScreens();
		Assets.getInstance().dispose();
		GreenGuardsDesktop.saveFish.exit();

		GreenLogger.getInstance().log(Level.INFO, "Game exited sucessfully!");
	}

	private void disposeScreens() {
		for (Screen screen : InitializedScreen.screens)
			screen.dispose();
	}

}
