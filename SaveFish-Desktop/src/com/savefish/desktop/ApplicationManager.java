package com.savefish.desktop;

import java.util.logging.Level;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.savefish.assets.Assets;
import com.savefish.screens.LoadingScreen;
import com.savefish.service.LoadedManager;
import com.savefish.service.LoadedScreen;
import com.savefish.service.Managable;
import com.savefish.util.logger.GreenLogger;
import com.savefish.util.logger.GreenLoggerManager;

public class ApplicationManager extends Game {

	public ApplicationManager() {
		GreenLoggerManager.filterLogByLevel(Level.WARNING);
		
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

		this.disposeScreens();
		this.disposeManagers();
		Assets.getInstance().dispose();
		DesktopLauncher.saveFish.exit();

		GreenLogger.getInstance().log(Level.INFO, "Game exited sucessfully!");
	}

	private void disposeScreens() {
		for (Screen screen : LoadedScreen.screens)
			screen.dispose();
		LoadedScreen.screens = null;
	}

	private void disposeManagers() {
		for (Managable manager : LoadedManager.managers)
			manager.dispose();
		LoadedManager.managers = null;
	}

}
